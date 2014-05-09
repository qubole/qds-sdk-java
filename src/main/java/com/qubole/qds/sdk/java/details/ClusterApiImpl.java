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
        return new GenericInvokableBuilderImpl<ClusterState>(client, null, ClusterState.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<List<ClusterItem>> list()
    {
        GenericType<List<ClusterItem>> type = new GenericType<List<ClusterItem>>(){};
        return new GenericInvokableBuilderImpl<List<ClusterItem>>(client, null, type, "clusters");
    }

    @Override
    public InvokableBuilder<ClusterItem> information(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterItem>(client, null, ClusterItem.class, "clusters", labelOrId);
    }

    @Override
    public InvokableBuilder<Message> start(String labelOrId)
    {
        ClientEntity entity = new ClientEntity(new State("start"), ClientEntity.Method.PUT);
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<Message> terminate(String labelOrId)
    {
        ClientEntity entity = new ClientEntity(new State("terminate"), ClientEntity.Method.PUT);
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "clusters", labelOrId, "state");
    }

    @Override
    public InvokableBuilder<ClusterItem> edit(String labelOrId, ClusterConfigBuilder configBuilder)
    {
        ClientEntity entity = new ClientEntity(configBuilder.toString(), ClientEntity.Method.PUT);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters", labelOrId);
    }

    @Override
    public InvokableBuilder<ClusterItem> create(ClusterConfigBuilder configBuilder)
    {
        ClientEntity entity = new ClientEntity(configBuilder.toString(), ClientEntity.Method.POST);
        return new GenericInvokableBuilderImpl<ClusterItem>(client, entity, ClusterItem.class, "clusters");
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
