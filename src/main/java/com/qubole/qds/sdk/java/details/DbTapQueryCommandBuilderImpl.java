package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.DbTapQueryCommandBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

import java.util.Map;

public class DbTapQueryCommandBuilderImpl extends CommandBuilderImplBase implements DbTapQueryCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final Map<String, String> macros = Maps.newHashMap();

    @Override
    public DbTapQueryCommandBuilder query(String query)
    {
        node.put("query", query);
        return this;
    }

    @Override
    public DbTapQueryCommandBuilder db_tap_id(int db_tap_id)
    {
        node.put("db_tap_id", db_tap_id);
        return this;
    }

    @Override
    public DbTapQueryCommandBuilder commandType(String commandType)
    {
        node.put("command_type", commandType);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbTapQueryCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "DbTapQueryCommand");
    }
}
