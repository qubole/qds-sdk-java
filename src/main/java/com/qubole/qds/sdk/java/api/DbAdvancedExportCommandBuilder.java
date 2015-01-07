package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbAdvancedExportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbAdvancedExportCommandBuilder db_table(String db_table);

    public DbAdvancedExportCommandBuilder dbtap_id(String dbtap_id);

    public DbAdvancedExportCommandBuilder export_dir(String export_dir);

    public DbAdvancedExportCommandBuilder db_update_mode(String db_update_mode);

    public DbAdvancedExportCommandBuilder db_update_keys(String db_update_keys);

    public DbAdvancedExportCommandBuilder fields_terminated_by(String fields_terminated_by);

    public DbAdvancedExportCommandBuilder tags(String[] queryTags);
}
