package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterEditBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.concurrent.Future;

public class ClusterEditBuilderImpl implements ClusterEditBuilder
{
    private final QdsClient client;
    private final String labelOrId;
    private final ClusterConfigBuilder configBuilder;

    @Override
    public Future<ClusterItem> invoke()
    {
        ClientEntity entity = new ClientEntity(configBuilder.toString(), ClientEntity.Method.PUT);
        return client.invokeRequest(null, entity, ClusterItem.class, "clusters", labelOrId);
    }

    ClusterEditBuilderImpl(QdsClient client, String labelOrId, ClusterConfigBuilder configBuilder)
    {
        this.client = client;
        this.labelOrId = labelOrId;
        this.configBuilder = configBuilder;
    }
}
