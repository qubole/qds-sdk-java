package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import org.glassfish.jersey.client.ClientResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.util.logging.Logger;

public class StandardRetryPolicy implements RetryPolicy
{
    private static final Logger log = Logger.getLogger(StandardRetryPolicy.class.getName());

    private final int maxRetries;

    private static final int DEFAULT_MAX_RETRIES = 3;

    public StandardRetryPolicy()
    {
        this(DEFAULT_MAX_RETRIES);
    }

    public StandardRetryPolicy(int maxRetries)
    {
        this.maxRetries = maxRetries;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean shouldBeRetried(URI uri, int retryCount, ClientResponse response, Throwable exception, Mode mode)
    {
        if ( retryCount >= maxRetries )
        {
            log.warning(String.format("Retries exceeded. retryCount: %d - maxRetries: %d", retryCount, maxRetries));
            return false;
        }

        if ( (response != null) && (mode == Mode.RETRY_ALL) )
        {
            if ( response.getStatusInfo().getFamily() == Response.Status.Family.SERVER_ERROR )
            {
                log.info(String.format("Retrying request due to Status %d. retryCount: %d - request: %s", response.getStatus(), retryCount, uri));
                return true;
            }
        }
        return shouldBeRetried(uri, exception, mode);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    private boolean shouldBeRetried(URI uri, Throwable exception, Mode mode)
    {
        if ( exception == null )
        {
            return false;
        }

        if ( mode == Mode.RETRY_ALL )
        {
            if ( exception instanceof IOException )
            {
                log.info(String.format("Retrying request due to exception %s. request: %s", exception.getClass().getSimpleName(), uri));
                return true;
            }
        }
        else
        {
            if ( exception instanceof ConnectException )
            {
                log.info(String.format("Retrying request due to exception %s. request: %s", exception.getClass().getSimpleName(), uri));
                return true;
            }
        }

        return shouldBeRetried(uri, exception.getCause(), mode);
    }
}
