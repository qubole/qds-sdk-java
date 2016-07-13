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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.qubole.qds.sdk.java.api.AppApi;
import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.DbTapApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.api.ReportApi;
import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.client.retry.RetryConnector;
import com.qubole.qds.sdk.java.entities.SubCommands;
import com.qubole.qds.sdk.java.entities.SubCommandsDeserializer;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Map;
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
    private final DbTapApiImpl dbTapsApi;
    private final ReportApiImpl reportApi;
    private final SchedulerApiImpl schedulerApi;
    private final AppApiImpl appApi;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static ObjectMapper getMapper()
    {
        return MAPPER;
    }

    public QdsClientImpl(QdsConfiguration configuration)
    {
        this.configuration = Preconditions.checkNotNull(configuration, "configuration cannot be null");
        client = configuration.newClient();
        target = client.target(configuration.getApiEndpoint()).path(configuration.getApiVersion());
        commandApi = new CommandApiImpl(this);
        clusterApi = new ClusterApiImpl(this);
        hiveMetadataApi = new HiveMetadataApiImpl(this);
        dbTapsApi = new DbTapApiImpl(this);
        reportApi = new ReportApiImpl(this);
        schedulerApi = new SchedulerApiImpl(this);
        appApi = new AppApiImpl(this);
        
        // register the deserialization handler for composite command
        SimpleModule module =
                new SimpleModule("CommandResponseDeserializerModule",
                        new Version(1, 0, 0, null));
        SubCommandsDeserializer ccDeserializer = new SubCommandsDeserializer();
        module.addDeserializer(SubCommands.class, ccDeserializer);
        MAPPER.registerModule(module);
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
    public HiveMetadataApi hiveMetadata()
    {
        return hiveMetadataApi;
    }

    @Override
    public DbTapApi dbTaps()
    {
        return dbTapsApi;
    }

    @Override
    public ReportApi report()
    {
        return reportApi;
    }

    @Override
    public SchedulerApi scheduler()
    {
        return schedulerApi;
    }
    
    @Override
    public AppApi app()
    {
        return appApi;
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths)
    {
        AsyncInvoker invoker = prepareRequest(forPage, requestDetails, additionalPaths);
        return invokePreparedRequest(requestDetails, responseType, invoker);
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, GenericType<T> responseType, String... additionalPaths)
    {
        AsyncInvoker invoker = prepareRequest(forPage, requestDetails, additionalPaths);
        return invokePreparedRequest(requestDetails, responseType, invoker);
    }

    @Override
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, InvocationCallback<T> callback, String... additionalPaths)
    {
        AsyncInvoker invoker = prepareRequest(forPage, requestDetails, additionalPaths);
        return invokePreparedRequest(requestDetails, callback, invoker);
    }

    @VisibleForTesting
    protected <T> Future<T> invokePreparedRequest(RequestDetails entity, InvocationCallback<T> callback, AsyncInvoker invoker)
    {
        if (entity != null)
        {
            if (entity.getEntity() != null)
            {
                return invoker.method(entity.getMethod().name(), Entity.entity(entity.getEntity(), MediaType.APPLICATION_JSON_TYPE), callback);
            }
            return invoker.method(entity.getMethod().name(), callback);
        }
        return invoker.get(callback);
    }

    @VisibleForTesting
    protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
    {
        if (entity != null)
        {
            if (entity.getEntity() != null)
            {
                return invoker.method(entity.getMethod().name(), Entity.entity(entity.getEntity(), MediaType.APPLICATION_JSON_TYPE), responseType);
            }
            return invoker.method(entity.getMethod().name(), responseType);
        }
        return invoker.get(responseType);
    }

    @VisibleForTesting
    protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
    {
        if (entity != null)
        {
            if (entity.getEntity() != null)
            {
                return invoker.method(entity.getMethod().name(), Entity.entity(entity.getEntity(), MediaType.APPLICATION_JSON_TYPE), responseType);
            }
            return invoker.method(entity.getMethod().name(), responseType);
        }
        return invoker.get(responseType);
    }

    @VisibleForTesting
    protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
    {
        WebTarget localTarget = target;
        if (additionalPaths != null)
        {
            for (String path : additionalPaths)
            {
                localTarget = localTarget.path(path);
            }
        }

        if (forPage != null)
        {
            localTarget = localTarget.queryParam("page", forPage.getPage()).queryParam("per_page", forPage.getPerPage());
        }

        if ((entity != null) && (entity.getQueryParams() != null))
        {
            for (Map.Entry<String, String> entry : entity.getQueryParams().entrySet())
            {
                localTarget = localTarget.queryParam(entry.getKey(), entry.getValue());
            }
        }

        return localTarget;
    }

    @Override
    public void close()
    {
        if (isClosed.compareAndSet(false, true))
        {
            client.close();
        }
    }

    private AsyncInvoker prepareRequest(ForPage forPage, RequestDetails entity, String... additionalPaths)
    {
        WebTarget localTarget = prepareTarget(forPage, entity, additionalPaths);

        Invocation.Builder builder = localTarget.request().accept(MediaType.APPLICATION_JSON_TYPE);
        if (configuration.getApiToken() != null)
        {
            builder = builder.header("X-AUTH-TOKEN", configuration.getApiToken());
        }

        if ((entity != null) && entity.canBeRetried())
        {
            builder = builder.property(RetryConnector.PROPERTY_ENABLE, true);
        }
        
        return builder.async();
    }
}
