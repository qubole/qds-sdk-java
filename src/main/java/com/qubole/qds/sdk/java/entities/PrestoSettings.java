package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestoSettings
{
    private boolean enable_presto;
    private String custom_config;

    public PrestoSettings()
    {
    }

    public PrestoSettings(boolean enable_presto, String custom_config)
    {
        this.enable_presto = enable_presto;
        this.custom_config = custom_config;
    }

    public boolean isEnable_presto()
    {
        return enable_presto;
    }

    public void setEnable_presto(boolean enable_presto)
    {
        this.enable_presto = enable_presto;
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
