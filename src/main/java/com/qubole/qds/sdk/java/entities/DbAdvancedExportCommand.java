package com.qubole.qds.sdk.java.entities;

public class DbAdvancedExportCommand
{
    private String command_type;
    private String db_table;
    private int mode;
    private String export_dir;
    private String dbtap_id;
    private String db_update_mode;
    private String db_update_keys;
    private String fields_terminated_by;

    public DbAdvancedExportCommand()
    {
    }

    public DbAdvancedExportCommand(String command_type, String db_table, int mode, String export_dir, String dbtap_id, String db_update_mode, String db_update_keys, String fields_terminated_by)
    {
        this.command_type = command_type;
        this.db_table = db_table;
        this.mode = mode;
        this.export_dir = export_dir;
        this.dbtap_id = dbtap_id;
        this.db_update_mode = db_update_mode;
        this.db_update_keys = db_update_keys;
        this.fields_terminated_by = fields_terminated_by;
    }

    public String getExport_dir()
    {
        return export_dir;
    }

    public void setExport_dir(String export_dir)
    {
        this.export_dir = export_dir;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public String getDb_table()
    {
        return db_table;
    }

    public void setDb_table(String db_table)
    {
        this.db_table = db_table;
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

    public String getFields_terminated_by()
    {
        return fields_terminated_by;
    }

    public void setFields_terminated_by(String fields_terminated_by)
    {
        this.fields_terminated_by = fields_terminated_by;
    }
}
