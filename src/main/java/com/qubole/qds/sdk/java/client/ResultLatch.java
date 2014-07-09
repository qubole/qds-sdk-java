package com.qubole.qds.sdk.java.client;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResultLatch
{
    private final QdsClient client;
    private final String queryId;

    private static final ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("ResultLatch-%d").setDaemon(true).build());

    private static final int SLEEP_TICKS = 100;

    private static final String STATUS_DONE = "done";
    private static final String STATUS_WAITING = "waiting";
    private static final String STATUS_RUNNING = "running";

    public ResultLatch(QdsClient client, int queryId)
    {
        this(client, Integer.toString(queryId));
    }

    public ResultLatch(QdsClient client, String queryId)
    {
        this.client = Preconditions.checkNotNull(client, "client cannot be null");
        this.queryId = Preconditions.checkNotNull(queryId, "queryId cannot be null").trim();
    }

    public interface Callback
    {
        public void result(String queryId, ResultValue resultValue);

        public void error(String queryId, Exception e);
    }

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

    public void await() throws Exception
    {
        await(0, null);
    }

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
            Thread.sleep(SLEEP_TICKS);
        }
        return true;
    }

    public ResultValue awaitResult() throws Exception
    {
        await();
        return getResultValue();
    }

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
