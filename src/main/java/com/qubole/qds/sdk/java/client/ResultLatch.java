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
package com.qubole.qds.sdk.java.client;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A utility for polling for a command result. Allows for blocking or
 * callback on a running query
 */
public class ResultLatch
{
    private final QdsClient client;
    private final String queryId;
    private final AtomicLong pollMs = new AtomicLong(DEFAULT_POLL_MS);

    private static final ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("ResultLatch-%d").setDaemon(true).build());

    private static final int DEFAULT_POLL_MS = 2500;

    private static final String STATUS_DONE = "done";
    private static final String STATUS_WAITING = "waiting";
    private static final String STATUS_RUNNING = "running";

    /**
     * @param client the client
     * @param queryId the query
     */
    public ResultLatch(QdsClient client, int queryId)
    {
        this(client, Integer.toString(queryId));
    }

    /**
     * @param client the client
     * @param queryId the query
     */
    public ResultLatch(QdsClient client, String queryId)
    {
        this.client = Preconditions.checkNotNull(client, "client cannot be null");
        this.queryId = Preconditions.checkNotNull(queryId, "queryId cannot be null").trim();
    }

    /**
     * Change the time that the query status is polled. The default
     * is {@link #DEFAULT_POLL_MS}.
     *
     * @param time polling time
     * @param unit time unit
     */
    public void setPollSleep(long time, TimeUnit unit)
    {
        pollMs.set(unit.toMillis(time));
    }

    /**
     * Callback interface.
     *
     * @see ResultLatch#callback(Callback)
     */
    public interface Callback
    {
        /**
         * Called when the result has been retrieved
         *
         * @param queryId the query
         * @param resultValue the result
         */
        public void result(String queryId, ResultValue resultValue);

        /**
         * Called if there was an error getting the result
         *
         * @param queryId the query
         * @param e the error
         */
        public void error(String queryId, Exception e);
    }

    /**
     * This method returns immediately and polls asynchronously for the result.
     * When the result is retrieved (or there is an error) the callback is called
     *
     * @param callback callback
     */
    public void callback(final Callback callback)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    callback.result(queryId, awaitResult());
                }
                catch ( Exception e )
                {
                    callback.error(queryId, e);
                }
            }
        };
        executorService.submit(runnable);
    }

    /**
     * Await indefinitely for the result
     *
     * @throws Exception errors
     */
    public void await() throws Exception
    {
        await(0, null);
    }

    /**
     * Await up to a maximum time for the result
     *
     * @param maxWait max wait time
     * @param timeUnit time unit
     * @return true if the result is ready, false if not or time has run out
     * @throws Exception errors
     */
    public boolean await(long maxWait, TimeUnit timeUnit) throws Exception
    {
        boolean hasWait = (timeUnit != null);
        long startMs = System.currentTimeMillis();
        for(;;)
        {
            String status = client.command().status(queryId).invoke().get().getStatus();
            if ( status.equalsIgnoreCase(STATUS_DONE) )
            {
                break;
            }
            if ( !status.equalsIgnoreCase(STATUS_RUNNING) && !status.equalsIgnoreCase(STATUS_WAITING) )
            {
                throw new Exception(String.format("Bad status for query %s: %s", queryId, status));
            }

            if ( hasWait )
            {
                long elapsedMs = System.currentTimeMillis() - startMs;
                if ( elapsedMs >= timeUnit.toMillis(maxWait) )
                {
                    return false;
                }
            }
            Thread.sleep(pollMs.get());
        }
        return true;
    }

    /**
     * Await indefinitely for the result
     *
     * @return the result
     * @throws Exception errors
     */
    public ResultValue awaitResult() throws Exception
    {
        await();
        return getResultValue();
    }

    /**
     * Await up to a maximum time for the result
     *
     * @param maxWait max wait time
     * @param timeUnit time unit
     * @return the result
     * @throws Exception errors
     */
    public ResultValue awaitResult(long maxWait, TimeUnit timeUnit) throws Exception
    {
        if ( !await(maxWait, timeUnit) )
        {
            throw new TimeoutException();
        }
        return getResultValue();
    }

    private ResultValue getResultValue() throws InterruptedException, java.util.concurrent.ExecutionException
    {
        return client.command().results(queryId).invoke().get();
    }
}
