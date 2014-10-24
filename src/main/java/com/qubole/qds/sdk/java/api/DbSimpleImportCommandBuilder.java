package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbSimpleImportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbSimpleImportCommandBuilder hive_table(String hive_table);

    public DbSimpleImportCommandBuilder dbtap_id(String dbtap_id);

    public DbSimpleImportCommandBuilder db_table(String db_table);

    public DbSimpleImportCommandBuilder db_where(String db_where);

    public DbSimpleImportCommandBuilder db_parallelism(String db_parallelism);
}
