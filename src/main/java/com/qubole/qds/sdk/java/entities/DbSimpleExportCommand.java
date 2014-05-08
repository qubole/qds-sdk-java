package com.qubole.qds.sdk.java.entities;

public class DbSimpleExportCommand
{
    private String command_type;
    private String hive_table;
    private int mode;
    private String dbtap_id;
    private String db_table;
    private String partition_spec;
    private String db_update_mode;
    private String db_update_keys;

    public DbSimpleExportCommand()
    {
    }

    public DbSimpleExportCommand(String command_type, String hive_table, int mode, String dbtap_id, String db_table, String partition_spec, String db_update_mode, String db_update_keys)
    {
        this.command_type = command_type;
        this.hive_table = hive_table;
        this.mode = mode;
        this.dbtap_id = dbtap_id;
        this.db_table = db_table;
        this.partition_spec = partition_spec;
        this.db_update_mode = db_update_mode;
        this.db_update_keys = db_update_keys;
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

    public String getPartition_spec()
    {
        return partition_spec;
    }

    public void setPartition_spec(String partition_spec)
    {
        this.partition_spec = partition_spec;
    }

    public String getDb_update_mode()
    {
        return db_update_mode;
    }

    public void setDb_update_mode(String db_update_mode)
    {
        this.db_update_mode = db_update_mode;
    }

    public String getDb_update_keys()
    {
        return db_update_keys;
    }

    public void setDb_update_keys(String db_update_keys)
    {
        this.db_update_keys = db_update_keys;
    }
}
