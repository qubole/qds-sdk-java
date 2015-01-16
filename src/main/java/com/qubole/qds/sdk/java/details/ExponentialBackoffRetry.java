/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        this(1000);
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
