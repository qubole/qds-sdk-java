package com.qubole.qds.sdk.java.entities;

import java.util.Map;

public class TableProperties
{
    private String interval;
    private String interval_unit;
    private Map<String, String> columns;

    public TableProperties()
    {
    }

    public TableProperties(String interval, String interval_unit, Map<String, String> columns)
    {
        this.interval = interval;
        this.interval_unit = interval_unit;
        this.columns = columns;
    }

    public String getInterval()
    {
        return interval;
    }

    public void setInterval(String interval)
    {
        this.interval = interval;
    }

    public String getInterval_unit()
    {
        return interval_unit;
    }

    public void setInterval_unit(String interval_unit)
    {
        this.interval_unit = interval_unit;
    }

    public Map<String, String> getColumns()
    {
        return columns;
    }

    public void setColumns(Map<String, String> columns)
    {
        this.columns = columns;
    }
}
