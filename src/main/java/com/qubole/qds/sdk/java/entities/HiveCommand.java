package com.qubole.qds.sdk.java.entities;

import java.util.List;
import java.util.Map;

public class HiveCommand
{
    private String query;
    private String script_location;
    private String command_type;
    private List<Map<String, String>> macros;
    private int sample_size;
    private double approx_mode_progress;
    private int approx_mode_max_rt;
    private int approx_mode_min_rt;
    private boolean approx_aggregations;

    public HiveCommand()
    {
    }

    public HiveCommand(String query, String script_location, String command_type, List<Map<String, String>> macros, int sample_size, double approx_mode_progress, int approx_mode_max_rt, int approx_mode_min_rt, boolean approx_aggregations)
    {
        this.query = query;
        this.script_location = script_location;
        this.command_type = command_type;
        this.macros = macros;
        this.sample_size = sample_size;
        this.approx_mode_progress = approx_mode_progress;
        this.approx_mode_max_rt = approx_mode_max_rt;
        this.approx_mode_min_rt = approx_mode_min_rt;
        this.approx_aggregations = approx_aggregations;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public String getScript_location()
    {
        return script_location;
    }

    public void setScript_location(String script_location)
    {
        this.script_location = script_location;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public List<Map<String, String>> getMacros()
    {
        return macros;
    }

    public void setMacros(List<Map<String, String>> macros)
    {
        this.macros = macros;
    }

    public int getSample_size()
    {
        return sample_size;
    }

    public void setSample_size(int sample_size)
    {
        this.sample_size = sample_size;
    }

    public double getApprox_mode_progress()
    {
        return approx_mode_progress;
    }

    public void setApprox_mode_progress(double approx_mode_progress)
    {
        this.approx_mode_progress = approx_mode_progress;
    }

    public int getApprox_mode_max_rt()
    {
        return approx_mode_max_rt;
    }

    public void setApprox_mode_max_rt(int approx_mode_max_rt)
    {
        this.approx_mode_max_rt = approx_mode_max_rt;
    }

    public int getApprox_mode_min_rt()
    {
        return approx_mode_min_rt;
    }

    public void setApprox_mode_min_rt(int approx_mode_min_rt)
    {
        this.approx_mode_min_rt = approx_mode_min_rt;
    }

    public boolean isApprox_aggregations()
    {
        return approx_aggregations;
    }

    public void setApprox_aggregations(boolean approx_aggregations)
    {
        this.approx_aggregations = approx_aggregations;
    }
}
