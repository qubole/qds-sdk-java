package com.qubole.qds.sdk.java.entities;

import java.util.List;

public class ResultValue
{
    private boolean inline;
    private String results;
    private List<String> result_location;

    public ResultValue()
    {
    }

    public ResultValue(boolean inline, String results, List<String> result_location)
    {
        this.inline = inline;
        this.results = results;
        this.result_location = result_location;
    }

    public boolean isInline()
    {
        return inline;
    }

    public void setInline(boolean inline)
    {
        this.inline = inline;
    }

    public String getResults()
    {
        return results;
    }

    public void setResults(String results)
    {
        this.results = results;
    }

    public List<String> getResult_location()
    {
        return result_location;
    }

    public void setResult_location(List<String> result_location)
    {
        this.result_location = result_location;
    }
}
