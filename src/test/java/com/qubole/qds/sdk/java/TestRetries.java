package com.qubole.qds.sdk.java;

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
import org.testng.annotations.Test;
import java.net.ServerSocket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TestRetries
{
    private static final int TEST_PORT = 10064;

    @Test
    public void testFailure() throws Exception
    {
        ServerSocket server = new ServerSocket(TEST_PORT);  // make sure port is free
        server.close();

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, 1);

        final AtomicBoolean hadRetry = new AtomicBoolean(false);
        DefaultQdsConfiguration.RetryConnectorAllocator retryConnectorAllocator = new DefaultQdsConfiguration.RetryConnectorAllocator()
        {
            @Override
            public RetryConnector newRetryConnector(Connector parentConnector, Retry retry)
            {
                return new RetryConnector(parentConnector, retry)
                {
                    @Override
                    protected Future<?> internalApply(ClientRequest request, AsyncConnectorCallback callback, AtomicInteger tryCount)
                    {
                        if ( tryCount.get() > 0 )
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
    public void testRetry() throws Exception
    {
        // TODO
    }
}
