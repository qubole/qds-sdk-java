package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.CommandHistoryBuilder;
import com.qubole.qds.sdk.java.api.CommandStatusBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

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
    public CommandStatusBuilder status(String queryId)
    {
        return new CommandStatusBuilderImpl(client, queryId);
    }
}
