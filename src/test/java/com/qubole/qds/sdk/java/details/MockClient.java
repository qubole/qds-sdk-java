package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Queues;
import com.qubole.qds.sdk.java.api.ClusterApi;
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
        private final ClientEntity entity;
        private final Class<?> responseType;
        private final GenericType<?> genericResponseType;
        private final InvocationCallback<?> callback;
        private final String[] additionalPaths;

        public InvokeDetails(ForPage forPage, ClientEntity entity, GenericType<?> genericResponseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = null;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = genericResponseType;
            this.callback = null;
        }

        public InvokeDetails(ForPage forPage, ClientEntity entity, Class<?> responseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = responseType;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = null;
            this.callback = null;
        }

        public InvokeDetails(ForPage forPage, ClientEntity entity, InvocationCallback<?> callback, String[] additionalPaths)
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

        public ClientEntity getEntity()
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
    public void close()
    {
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, InvocationCallback<T> callback, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, entity, callback, additionalPaths));
        return null;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, GenericType<T> responseType, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, entity, responseType, additionalPaths));
        return null;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, entity, responseType, additionalPaths));
        return null;
    }
}
