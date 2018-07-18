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

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.details.RequestDetails;
import com.qubole.qds.sdk.java.details.ForPage;
import com.qubole.qds.sdk.java.details.QdsClientImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
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
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
            {
                WebTarget webTarget = super.prepareTarget(forPage, entity, additionalPaths);
                webTargetReference.set(webTarget);
                return webTarget;
            }
        };

        client.command().history().invoke();
        WebTarget webTarget = webTargetReference.get();
        Assert.assertNotNull(webTarget);
        Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + "/" + configuration.getApiVersion() + "/commands"));
    }

    @Test
    public void testWebTargetWithParameters() throws URISyntaxException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
        final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
        QdsClientImpl client = new QdsClientImpl(configuration)
        {
            @Override
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
            {
                WebTarget webTarget = super.prepareTarget(forPage, entity, additionalPaths);
                webTargetReference.set(webTarget);
                return webTarget;
            }
        };
        String startDate = "2018-07-13T00:00:00Z";
        String endDate = "2018-07-13T23:59:59Z";
        int allUsers = 0;
        boolean qProps = false;
        client.command().startDate(startDate).endDate(endDate).allUsers(allUsers).includeQueryProperties(qProps).history().invoke();
        WebTarget webTarget = webTargetReference.get();
        Assert.assertNotNull(webTarget);
        String test = webTarget.getUri().toString();
        Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + "/" + configuration.getApiVersion() + "/commands?end_date="+endDate+"&include_query_properties="+qProps+"&all_users="+allUsers+"&start_date="+startDate));
    }


    @Test
    public void testWebTargetWithPaging() throws URISyntaxException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
        final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
        QdsClientImpl client = new QdsClientImpl(configuration)
        {
            @Override
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
            {
                return null;
            }

            @Override
            protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
            {
                WebTarget webTarget = super.prepareTarget(forPage, entity, additionalPaths);
                webTargetReference.set(webTarget);
                return webTarget;
            }
        };

        client.command().history().forPage(10, 20).invoke();
        WebTarget webTarget = webTargetReference.get();
        Assert.assertNotNull(webTarget);
        Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + "/" + configuration.getApiVersion() + "/commands?page=10&per_page=20"));
    }
}
