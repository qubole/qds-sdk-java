package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.PigCommand;
import java.util.Map;
import java.util.concurrent.Future;

class PigCommandBuilderImpl implements PigCommandBuilder
{
    private final QdsClient client;
    private final PigCommand pigCommand = new PigCommand("", null, null, "PigCommand");

    @Override
    public PigCommandBuilder script_location(String script_location)
    {
        pigCommand.setScript_location(script_location);
        return this;
    }

    @Override
    public PigCommandBuilder parameters(Map<String, Object> parameters)
    {
        pigCommand.setParameters(parameters);
        return this;
    }

    @Override
    public PigCommandBuilder latin_statements(String latin_statements)
    {
        pigCommand.setLatin_statements(latin_statements);
        return this;
    }

    @Override
    public Future<CommandResponse> invoke()
    {
        ClientEntity entity = new ClientEntity(pigCommand, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, CommandResponse.class, "commands");
    }

    PigCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
