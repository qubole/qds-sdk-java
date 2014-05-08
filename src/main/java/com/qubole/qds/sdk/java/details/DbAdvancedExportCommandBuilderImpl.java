package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbAdvancedExportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbAdvancedExportCommand;

class DbAdvancedExportCommandBuilderImpl extends CommandBuilderImplBase implements DbAdvancedExportCommandBuilder
{
    private final DbAdvancedExportCommand exportCommand = new DbAdvancedExportCommand();

    @Override
    public DbAdvancedExportCommandBuilder db_table(String db_table)
    {
        exportCommand.setDb_table(db_table);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder dbtap_id(String dbtap_id)
    {
        exportCommand.setDbtap_id(dbtap_id);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder export_dir(String export_dir)
    {
        exportCommand.setExport_dir(export_dir);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_mode(String db_update_mode)
    {
        exportCommand.setDb_update_mode(db_update_mode);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_keys(String db_update_keys)
    {
        exportCommand.setDb_update_keys(db_update_keys);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder fields_terminated_by(String fields_terminated_by)
    {
        exportCommand.setFields_terminated_by(fields_terminated_by);
        return this;
    }

    @Override
    protected Object getEntity()
    {
        return exportCommand;
    }

    DbAdvancedExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        exportCommand.setMode(2);
        exportCommand.setCommand_type("DbExportCommand");
    }
}
