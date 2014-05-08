package com.qubole.qds.sdk.java.entities;

public class DbSimpleImportCommand
{
    private String command_type;
    private String hive_table;
    private int mode;
    private String dbtap_id;
    private String db_table;
    private String db_where;
    private String db_parallelism;

    public DbSimpleImportCommand()
    {
    }

    public DbSimpleImportCommand(String command_type, String hive_table, int mode, String dbtap_id, String db_table, String db_where, String db_parallelism)
    {
        this.command_type = command_type;
        this.hive_table = hive_table;
        this.mode = mode;
        this.dbtap_id = dbtap_id;
        this.db_table = db_table;
        this.db_where = db_where;
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

    public String getDb_table()
    {
        return db_table;
    }

    public void setDb_table(String db_table)
    {
        this.db_table = db_table;
    }

    public String getDb_where()
    {
        return db_where;
    }

    public void setDb_where(String db_where)
    {
        this.db_where = db_where;
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
