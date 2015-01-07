package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbSimpleImportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbSimpleImportCommandBuilderImpl extends CommandBuilderImplBase implements DbSimpleImportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbSimpleImportCommandBuilder hive_table(String hive_table)
    {
        node.put("hive_table", hive_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_where(String db_where)
    {
        node.put("db_where", db_where);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_parallelism(String db_parallelism)
    {
        node.put("db_parallelism", db_parallelism);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbSimpleImportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 1);
        node.put("command_type", "DbImportCommand");
    }
}
