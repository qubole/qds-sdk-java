package com.qubole.qds.sdk.java.client.retry;

import com.google.common.annotations.VisibleForTesting;
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
        return internalApply(request, 0);
    }

    @Override
    public Future<?> apply(ClientRequest request, final AsyncConnectorCallback callback)
    {
        Preconditions.checkNotNull(callback, "callback is assumed to be non null");
        return internalApply(request, callback, 0);
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

    private RetryPolicy.Mode getRetryMode(ClientRequest request)
    {
        return Boolean.parseBoolean(String.valueOf(request.getProperty(PROPERTY_ENABLE))) ? RetryPolicy.Mode.RETRY_ALL : RetryPolicy.Mode.RETRY_CONNECTION_ONLY;
    }

    @VisibleForTesting
    protected ClientResponse internalApply(ClientRequest request, int tryCount)
    {
        ClientResponse clientResponse;
        try
        {
            clientResponse = connector.apply(request);
        }
        catch ( ProcessingException e )
        {
            if ( retry.getRetryPolicy().shouldBeRetried(tryCount, null, e, getRetryMode(request)) )
            {
                return internalApply(request, tryCount + 1);
            }
            throw e;
        }

        if ( retry.getRetryPolicy().shouldBeRetried(tryCount, clientResponse, null, getRetryMode(request)) )
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

    @VisibleForTesting
    protected Future<?> internalApply(final ClientRequest request, final AsyncConnectorCallback callback, final int tryCount)
    {
        AsyncConnectorCallback localCallback = new AsyncConnectorCallback()
        {
            @Override
            public void response(ClientResponse response)
            {
                if ( !isRetry(request, response, null, callback, tryCount) )
                {
                    callback.response(response);
                }
            }

            @Override
            public void failure(Throwable failure)
            {
                if ( !isRetry(request, null, failure, callback, tryCount) )
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
        if ( retry.getRetryPolicy().shouldBeRetried(tryCount, response, failure, getRetryMode(request)) )
        {
            Runnable runnable = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        retry.getRetrySleeper().sleep(tryCount);
                        internalApply(request, callback, tryCount + 1);
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
