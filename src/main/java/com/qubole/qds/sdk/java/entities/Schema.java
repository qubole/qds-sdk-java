package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schema
{
    private String table_name;
    private List<NameAndType> columns;

    public Schema()
    {
    }

    public Schema(String table_name)
    {
        this.table_name = table_name;
    }

    public Schema(String table_name, List<NameAndType> columns)
    {
        this.table_name = table_name;
        this.columns = columns;
    }

    public List<NameAndType> getColumns()
    {
        return columns;
    }

    public void setColumns(List<NameAndType> columns)
    {
        this.columns = columns;
    }

    public String getTable_name()
    {
        return table_name;
    }

    public void setTable_name(String table_name)
    {
        this.table_name = table_name;
    }

    @JsonAnySetter
    public void defaultSetter(String table_name, Map<String, List<NameAndType>> columns)
    {
        this.table_name = table_name;
        this.columns = columns.get("columns");
    }
}
