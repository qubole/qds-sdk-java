package com.qubole.qds.sdk.java.client.retry;

/**
 * Called to do retry sleeping
 */
public interface RetrySleeper
{
    /**
     * Sleep based on the given retry count (0 based)
     *
     * @param retryCount 0 based retry count
     * @throws InterruptedException if interrupted
     */
    public void sleep(int retryCount) throws InterruptedException;
}
