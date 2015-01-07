package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbSimpleExportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbSimpleExportCommandBuilder hive_table(String hive_table);

    public DbSimpleExportCommandBuilder dbtap_id(String dbtap_id);

    public DbSimpleExportCommandBuilder db_table(String db_table);

    public DbSimpleExportCommandBuilder partition_spec(String partition_spec);

    public DbSimpleExportCommandBuilder db_update_mode(String db_update_mode);

    public DbSimpleExportCommandBuilder db_update_keys(String db_update_keys);

    public DbSimpleExportCommandBuilder tags(String[] queryTags);
}
