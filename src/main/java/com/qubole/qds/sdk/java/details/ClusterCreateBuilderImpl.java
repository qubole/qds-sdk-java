package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterCreateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.concurrent.Future;

public class ClusterCreateBuilderImpl implements ClusterCreateBuilder
{
    private final QdsClient client;
    private final ClusterConfigBuilder configBuilder;

    @Override
    public Future<ClusterItem> invoke()
    {
        ClientEntity entity = new ClientEntity(configBuilder.toString(), ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, ClusterItem.class, "clusters");
    }

    ClusterCreateBuilderImpl(QdsClient client, ClusterConfigBuilder configBuilder)
    {
        this.client = client;
        this.configBuilder = configBuilder;
    }
}
