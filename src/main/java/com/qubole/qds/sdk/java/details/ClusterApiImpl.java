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

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.*;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.AddNode;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.ClusterMetrics;
import com.qubole.qds.sdk.java.entities.ClusterState;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.NodeOperation;
import com.qubole.qds.sdk.java.entities.State;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<ClusterState> state(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterState>(client, RequestDetails.retry(), ClusterState.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<ClusterMetrics> metrics(String labelOrId, String metric, String hostname, String interval)
    {
        Map<String, String> params = new HashMap();
        if (metric != null) {
            params.put("metric", metric);
        }
        if (hostname != null) {
            params.put("hostname", hostname);
        }
        if (interval != null) {
            params.put("interval", interval);
        }
        RequestDetails requestDetails = new RequestDetails(null, RequestDetails.Method.GET, params);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<ClusterMetrics>(client, requestDetails,
            ClusterMetrics.class, "clusters", labelOrId, "metrics");
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
    public InvokableBuilder<Command> add_nodes(String labelOrId, int node_count)
    {
        RequestDetails entity = new RequestDetails(new AddNode(node_count), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<Command>(client, entity, Command.class, "clusters", labelOrId, "nodes");
    }

    @Override
    public InvokableBuilder<Command> replace_node(String labelOrId, String private_dns)
    {
        RequestDetails entity = new RequestDetails(new NodeOperation(private_dns, "replace"), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<Command>(client, entity, Command.class, "clusters", labelOrId, "nodes");
    }

    @Override
    public InvokableBuilder<Command> remove_node(String labelOrId, String private_dns)
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.DELETE, Maps.newHashMap(ImmutableMap.of("private_dns", private_dns)));
        return new GenericInvokableBuilderImpl<Command>(client, entity, Command.class, "clusters", labelOrId, "nodes");
    }

    public InvokableBuilder<ClusterItem> clone(String labelOrId, ClusterConfigBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters", labelOrId, "clone");
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
