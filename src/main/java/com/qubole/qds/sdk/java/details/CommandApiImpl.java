package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Commands;
import com.qubole.qds.sdk.java.entities.ResultValue;

class CommandApiImpl implements CommandApi
{
    private final QdsClient client;

    CommandApiImpl(QdsClient client)
    {
        this.client = client;
    }

    @Override
    public HiveCommandBuilder hive()
    {
        return new HiveCommandBuilderImpl(client);
    }

    @Override
    public PageableInvokableBuilder<Commands> history()
    {
        return new GenericPageableInvokableBuilderImpl<Commands>(client, null, Commands.class, "commands");
    }

    @Override
    public InvokableBuilder<Command> status(String queryId)
    {
        return new GenericInvokableBuilderImpl<Command>(client, null, Command.class, "commands", queryId);
    }

    @Override
    public InvokableBuilder<ResultValue> results(String queryId)
    {
        return new GenericInvokableBuilderImpl<ResultValue>(client, null, ResultValue.class, "commands", queryId, "results");
    }
}
