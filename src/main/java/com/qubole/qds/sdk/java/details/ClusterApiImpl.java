package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.*;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.ClusterState;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.State;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<ClusterState> state(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterState>(client, null, ClusterState.class, "clusters", labelOrId, "state");
    }

    @Override
    public ClusterListBuilder list()
    {
        return new ClusterListBuilderImpl(client);
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
    public ClusterEditBuilder edit(String labelOrId, ClusterConfigBuilder configBuilder)
    {
        return new ClusterEditBuilderImpl(client, labelOrId, configBuilder);
    }

    @Override
    public ClusterCreateBuilder create(ClusterConfigBuilder configBuilder)
    {
        return new ClusterCreateBuilderImpl(client, configBuilder);
    }

    ClusterApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
