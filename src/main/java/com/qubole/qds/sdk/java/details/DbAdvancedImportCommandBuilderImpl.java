package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbAdvancedImportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbAdvancedImportCommand;

class DbAdvancedImportCommandBuilderImpl extends CommandBuilderImplBase implements DbAdvancedImportCommandBuilder
{
    private final DbAdvancedImportCommand importCommand = new DbAdvancedImportCommand();

    @Override
    public DbAdvancedImportCommandBuilder hive_table(String hive_table)
    {
        importCommand.setHive_table(hive_table);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder dbtap_id(String dbtap_id)
    {
        importCommand.setDbtap_id(dbtap_id);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_extract_query(String db_extract_query)
    {
        importCommand.setDb_extract_query(db_extract_query);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_boundary_query(String db_boundary_query)
    {
        importCommand.setDb_boundary_query(db_boundary_query);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_split_column(String db_split_column)
    {
        importCommand.setDb_split_column(db_split_column);
        return this;
    }

    @Override
    public DbAdvancedImportCommandBuilder db_parallelism(String db_parallelism)
    {
        importCommand.setDb_parallelism(db_parallelism);
        return this;
    }

    @Override
    protected Object getEntity()
    {
        return importCommand;
    }

    DbAdvancedImportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        importCommand.setMode(2);
        importCommand.setCommand_type("DbImportCommand");
    }
}
