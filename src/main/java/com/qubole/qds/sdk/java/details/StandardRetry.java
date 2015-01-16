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
