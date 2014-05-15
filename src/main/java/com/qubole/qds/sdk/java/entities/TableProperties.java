package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TableProperties
{
    private String interval;
    private String interval_unit;
    private List<Map<String, String>> columns;

    public TableProperties()
    {
    }

    public TableProperties(String interval, String interval_unit, List<Map<String, String>> columns)
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

    public List<Map<String, String>> getColumns()
    {
        return columns;
    }

    public void setColumns(List<Map<String, String>> columns)
    {
        this.columns = columns;
    }
}
