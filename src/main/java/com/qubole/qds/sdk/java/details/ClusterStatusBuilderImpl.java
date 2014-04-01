package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterStatusBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterStatus;
import java.util.concurrent.Future;

public class ClusterStatusBuilderImpl implements ClusterStatusBuilder
{
    private final QdsClient client;

    @Override
    public Future<ClusterStatus> invoke()
    {
        return client.invokeRequest(null, null, ClusterStatus.class, "hadoop_cluster");
    }

    ClusterStatusBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
