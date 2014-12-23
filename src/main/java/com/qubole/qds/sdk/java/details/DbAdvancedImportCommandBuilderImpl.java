package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbAdvancedImportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbAdvancedImportCommandBuilderImpl extends CommandBuilderImplBase implements DbAdvancedImportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbAdvancedImportCommandBuilder hive_table(String hive_table)
    {
        node.put("hive_table", hive_table);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_extract_query(String db_extract_query)
    {
        node.put("db_extract_query", db_extract_query);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_boundary_query(String db_boundary_query)
    {
        node.put("db_boundary_query", db_boundary_query);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_split_column(String db_split_column)
    {
        node.put("db_split_column", db_split_column);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_parallelism(String db_parallelism)
    {
        node.put("db_parallelism", db_parallelism);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbAdvancedImportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 2);
        node.put("command_type", "DbImportCommand");
    }
}
