package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.details.ForPage;
import com.qubole.qds.sdk.java.details.QdsClientImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.WebTarget;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class TestClient
{
    @Test
    public void testWebTarget() throws URISyntaxException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
        final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
        QdsClientImpl client = new QdsClientImpl(configuration)
        {
            @Override
            protected <T> Future<T> invokePreparedRequest(Object entity, Class<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected WebTarget prepareTarget(ForPage forPage, String[] additionalPaths)
            {
                WebTarget webTarget = super.prepareTarget(forPage, additionalPaths);
                webTargetReference.set(webTarget);
                return webTarget;
            }
        };

        client.command().history().invoke();
        WebTarget webTarget = webTargetReference.get();
        Assert.assertNotNull(webTarget);
        Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + configuration.getApiVersion() + "/commands"));
    }

    @Test
    public void testWebTargetWithPaging() throws URISyntaxException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
        final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
        QdsClientImpl client = new QdsClientImpl(configuration)
        {
            @Override
            protected <T> Future<T> invokePreparedRequest(Object entity, Class<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected WebTarget prepareTarget(ForPage forPage, String[] additionalPaths)
            {
                WebTarget webTarget = super.prepareTarget(forPage, additionalPaths);
                webTargetReference.set(webTarget);
                return webTarget;
            }
        };

        client.command().history().forPage(10, 20).invoke();
        WebTarget webTarget = webTargetReference.get();
        Assert.assertNotNull(webTarget);
        Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + configuration.getApiVersion() + "/commands?page=10&per_page=20"));
    }
}
