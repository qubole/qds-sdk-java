package com.qubole.qds.sdk.java.entities;

public class DbAdvancedImportCommand
{
    private String command_type;
    private String hive_table;
    private int mode;
    private String dbtap_id;
    private String db_extract_query;
    private String db_boundary_query;
    private String db_split_column;
    private String db_parallelism;

    public DbAdvancedImportCommand()
    {
    }

    public DbAdvancedImportCommand(String command_type, String hive_table, int mode, String dbtap_id, String db_extract_query, String db_boundary_query, String db_split_column, String db_parallelism)
    {
        this.command_type = command_type;
        this.hive_table = hive_table;
        this.mode = mode;
        this.dbtap_id = dbtap_id;
        this.db_extract_query = db_extract_query;
        this.db_boundary_query = db_boundary_query;
        this.db_split_column = db_split_column;
        this.db_parallelism = db_parallelism;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public String getHive_table()
    {
        return hive_table;
    }

    public void setHive_table(String hive_table)
    {
        this.hive_table = hive_table;
    }

    public int getMode()
    {
        return mode;
    }

    public void setMode(int mode)
    {
        this.mode = mode;
    }

    public String getDbtap_id()
    {
        return dbtap_id;
    }

    public void setDbtap_id(String dbtap_id)
    {
        this.dbtap_id = dbtap_id;
    }

    public String getDb_extract_query()
    {
        return db_extract_query;
    }

    public void setDb_extract_query(String db_extract_query)
    {
        this.db_extract_query = db_extract_query;
    }

    public String getDb_boundary_query()
    {
        return db_boundary_query;
    }

    public void setDb_boundary_query(String db_boundary_query)
    {
        this.db_boundary_query = db_boundary_query;
    }

    public String getDb_split_column()
    {
        return db_split_column;
    }

    public void setDb_split_column(String db_split_column)
    {
        this.db_split_column = db_split_column;
    }

    public String getDb_parallelism()
    {
        return db_parallelism;
    }

    public void setDb_parallelism(String db_parallelism)
    {
        this.db_parallelism = db_parallelism;
    }
}
