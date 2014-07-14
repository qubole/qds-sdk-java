package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.Retry;
import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import com.qubole.qds.sdk.java.client.retry.RetrySleeper;

public class StandardRetry implements Retry
{
    private final RetrySleeper retrySleeper = new ExponentialBackoffRetry();
    private final RetryPolicy retryPolicy = new StandardRetryPolicy();

    @Override
    public RetrySleeper getRetrySleeper()
    {
        return retrySleeper;
    }

    @Override
    public RetryPolicy getRetryPolicy()
    {
        return retryPolicy;
    }
}
