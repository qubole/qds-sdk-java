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
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.ClusterState;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.State;
import javax.ws.rs.core.GenericType;
import java.util.List;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<ClusterState> state(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterState>(client, RequestDetails.retry(), ClusterState.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<List<ClusterItem>> list()
    {
        GenericType<List<ClusterItem>> type = new GenericType<List<ClusterItem>>(){};
        return new GenericInvokableBuilderImpl<List<ClusterItem>>(client, RequestDetails.retry(), type, "clusters");
    }

    @Override
    public InvokableBuilder<ClusterItem> information(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterItem>(client, RequestDetails.retry(), ClusterItem.class, "clusters", labelOrId);
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
    public InvokableBuilder<ClusterItem> edit(String labelOrId, ClusterConfigBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters", labelOrId);
    }

    @Override
    public InvokableBuilder<ClusterItem> create(ClusterConfigBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters");
    }

    @Override
    public InvokableBuilder<ClusterItem> delete(String labelOrId)
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.DELETE);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters", labelOrId);
    }

    @Override
    public ClusterConfigBuilder clusterConfig()
    {
        return new ClusterConfigBuilderImpl();
    }

    ClusterApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
