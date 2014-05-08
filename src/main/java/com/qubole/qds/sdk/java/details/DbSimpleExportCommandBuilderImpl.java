package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbSimpleExportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbSimpleExportCommand;

class DbSimpleExportCommandBuilderImpl extends CommandBuilderImplBase implements DbSimpleExportCommandBuilder
{
    private final DbSimpleExportCommand exportCommand = new DbSimpleExportCommand();

    @Override
    public DbSimpleExportCommandBuilder hive_table(String hive_table)
    {
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder dbtap_id(String dbtap_id)
    {
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_table(String db_table)
    {
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder partition_spec(String partition_spec)
    {
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_mode(String db_update_mode)
    {
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_keys(String db_update_keys)
    {
        return this;
    }

    @Override
    protected Object getEntity()
    {
        return exportCommand;
    }

    DbSimpleExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        exportCommand.setMode(1);
        exportCommand.setCommand_type("DbExportCommand");
    }
}
