package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterInformationBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.concurrent.Future;

public class ClusterActionBuilderImpl implements ClusterInformationBuilder
{
    private final QdsClient client;
    private final String labelOrId;
    private final String action;

    @Override
    public Future<ClusterItem> invoke()
    {
        return client.invokeRequest(null, null, ClusterItem.class, "clusters", labelOrId, action);
    }

    ClusterActionBuilderImpl(QdsClient client, String labelOrId, String action)
    {
        this.client = client;
        this.labelOrId = labelOrId;
        this.action = action;
    }
}
