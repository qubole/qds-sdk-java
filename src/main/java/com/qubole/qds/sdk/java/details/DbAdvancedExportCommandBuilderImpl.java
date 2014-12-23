package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbAdvancedExportCommandBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbAdvancedExportCommandBuilderImpl extends CommandBuilderImplBase implements DbAdvancedExportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbAdvancedExportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder export_dir(String export_dir)
    {
        node.put("export_dir", export_dir);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_mode(String db_update_mode)
    {
        node.put("db_update_mode", db_update_mode);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_keys(String db_update_keys)
    {
        node.put("db_update_keys", db_update_keys);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder fields_terminated_by(String fields_terminated_by)
    {
        node.put("fields_terminated_by", fields_terminated_by);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbAdvancedExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 2);
        node.put("command_type", "DbExportCommand");
    }
}
