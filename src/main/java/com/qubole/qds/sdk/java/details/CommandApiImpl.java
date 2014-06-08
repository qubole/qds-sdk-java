package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.*;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.Commands;
import com.qubole.qds.sdk.java.entities.Status;
import org.codehaus.jackson.node.ObjectNode;

import javax.ws.rs.core.Response;

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
    public ResultsCommandBuilder results(String queryId)
    {
        return new ResultsCommandBuilderImpl(client, queryId);
    }

    @Override
    public InvokableBuilder<String> logs(String queryId)
    {
        return new GenericInvokableBuilderImpl<String>(client, null, String.class, "commands", queryId, "logs");
    }

    @Override
    public InvokableBuilder<Response> cancel(String queryId)
    {
        ClientEntity entity = new ClientEntity(new Status("kill"), ClientEntity.Method.PUT);
        return new GenericInvokableBuilderImpl<Response>(client, entity, Response.class, "commands", queryId);
    }

    @Override
    public HadoopCommandBuilder hadoop()
    {
        return new HadoopCommandBuilderImpl(client);
    }

    @Override
    public PigCommandBuilder pig()
    {
        return new PigCommandBuilderImpl(client);
    }

    @Override
    public DbSimpleImportCommandBuilder dbImportSimple()
    {
        return new DbSimpleImportCommandBuilderImpl(client);
    }

    @Override
    public DbAdvancedImportCommandBuilder dbImportAdvanced()
    {
        return new DbAdvancedImportCommandBuilderImpl(client);
    }

    @Override
    public DbSimpleExportCommandBuilder dbExportSimple()
    {
        return new DbSimpleExportCommandBuilderImpl(client);
    }

    @Override
    public DbAdvancedExportCommandBuilder dbExportAdvanced()
    {
        return new DbAdvancedExportCommandBuilderImpl(client);
    }

    @Override
    public PrestoCommandBuilder presto()
    {
        return new PrestoCommandBuilderImpl(client);
    }

    @Override
    public InvokableBuilder<CommandResponse> dbTapQuery(String query, int dbTapId) {
        ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
        node.put("command_type", "DbTapQueryCommand");
        node.put("query", query);
        node.put("db_tap_id", dbTapId);
        return new GenericInvokableBuilderImpl<CommandResponse>(client, new ClientEntity(node), CommandResponse.class, "commands");
    }

}
