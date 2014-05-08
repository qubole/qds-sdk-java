package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.PrestoCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.PrestoCommand;

class PrestoCommandBuilderImpl extends CommandBuilderImplBase implements PrestoCommandBuilder
{
    private final PrestoCommand prestoCommand = new PrestoCommand("", "", "PrestoCommand");

    @Override
    public PrestoCommandBuilder script_location(String script_location)
    {
        prestoCommand.setScript_location(script_location);
        return this;
    }

    @Override
    public PrestoCommandBuilder query(String query)
    {
        prestoCommand.setQuery(query);
        return this;
    }

    @Override
    protected Object getEntity()
    {
        return prestoCommand;
    }

    PrestoCommandBuilderImpl(QdsClient client)
    {
        super(client);
    }
}
