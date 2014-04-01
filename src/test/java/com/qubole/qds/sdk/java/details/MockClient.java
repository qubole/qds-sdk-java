package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public class MockClient implements QdsClient
{
    private final BlockingQueue<InvokeDetails> results;

    public static class InvokeDetails
    {
        private final ForPage forPage;
        private final Object entity;
        private final Class<?> responseType;
        private final String[] additionalPaths;

        public InvokeDetails(ForPage forPage, Object entity, Class<?> responseType, String[] additionalPaths)
        {
            this.forPage = forPage;
            this.entity = entity;
            this.responseType = responseType;
            this.additionalPaths = additionalPaths;
        }

        public ForPage getForPage()
        {
            return forPage;
        }

        public Object getEntity()
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
    public void close()
    {
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, Object entity, Class<T> responseType, String... additionalPaths)
    {
        results.add(new InvokeDetails(forPage, entity, responseType, additionalPaths));
        return null;
    }
}
