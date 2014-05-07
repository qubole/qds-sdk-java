package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterStartBuilder;
import com.qubole.qds.sdk.java.api.ClusterTerminateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Message;
import java.util.concurrent.Future;

public class ClusterTerminateBuilderImpl implements ClusterTerminateBuilder
{
    private final QdsClient client;
    private final String labelOrId;

    @Override
    public Future<Message> invoke()
    {
        return client.invokeRequest(null, null, Message.class, "clusters", labelOrId, "terminate");
    }

    ClusterTerminateBuilderImpl(QdsClient client, String labelOrId)
    {
        this.client = client;
        this.labelOrId = labelOrId;
    }
}
