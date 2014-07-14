package com.qubole.qds.sdk.java.client.retry;

import javax.ws.rs.ProcessingException;

public class RetryExpirationException extends ProcessingException
{
    public RetryExpirationException(Throwable cause)
    {
        super(cause);
    }
}
