package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbAdvancedImportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbAdvancedImportCommandBuilder hive_table(String hive_table);

    public DbAdvancedImportCommandBuilder dbtap_id(String dbtap_id);

    public DbAdvancedImportCommandBuilder db_extract_query(String db_extract_query);

    public DbAdvancedImportCommandBuilder db_boundary_query(String db_boundary_query);

    public DbAdvancedImportCommandBuilder db_split_column(String db_split_column);

    public DbAdvancedImportCommandBuilder db_parallelism(String db_parallelism);

    public DbAdvancedImportCommandBuilder tags(String[] queryTags);
}
