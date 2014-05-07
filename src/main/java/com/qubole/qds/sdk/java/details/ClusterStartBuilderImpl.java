package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterStartBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Message;
import com.qubole.qds.sdk.java.entities.State;
import java.util.concurrent.Future;

public class ClusterStartBuilderImpl implements ClusterStartBuilder
{
    private final QdsClient client;
    private final String labelOrId;

    @Override
    public Future<Message> invoke()
    {
        ClientEntity entity = new ClientEntity(new State("start"), ClientEntity.Method.PUT);
        return client.invokeRequest(null, entity, Message.class, "clusters", labelOrId, "state");
    }

    ClusterStartBuilderImpl(QdsClient client, String labelOrId)
    {
        this.client = client;
        this.labelOrId = labelOrId;
    }
}
