package com.qubole.qds.sdk.java.client.retry;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.spi.AsyncConnectorCallback;
import org.glassfish.jersey.client.spi.Connector;
import javax.ws.rs.ProcessingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RetryConnector implements Connector
{
    private final Connector connector;
    private final Retry retry;
    private final ExecutorService retryService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("RetryConnector-%d").setDaemon(true).build());

    public static final String PROPERTY_ENABLE = RetryConnector.class.getName();

    public RetryConnector(Connector connector, Retry retry)
    {
        this.connector = connector;
        this.retry = retry;
    }

    @Override
    public ClientResponse apply(ClientRequest request)
    {
        return isEnabledForRequest(request) ? internalApply(request, 0) : connector.apply(request);
    }

    @Override
    public Future<?> apply(ClientRequest request, final AsyncConnectorCallback callback)
    {
        Preconditions.checkNotNull(callback, "callback is assumed to be non null");
        return isEnabledForRequest(request) ? internalApply(request, callback, 0) : connector.apply(request, callback);
    }

    @Override
    public String getName()
    {
        return connector.getName();
    }

    @Override
    public void close()
    {
        connector.close();
    }

    private boolean isEnabledForRequest(ClientRequest request)
    {
        return Boolean.parseBoolean(String.valueOf(request.getProperty(PROPERTY_ENABLE)));
    }

    private ClientResponse internalApply(ClientRequest request, int tryCount)
    {
        ClientResponse clientResponse = connector.apply(request);
        if ( retry.getRetryPolicy().shouldBeRetried(clientResponse, null) )
        {
            try
            {
                retry.getRetrySleeper().sleep(tryCount);
            }
            catch ( InterruptedException e )
            {
                Thread.currentThread().interrupt();
                throw new ProcessingException(e);
            }
            return internalApply(request, tryCount + 1);
        }
        return clientResponse;
    }

    private Future<?> internalApply(final ClientRequest request, final AsyncConnectorCallback callback, final int tryCount)
    {
        AsyncConnectorCallback localCallback = new AsyncConnectorCallback()
        {
            @Override
            public void response(ClientResponse response)
            {
                if ( !isRetry(request, response, null, this, tryCount) )
                {
                    callback.response(response);
                }
            }

            @Override
            public void failure(Throwable failure)
            {
                if ( !isRetry(request, null, failure, this, tryCount) )
                {
                    callback.failure(failure);
                }
            }
        };
        connector.apply(request, localCallback);
        return SettableFuture.create(); // just a dummy
    }

    private boolean isRetry(final ClientRequest request, ClientResponse response, Throwable failure, final AsyncConnectorCallback callback, final int tryCount)
    {
        if ( retry.getRetryPolicy().shouldBeRetried(response, failure) )
        {
            Runnable runnable = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        retry.getRetrySleeper().sleep(tryCount);
                        connector.apply(request, callback);
                    }
                    catch ( InterruptedException e )
                    {
                        callback.failure(e);
                    }
                }
            };
            retryService.submit(runnable);
            return true;
        }
        return false;
    }
}
