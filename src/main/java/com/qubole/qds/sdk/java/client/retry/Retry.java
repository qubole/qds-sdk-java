package com.qubole.qds.sdk.java.client.retry;

public interface Retry
{
    public RetrySleeper getRetrySleeper();

    public RetryPolicy getRetryPolicy();
}
