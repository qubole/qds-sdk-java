package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommandMetaData
{
    private String results_resource;
    private String logs_resource;

    public CommandMetaData()
    {
    }

    public CommandMetaData(String results_resource, String logs_resource)
    {
        this.results_resource = results_resource;
        this.logs_resource = logs_resource;
    }

    public String getResults_resource()
    {
        return results_resource;
    }

    public void setResults_resource(String results_resource)
    {
        this.results_resource = results_resource;
    }

    public String getLogs_resource()
    {
        return logs_resource;
    }

    public void setLogs_resource(String logs_resource)
    {
        this.logs_resource = logs_resource;
    }
}
