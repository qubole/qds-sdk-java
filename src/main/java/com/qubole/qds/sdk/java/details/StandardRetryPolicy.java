package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import org.glassfish.jersey.client.ClientResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.ConnectException;

public class StandardRetryPolicy implements RetryPolicy
{
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
    public boolean shouldBeRetried(int retryCount, ClientResponse response, Throwable exception, Mode mode)
    {
        if ( retryCount >= maxRetries )
        {
            return false;
        }

        if ( (response != null) && (mode == Mode.RETRY_ALL) )
        {
            if ( response.getStatusInfo().getFamily() == Response.Status.Family.SERVER_ERROR )
            {
                return true;
            }
        }
        return shouldBeRetried(exception, mode);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    private boolean shouldBeRetried(Throwable exception, Mode mode)
    {
        if ( exception == null )
        {
            return false;
        }

        if ( mode == Mode.RETRY_ALL )
        {
            if ( exception instanceof IOException )
            {
                return true;
            }
        }
        else
        {
            if ( exception instanceof ConnectException )
            {
                return true;
            }
        }

        return shouldBeRetried(exception.getCause(), mode);
    }
}
