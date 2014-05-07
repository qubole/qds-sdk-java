package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterStateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterState;
import java.util.concurrent.Future;

public class ClusterStateBuilderImpl implements ClusterStateBuilder
{
    private final QdsClient client;
    private final String labelOrId;

    @Override
    public Future<ClusterState> invoke()
    {
        return client.invokeRequest(null, null, ClusterState.class, labelOrId, "state");
    }

    ClusterStateBuilderImpl(QdsClient client, String labelOrId)
    {
        this.client = client;
        this.labelOrId = labelOrId;
    }
}
