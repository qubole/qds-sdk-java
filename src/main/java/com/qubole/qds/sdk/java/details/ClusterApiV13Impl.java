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

import com.qubole.qds.sdk.java.api.*;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterStateV13;
import com.qubole.qds.sdk.java.entities.ClusterV13;
import com.qubole.qds.sdk.java.entities.ClustersV13;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.State;
import javax.ws.rs.core.GenericType;

class ClusterApiV13Impl implements ClusterApiV13
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<ClusterStateV13> state(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterStateV13>(client, RequestDetails.retry(), ClusterStateV13.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<ClustersV13> list()
    {
        GenericType<ClustersV13> type = new GenericType<ClustersV13>(){};
        return new GenericInvokableBuilderImpl<ClustersV13>(client, RequestDetails.retry(), type, "clusters");
    }

    @Override
    public InvokableBuilder<ClusterV13> information(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterV13>(client, RequestDetails.retry(), ClusterV13.class, "clusters", labelOrId);
    }

    @Override
    public InvokableBuilder<Message> start(String labelOrId)
    {
        RequestDetails entity = new RequestDetails(new State("start"), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<Message> terminate(String labelOrId)
    {
        RequestDetails entity = new RequestDetails(new State("terminate"), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<ClusterV13> edit(String labelOrId, ClusterConfigBuilderV13 configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<ClusterV13>(client, entity, ClusterV13.class, "clusters", labelOrId);
    }

    @Override
    public InvokableBuilder<ClusterV13> create(ClusterConfigBuilderV13 configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<ClusterV13>(client, entity, ClusterV13.class, "clusters");
    }

    @Override
    public InvokableBuilder<Message> delete(String labelOrId)
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.DELETE);
        
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "clusters", labelOrId);
    }

    @Override
    public ClusterConfigBuilderV13 clusterConfig()
    {
        return new ClusterConfigBuilderV13Impl();
    }

    ClusterApiV13Impl(QdsClient client)
    {
        this.client = client;
    }
}
