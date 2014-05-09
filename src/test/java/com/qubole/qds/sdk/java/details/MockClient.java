package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.DbTapsApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.client.QdsClient;
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
        private final String[] additionalPaths;

        public InvokeDetails(ForPage forPage, ClientEntity entity, GenericType<?> genericResponseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = null;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = genericResponseType;
        }

        public InvokeDetails(ForPage forPage, ClientEntity entity, Class<?> responseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = responseType;
            this.additionalPaths = additionalPaths;
            this.genericResponseType = null;
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
    public DbTapsApi dbTapsApi()
    {
        return new DbTapsApiImpl(this);
    }

    @Override
    public void close()
    {
    }

    @Override
    public ClusterConfigBuilder clusterConfig()
    {
        return new ClusterConfigBuilderImpl();
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
