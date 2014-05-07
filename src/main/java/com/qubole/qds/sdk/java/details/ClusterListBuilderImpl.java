package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterListBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.concurrent.Future;

public class ClusterListBuilderImpl implements ClusterListBuilder
{
    private final QdsClient client;

    @Override
    public Future<List<ClusterItem>> invoke()
    {
        GenericType<List<ClusterItem>> type = new GenericType<List<ClusterItem>>(){};
        return client.invokeRequest(null, null, type, "clusters");
    }

    ClusterListBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
