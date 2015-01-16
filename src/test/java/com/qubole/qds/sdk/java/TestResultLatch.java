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
package com.qubole.qds.sdk.java;

import com.google.common.util.concurrent.Futures;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.details.RequestDetails;
import com.qubole.qds.sdk.java.details.ForPage;
import com.qubole.qds.sdk.java.details.MockClient;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.ResultValue;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("unchecked")
public class TestResultLatch
{
    @Test
    public void testBasic() throws Exception
    {
        QdsClient mockClient = new MockClient()
        {
            @Override
            public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
            {
                Command command = new Command();
                command.setStatus("done");
                return (Future)Futures.immediateFuture(command);
            }
        };
        ResultLatch resultLatch = new ResultLatch(mockClient, 1);
        Assert.assertTrue(resultLatch.await(1, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testWaiting() throws Exception
    {
        final AtomicInteger count = new AtomicInteger(4);
        QdsClient mockClient = new MockClient()
        {
            @Override
            public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
            {
                Command command = new Command();
                command.setStatus((count.decrementAndGet() <= 0) ? "done" : "waiting");
                return (Future)Futures.immediateFuture(command);
            }
        };
        ResultLatch resultLatch = new ResultLatch(mockClient, 1);
        Assert.assertTrue(resultLatch.await(10, TimeUnit.SECONDS));
        Assert.assertTrue(count.get() <= 0);
    }

    @Test
    public void testGetResult() throws Exception
    {
        QdsClient mockClient = new MockClient()
        {
            @Override
            public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
            {
                if ( responseType.equals(Command.class) )
                {
                    Command command = new Command();
                    command.setStatus("done");
                    return (Future)Futures.immediateFuture(command);
                }
                ResultValue resultValue = new ResultValue(true, "test", null);
                return (Future)Futures.immediateFuture(resultValue);
            }
        };
        ResultLatch resultLatch = new ResultLatch(mockClient, 1);
        ResultValue resultValue = resultLatch.awaitResult(10, TimeUnit.SECONDS);
        Assert.assertNotNull(resultValue);
        Assert.assertEquals(resultValue.getResults(), "test");
    }

    @Test
    public void testCallback() throws Exception
    {
        QdsClient mockClient = new MockClient()
        {
            @Override
            public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
            {
                if ( responseType.equals(Command.class) )
                {
                    Command command = new Command();
                    command.setStatus("done");
                    return (Future)Futures.immediateFuture(command);
                }
                ResultValue resultValue = new ResultValue(true, "test", null);
                return (Future)Futures.immediateFuture(resultValue);
            }
        };
        ResultLatch resultLatch = new ResultLatch(mockClient, 1);

        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicReference<ResultValue> resultValueRef = new AtomicReference<ResultValue>();
        ResultLatch.Callback callback = new ResultLatch.Callback()
        {
            @Override
            public void result(String queryId, ResultValue resultValue)
            {
                resultValueRef.set(resultValue);
                latch.countDown();
            }

            @Override
            public void error(String queryId, Exception e)
            {
                latch.countDown();
            }
        };
        resultLatch.callback(callback);

        Assert.assertTrue(latch.await(10, TimeUnit.SECONDS));
        Assert.assertNotNull(resultValueRef.get());
        Assert.assertEquals(resultValueRef.get().getResults(), "test");
    }

    @Test
    public void testBadStatus() throws Exception
    {
        QdsClient mockClient = new MockClient()
        {
            @Override
            public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
            {
                Command command = new Command();
                command.setStatus("foo");
                return (Future)Futures.immediateFuture(command);
            }
        };
        ResultLatch resultLatch = new ResultLatch(mockClient, 1);
        try
        {
            resultLatch.await(1, TimeUnit.MILLISECONDS);
            Assert.fail("Expected exception");
        }
        catch ( Exception e )
        {
            // correct behavior
        }
    }
}
