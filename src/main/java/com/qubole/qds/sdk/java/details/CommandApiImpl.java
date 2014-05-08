package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.CommandHistoryBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.Invokable;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Command;

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
    public CommandHistoryBuilder history()
    {
        return new CommandHistoryBuilderImpl(client);
    }

    @Override
    public Invokable<Command> status(String queryId)
    {
        return new GenericInvokableBuilderImpl<Command>(client, null, Command.class, "commands", queryId);
    }
}
