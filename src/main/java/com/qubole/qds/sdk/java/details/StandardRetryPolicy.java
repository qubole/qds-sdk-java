package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import org.glassfish.jersey.client.ClientResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

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
    public boolean shouldBeRetried(int retryCount, ClientResponse response, Throwable exception)
    {
        if ( retryCount >= maxRetries )
        {
            return false;
        }

        if ( response != null )
        {
            if ( response.getStatusInfo().getFamily() == Response.Status.Family.SERVER_ERROR )
            {
                return true;
            }
        }
        return shouldBeRetried(exception);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    private boolean shouldBeRetried(Throwable exception)
    {
        if ( exception == null )
        {
            return false;
        }

        if ( exception instanceof IOException )
        {
            return true;
        }

        return shouldBeRetried(exception.getCause());
    }
}
