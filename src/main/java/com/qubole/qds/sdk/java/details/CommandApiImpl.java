package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CommandApi;
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
        return new HiveCommandBuilder(client);
    }

    @Override
    public CommandHistoryBuilder history()
    {
        return new CommandHistoryBuilder(client);
    }
}
