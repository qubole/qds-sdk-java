package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CommandStatusBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Command;
import java.util.concurrent.Future;

public class CommandStatusBuilderImpl implements CommandStatusBuilder
{
    private final QdsClient client;
    private final String queryId;

    @Override
    public Future<Command> invoke()
    {
        return client.invokeRequest(null, null, Command.class, "commands", queryId);
    }

    CommandStatusBuilderImpl(QdsClient client, String queryId)
    {
        this.client = client;
        this.queryId = queryId;
    }
}
