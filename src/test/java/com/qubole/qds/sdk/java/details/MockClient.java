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

import com.google.common.collect.Queues;
import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.ClusterApiV13;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.DbTapApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.api.ReportApi;
import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public class MockClient implements QdsClient
{
    private final BlockingQueue<InvokeDetails> results;

    public static class InvokeDetails
    {
        private final ForPage forPage;
        private final RequestDetails entity;
        private final Class<?> responseType;
        private final GenericType<?> genericResponseType;
        private final InvocationCallback<?> callback;
        private final String[] additionalPaths;

        public InvokeDetails(ForPage forPage, RequestDetails entity, GenericType<?> genericResponseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = null;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = genericResponseType;
            this.callback = null;
        }

        public InvokeDetails(ForPage forPage, RequestDetails entity, Class<?> responseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = responseType;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = null;
            this.callback = null;
        }

        public InvokeDetails(ForPage forPage, RequestDetails entity, InvocationCallback<?> callback, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = null;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = null;
            this.callback = callback;
        }

        public InvocationCallback<?> getCallback()
        {
            return callback;
        }

        public GenericType<?> getGenericResponseType()
        {
            return genericResponseType;
        }

        public ForPage getForPage()
        {
            return forPage;
        }

        public RequestDetails getEntity()
        {
            return entity;
        }

        public Class<?> getResponseType()
        {
            return responseType;
        }

        public String[] getAdditionalPaths()
        {
            return additionalPaths;
        }
    }

    public MockClient()
    {
        this(Queues.<InvokeDetails>newLinkedBlockingQueue());
    }

    public MockClient(BlockingQueue<InvokeDetails> results)
    {
        this.results = results;
    }

    @Override
    public ClusterApi cluster()
    {
        return new ClusterApiImpl(this);
    }

    @Override
    public CommandApi command()
    {
        return new CommandApiImpl(this);
    }

    @Override
    public HiveMetadataApi hiveMetadata()
    {
        return new HiveMetadataApiImpl(this);
    }

    @Override
    public DbTapApi dbTaps()
    {
        return new DbTapApiImpl(this);
    }

    @Override
    public ReportApi report()
    {
        return new ReportApiImpl(this);
    }

    @Override
    public SchedulerApi scheduler()
    {
        return new SchedulerApiImpl(this);
    }
    
    @Override
    public ClusterApiV13 clusterV13()
    {
        return new ClusterApiV13Impl(this);
    }

    @Override
    public void close()
    {
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, InvocationCallback<T> callback, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, requestDetails, callback, additionalPaths));
        return null;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, GenericType<T> responseType, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, requestDetails, responseType, additionalPaths));
        return null;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, requestDetails, responseType, additionalPaths));
        return null;
    }
}
