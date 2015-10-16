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
    private RetrySleeper retrySleeper = new ExponentialBackoffRetry();
    private RetryPolicy retryPolicy = new StandardRetryPolicy();
    
    public StandardRetry(){
        this.retrySleeper = new ExponentialBackoffRetry();
        this.retryPolicy = new StandardRetryPolicy();
    }
    
    public StandardRetry(long exponentialBackOffBasetime, int maxRetriesPolicy){
        this.retrySleeper = new ExponentialBackoffRetry(exponentialBackOffBasetime);
        this.retryPolicy = new StandardRetryPolicy(maxRetriesPolicy);
    }
    
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
