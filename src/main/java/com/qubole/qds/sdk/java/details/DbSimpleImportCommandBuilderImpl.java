package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbSimpleImportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.DbSimpleImportCommand;
import java.util.concurrent.Future;

class DbSimpleImportCommandBuilderImpl implements DbSimpleImportCommandBuilder
{
    private final QdsClient client;
    private final DbSimpleImportCommand importCommand = new DbSimpleImportCommand();

    @Override
    public DbSimpleImportCommandBuilder hive_table(String hive_table)
    {
        importCommand.setHive_table(hive_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder dbtap_id(String dbtap_id)
    {
        importCommand.setDbtap_id(dbtap_id);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_table(String db_table)
    {
        importCommand.setDb_table(db_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_where(String db_where)
    {
        importCommand.setDb_where(db_where);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_parallelism(String db_parallelism)
    {
        importCommand.setDb_parallelism(db_parallelism);
        return this;
    }

    @Override
    public Future<CommandResponse> invoke()
    {
        ClientEntity entity = new ClientEntity(importCommand, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, CommandResponse.class, "commands");
    }

    DbSimpleImportCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
        importCommand.setCommand_type("DbImportCommand");
        importCommand.setMode(1);
    }
}
