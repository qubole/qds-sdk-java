package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterTerminateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.State;
import java.util.concurrent.Future;

public class ClusterTerminateBuilderImpl implements ClusterTerminateBuilder
{
    private final QdsClient client;
    private final String labelOrId;

    @Override
    public Future<Message> invoke()
    {
        ClientEntity entity = new ClientEntity(new State("terminate"), ClientEntity.Method.PUT);
        return client.invokeRequest(null, entity, Message.class, "clusters", labelOrId, "state");
    }

    ClusterTerminateBuilderImpl(QdsClient client, String labelOrId)
    {
        this.client = client;
        this.labelOrId = labelOrId;
    }
}
