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

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.retry.Retry;
import com.qubole.qds.sdk.java.client.retry.RetryConnector;
import com.qubole.qds.sdk.java.details.QdsClientImpl;
import com.qubole.qds.sdk.java.details.StandardRetry;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.spi.AsyncConnectorCallback;
import org.glassfish.jersey.client.spi.Connector;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestRetries
{
    private static final int TEST_PORT = 10064;
    private static final String TEST_VALUE = "test";

    private ServerSocket server;

    @AfterMethod
    public void tearDown()
    {
        if ( server != null )
        {
            try
            {
                server.close();
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            finally
            {
                server = null;
            }
        }
    }

    @Test
    public void testFailure() throws Exception
    {
        ServerSocket server = new ServerSocket(TEST_PORT);  // make sure port is free
        server.close();

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, 100);

        final AtomicBoolean hadRetry = new AtomicBoolean(false);
        DefaultQdsConfiguration.RetryConnectorAllocator retryConnectorAllocator = new DefaultQdsConfiguration.RetryConnectorAllocator()
        {
            @Override
            public RetryConnector newRetryConnector(Connector parentConnector, Retry retry)
            {
                return new RetryConnector(parentConnector, retry)
                {
                    @Override
                    protected Future<?> internalApply(ClientRequest request, AsyncConnectorCallback callback, int tryCount)
                    {
                        if ( tryCount > 0 )
                        {
                            hadRetry.set(true);
                        }
                        return super.internalApply(request, callback, tryCount);
                    }
                };
            }
        };
        DefaultQdsConfiguration configuration = new DefaultQdsConfiguration("http://localhost:" + TEST_PORT, "bar", clientConfig, new StandardRetry(), retryConnectorAllocator);
        QdsClient client = new QdsClientImpl(configuration);
        try
        {
            client.command().status("100").invoke().get();  // status is set to retry
            Assert.fail("Should have thrown an exception");
        }
        catch ( ExecutionException e )
        {
            // expected
        }

        Assert.assertTrue(hadRetry.get());
    }

    @Test
    public void testRetryAfterBadConnection() throws Exception
    {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, 100);

        final AtomicBoolean hadRetry = new AtomicBoolean(false);
        DefaultQdsConfiguration.RetryConnectorAllocator retryConnectorAllocator = new DefaultQdsConfiguration.RetryConnectorAllocator()
        {
            @Override
            public RetryConnector newRetryConnector(Connector parentConnector, Retry retry)
            {
                return new RetryConnector(parentConnector, retry)
                {
                    @Override
                    protected Future<?> internalApply(ClientRequest request, AsyncConnectorCallback callback, int tryCount)
                    {
                        if ( tryCount > 0 )
                        {
                            if ( tryCount == 1 )
                            {
                                startServer(false);
                            }
                            hadRetry.set(true);
                        }
                        return super.internalApply(request, callback, tryCount);
                    }
                };
            }
        };
        DefaultQdsConfiguration configuration = new DefaultQdsConfiguration("http://localhost:" + TEST_PORT, "bar", clientConfig, new StandardRetry(), retryConnectorAllocator);
        QdsClient client = new QdsClientImpl(configuration);
        String value = client.command().logs("100").invoke().get();  // logs is set to retry
        Assert.assertTrue(hadRetry.get());
        Assert.assertEquals(value, TEST_VALUE);
    }

    @Test
    public void testRetryAfterError() throws Exception
    {
        startServer(true);

        final AtomicBoolean hadRetry = new AtomicBoolean(false);
        DefaultQdsConfiguration.RetryConnectorAllocator retryConnectorAllocator = new DefaultQdsConfiguration.RetryConnectorAllocator()
        {
            @Override
            public RetryConnector newRetryConnector(Connector parentConnector, Retry retry)
            {
                return new RetryConnector(parentConnector, retry)
                {
                    @Override
                    protected Future<?> internalApply(ClientRequest request, AsyncConnectorCallback callback, int tryCount)
                    {
                        if ( tryCount > 0 )
                        {
                            hadRetry.set(true);
                        }
                        return super.internalApply(request, callback, tryCount);
                    }
                };
            }
        };
        DefaultQdsConfiguration configuration = new DefaultQdsConfiguration("http://localhost:" + TEST_PORT, "bar", new ClientConfig(), new StandardRetry(), retryConnectorAllocator);
        QdsClient client = new QdsClientImpl(configuration);
        String value = client.command().logs("100").invoke().get();  // logs is set to retry
        Assert.assertTrue(hadRetry.get());
        Assert.assertEquals(value, TEST_VALUE);
    }

    private void startServer(final boolean firstIsError)
    {
        try
        {
            server = new ServerSocket(TEST_PORT);  // make sure port is free
            Callable<Void> callable = new Callable<Void>()
            {
                @Override
                public Void call() throws Exception
                {
                    boolean isFirst = true;
                    boolean isDone = false;
                    while ( !isDone )
                    {
                        Socket socket = server.accept();
                        try
                        {
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            //noinspection StatementWithEmptyBody
                            while ( in.readLine().length() > 0 )
                            {
                            }

                            PrintStream out = new PrintStream(socket.getOutputStream());
                            if ( isFirst )
                            {
                                isFirst = false;
                                if ( firstIsError )
                                {
                                    out.println("HTTP/1.1 500 Internal Error");
                                    out.println();
                                    continue;
                                }
                            }

                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Length: " + TEST_VALUE.length());
                            out.println("Content-Type: text/plain");
                            out.println();
                            out.print(TEST_VALUE);
                            isDone = true;
                        }
                        finally
                        {
                            socket.close();
                        }
                    }
                    return null;
                }
            };
            Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setDaemon(true).build()).submit(callable);
        }
        catch ( IOException e )
        {
            throw new RuntimeException(e);
        }
    }
}
