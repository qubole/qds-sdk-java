package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.*;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterState;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public Invokable<ClusterState> state(String labelOrId)
    {
        return new GenericInvokableBuilderImpl<ClusterState>(client, null, ClusterState.class, "clusters", labelOrId, "state");
    }

    @Override
    public ClusterListBuilder list()
    {
        return new ClusterListBuilderImpl(client);
    }

    @Override
    public ClusterInformationBuilder information(String labelOrId)
    {
        return new ClusterInformationBuilderImpl(client, labelOrId);
    }

    @Override
    public ClusterStartBuilder start(String labelOrId)
    {
        return new ClusterStartBuilderImpl(client, labelOrId);
    }

    @Override
    public ClusterTerminateBuilder terminate(String labelOrId)
    {
        return new ClusterTerminateBuilderImpl(client, labelOrId);
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
