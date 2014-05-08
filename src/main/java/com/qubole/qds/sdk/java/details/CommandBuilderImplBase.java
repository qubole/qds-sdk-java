package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import java.util.concurrent.Future;

abstract class CommandBuilderImplBase implements InvokableBuilder<CommandResponse>
{
    private final QdsClient client;
    private final ClientEntity.Method method;

    @Override
    public final Future<CommandResponse> invoke()
    {
        ClientEntity entity = new ClientEntity(getEntity(), method);
        return client.invokeRequest(null, entity, CommandResponse.class, "commands");
    }

    protected abstract Object getEntity();

    protected CommandBuilderImplBase(QdsClient client)
    {
        this(client, ClientEntity.Method.POST);
    }

    protected CommandBuilderImplBase(QdsClient client, ClientEntity.Method method)
    {
        this.client = client;
        this.method = method;
    }
}
