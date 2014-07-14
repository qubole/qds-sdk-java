package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.retry.RetryExpirationException;
import com.qubole.qds.sdk.java.details.QdsClientImpl;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.ExecutionException;

public class TestRetries
{
    private static final int TEST_PORT = 10064;

    @Test(expectedExceptions = RetryExpirationException.class)
    public void testFailure() throws Throwable
    {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, 1);
        DefaultQdsConfiguration configuration = new DefaultQdsConfiguration("http://localhost:" + TEST_PORT, "bar", clientConfig);
        QdsClient client = new QdsClientImpl(configuration);
        try
        {
            client.command().status("100").invoke().get();  // status is set to retry
        }
        catch ( ExecutionException e )
        {
            throw e.getCause();
        }
        Assert.fail("Should have thrown an exception");
    }
}
