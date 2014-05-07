package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.ClusterInformationBuilder;
import com.qubole.qds.sdk.java.api.ClusterListBuilder;
import com.qubole.qds.sdk.java.api.ClusterStartBuilder;
import com.qubole.qds.sdk.java.api.ClusterStateBuilder;
import com.qubole.qds.sdk.java.api.ClusterStatusBuilder;
import com.qubole.qds.sdk.java.api.ClusterTerminateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public ClusterStatusBuilder status()
    {
        return new ClusterStatusBuilderImpl(client);
    }

    @Override
    public ClusterStateBuilder state(String labelOrId)
    {
        return new ClusterStateBuilderImpl(client, labelOrId);
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

    ClusterApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
