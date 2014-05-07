package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterListBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterList;
import java.util.concurrent.Future;

public class ClusterListBuilderImpl implements ClusterListBuilder
{
    private final QdsClient client;

    @Override
    public Future<ClusterList> invoke()
    {
        return client.invokeRequest(null, null, ClusterList.class, "clusters");
    }

    ClusterListBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
