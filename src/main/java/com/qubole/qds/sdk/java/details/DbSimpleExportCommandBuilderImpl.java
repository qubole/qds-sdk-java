package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbSimpleExportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbSimpleExportCommandBuilderImpl extends CommandBuilderImplBase implements DbSimpleExportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbSimpleExportCommandBuilder hive_table(String hive_table)
    {
        node.put("hive_table", hive_table);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder partition_spec(String partition_spec)
    {
        node.put("partition_spec", partition_spec);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_mode(String db_update_mode)
    {
        node.put("db_update_mode", db_update_mode);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_keys(String db_update_keys)
    {
        node.put("db_update_keys", db_update_keys);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbSimpleExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 1);
        node.put("command_type", "DbExportCommand");
    }
}
