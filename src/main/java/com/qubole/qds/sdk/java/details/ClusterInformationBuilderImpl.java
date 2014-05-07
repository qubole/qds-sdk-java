package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterInformationBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.concurrent.Future;

public class ClusterInformationBuilderImpl implements ClusterInformationBuilder
{
    private final QdsClient client;
    private final String labelOrId;

    @Override
    public Future<ClusterItem> invoke()
    {
        return client.invokeRequest(null, null, ClusterItem.class, "clusters", labelOrId);
    }

    ClusterInformationBuilderImpl(QdsClient client, String labelOrId)
    {
        this.client = client;
        this.labelOrId = labelOrId;
    }
}
