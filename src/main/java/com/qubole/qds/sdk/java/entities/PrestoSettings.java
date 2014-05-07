package com.qubole.qds.sdk.java.entities;

public class PrestoSettings
{
    private boolean is_presto_enabled;
    private String custom_config;

    public PrestoSettings()
    {
    }

    public PrestoSettings(boolean is_presto_enabled, String custom_config)
    {
        this.is_presto_enabled = is_presto_enabled;
        this.custom_config = custom_config;
    }

    public boolean isIs_presto_enabled()
    {
        return is_presto_enabled;
    }

    public void setIs_presto_enabled(boolean is_presto_enabled)
    {
        this.is_presto_enabled = is_presto_enabled;
    }

    public String getCustom_config()
    {
        return custom_config;
    }

    public void setCustom_config(String custom_config)
    {
        this.custom_config = custom_config;
    }
}
