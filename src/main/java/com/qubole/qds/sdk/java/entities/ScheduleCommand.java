package com.qubole.qds.sdk.java.entities;

public class ScheduleCommand
{
    private boolean approx_mode;
    private String query;
    private boolean approx_aggregations;
    private boolean sample;
    private String loader_stable;
    private String script_location;
    private String loader_table_name;
    private String md_cmd;

    public ScheduleCommand()
    {
    }

    public ScheduleCommand(boolean approx_mode, String query, boolean approx_aggregations, boolean sample, String loader_stable, String script_location, String loader_table_name, String md_cmd)
    {
        this.approx_mode = approx_mode;
        this.query = query;
        this.approx_aggregations = approx_aggregations;
        this.sample = sample;
        this.loader_stable = loader_stable;
        this.script_location = script_location;
        this.loader_table_name = loader_table_name;
        this.md_cmd = md_cmd;
    }

    public boolean isApprox_mode()
    {
        return approx_mode;
    }

    public void setApprox_mode(boolean approx_mode)
    {
        this.approx_mode = approx_mode;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public boolean isApprox_aggregations()
    {
        return approx_aggregations;
    }

    public void setApprox_aggregations(boolean approx_aggregations)
    {
        this.approx_aggregations = approx_aggregations;
    }

    public boolean isSample()
    {
        return sample;
    }

    public void setSample(boolean sample)
    {
        this.sample = sample;
    }

    public String getLoader_stable()
    {
        return loader_stable;
    }

    public void setLoader_stable(String loader_stable)
    {
        this.loader_stable = loader_stable;
    }

    public String getScript_location()
    {
        return script_location;
    }

    public void setScript_location(String script_location)
    {
        this.script_location = script_location;
    }

    public String getLoader_table_name()
    {
        return loader_table_name;
    }

    public void setLoader_table_name(String loader_table_name)
    {
        this.loader_table_name = loader_table_name;
    }

    public String getMd_cmd()
    {
        return md_cmd;
    }

    public void setMd_cmd(String md_cmd)
    {
        this.md_cmd = md_cmd;
    }
}
