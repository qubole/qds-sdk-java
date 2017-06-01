/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        return new GenericPageableInvokableBuilderImpl<Commands>(client, RequestDetails.retry(), Commands.class, "commands");
    }

    @Override
    public InvokableBuilder<Command> status(String queryId)
    {
        return new GenericInvokableBuilderImpl<Command>(client, RequestDetails.retry(), Command.class, "commands", queryId);
    }

    @Override
    public ResultsCommandBuilder results(String queryId)
    {
        return new ResultsCommandBuilderImpl(client, queryId);
    }

    @Override
    public InvokableBuilder<String> logs(String queryId)
    {
        return new GenericInvokableBuilderImpl<String>(client, RequestDetails.retry(), String.class, "commands", queryId, "logs");
    }

    @Override
    public InvokableBuilder<Response> cancel(String queryId)
    {
        RequestDetails entity = new RequestDetails(new Status("kill"), RequestDetails.Method.PUT);
        entity.allowToBeRetried();
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
    public ShellCommandBuilder shell()
    {
        return new ShellCommandBuilderImpl(client);
    }

    @Override
    public SparkCommandBuilder spark()
    {
        return new SparkCommandBuilderImpl(client);
    }

    @Override
    public CompositeCommandBuilder composite()
    {
        return new CompositeCommandBuilderImpl(client);
    }

    @Override
    public InvokableBuilder<CommandResponse> dbTapQuery(String query, int dbTapId) {
        ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
        node.put("command_type", "DbTapQueryCommand");
        node.put("query", query);
        node.put("db_tap_id", dbTapId);
        return new GenericInvokableBuilderImpl<CommandResponse>(client, new RequestDetails(node), CommandResponse.class, "commands");
    }

    @Override
    public NotebookCommandBuilder notebook()
    {
        return new NotebookCommandBuilderImpl(client);
    }

}
