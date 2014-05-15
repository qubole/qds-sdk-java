package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FairSchedulerSettings
{
    private String default_pool;

    public FairSchedulerSettings()
    {
    }

    public FairSchedulerSettings(String default_pool)
    {
        this.default_pool = default_pool;
    }

    public String getDefault_pool()
    {
        return default_pool;
    }

    public void setDefault_pool(String default_pool)
    {
        this.default_pool = default_pool;
    }
}
