package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.retry.RetrySleeper;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ExponentialBackoffRetry implements RetrySleeper
{
    private final Random random = new Random();
    private final long baseSleepTimeMs;

    public ExponentialBackoffRetry()
    {
        this(100);
    }

    public ExponentialBackoffRetry(long baseSleepTimeMs)
    {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    @Override
    public void sleep(int retryCount) throws InterruptedException
    {
        long sleepMs = baseSleepTimeMs * Math.max(1, random.nextInt(1 << (retryCount + 1)));
        TimeUnit.MILLISECONDS.sleep(sleepMs);
    }
}
