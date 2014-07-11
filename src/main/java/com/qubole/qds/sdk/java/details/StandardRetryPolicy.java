package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import org.glassfish.jersey.client.ClientResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class StandardRetryPolicy implements RetryPolicy
{
    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean shouldBeRetried(ClientResponse response, Throwable exception)
    {
        if ( response != null )
        {
            if ( response.getStatusInfo().getFamily() == Response.Status.Family.SERVER_ERROR )
            {
                return true;
            }
        }
        return exception instanceof IOException;
    }
}
