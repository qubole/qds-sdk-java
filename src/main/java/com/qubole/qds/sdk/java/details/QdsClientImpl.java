package com.qubole.qds.sdk.java.details;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class QdsClientImpl implements QdsClient
{
    private final QdsConfiguration configuration;
    private final Client client;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final WebTarget target;
    private final CommandApiImpl commandApi;
    private final ClusterApiImpl clusterApi;
    private final HiveMetadataApiImpl hiveMetadataApi;

    public QdsClientImpl(QdsConfiguration configuration)
    {
        this.configuration = Preconditions.checkNotNull(configuration, "configuration cannot be null");
        client = configuration.newClient();
        target = client.target(configuration.getApiEndpoint()).path(configuration.getApiVersion());
        commandApi = new CommandApiImpl(this);
        clusterApi = new ClusterApiImpl(this);
        hiveMetadataApi = new HiveMetadataApiImpl(this);
    }

    @Override
    public ClusterApi cluster()
    {
        return clusterApi;
    }

    @Override
    public CommandApi command()
    {
        return commandApi;
    }

    @Override
    public ClusterConfigBuilder clusterConfig()
    {
        return new ClusterConfigBuilderImpl();
    }

    @Override
    public HiveMetadataApi hiveMetadata()
    {
        return hiveMetadataApi;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        AsyncInvoker invoker = prepareRequest(forPage, additionalPaths);
        return invokePreparedRequest(entity, responseType, invoker);
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, GenericType<T> responseType, String... additionalPaths)
    {
        AsyncInvoker invoker = prepareRequest(forPage, additionalPaths);
        return invokePreparedRequest(entity, responseType, invoker);
    }

    public AsyncInvoker prepareRequest(ForPage forPage, String... additionalPaths)
    {
        WebTarget localTarget = prepareTarget(forPage, additionalPaths);

        Invocation.Builder builder = localTarget.request().accept(MediaType.APPLICATION_JSON_TYPE);
        if ( configuration.getApiToken() != null )
        {
            builder = builder.header("X-AUTH-TOKEN", configuration.getApiToken());
        }

        return builder.async();
    }

    @VisibleForTesting
    protected <T> Future<T> invokePreparedRequest(ClientEntity entity, Class<T> responseType, AsyncInvoker invoker)
    {
        if ( entity != null )
        {
            return invoker.method(entity.getMethod().name(), Entity.entity(entity.getEntity(), MediaType.APPLICATION_JSON_TYPE), responseType);
        }
        return invoker.get(responseType);
    }

    @VisibleForTesting
    protected <T> Future<T> invokePreparedRequest(ClientEntity entity, GenericType<T> responseType, AsyncInvoker invoker)
    {
        if ( entity != null )
        {
            return invoker.method(entity.getMethod().name(), Entity.entity(entity.getEntity(), MediaType.APPLICATION_JSON_TYPE), responseType);
        }
        return invoker.get(responseType);
    }

    @VisibleForTesting
    protected WebTarget prepareTarget(ForPage forPage, String[] additionalPaths)
    {
        WebTarget localTarget = target;
        if ( additionalPaths != null )
        {
            for ( String path : additionalPaths )
            {
                localTarget = localTarget.path(path);
            }
        }

        if ( forPage != null )
        {
            localTarget = localTarget.queryParam("page", forPage.getPage()).queryParam("per_page", forPage.getPerPage());
        }
        return localTarget;
    }

    @Override
    public void close()
    {
        if ( isClosed.compareAndSet(false, true) )
        {
            client.close();
        }
    }
}
