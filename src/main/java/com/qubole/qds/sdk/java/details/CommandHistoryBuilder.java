package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.Invokable;
import com.qubole.qds.sdk.java.api.Pageable;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Commands;
import java.util.concurrent.Future;

public class CommandHistoryBuilder implements Pageable<CommandHistoryBuilder>, Invokable<Commands>
{
    private final QdsClient client;
    private ForPage forPage;

    @Override
    public Future<Commands> invoke()
    {
        return client.invokeRequest(forPage, null, Commands.class, "commands");
    }

    @Override
    public CommandHistoryBuilder forPage(int page, int perPage)
    {
        forPage = new ForPage(page, perPage);
        return this;
    }

    CommandHistoryBuilder(QdsClient client)
    {
        this.client = client;
    }
}
