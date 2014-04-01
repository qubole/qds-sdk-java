package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.Invokable;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterStatus;
import java.util.concurrent.Future;

public class ClusterStatusBuilder implements Invokable<ClusterStatus>
{
    private final QdsClient client;

    @Override
    public Future<ClusterStatus> invoke()
    {
        return client.invokeRequest(null, null, ClusterStatus.class, "hadoop_cluster");
    }

    ClusterStatusBuilder(QdsClient client)
    {
        this.client = client;
    }
}
