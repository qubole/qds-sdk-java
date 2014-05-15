package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DependencyInfo
{
    private List<HiveTable> hive_tables;
    private List<String> files;

    public DependencyInfo()
    {
    }

    public DependencyInfo(List<HiveTable> hive_tables, List<String> files)
    {
        this.hive_tables = hive_tables;
        this.files = files;
    }

    public List<HiveTable> getHive_tables()
    {
        return hive_tables;
    }

    public void setHive_tables(List<HiveTable> hive_tables)
    {
        this.hive_tables = hive_tables;
    }

    public List<String> getFiles()
    {
        return files;
    }

    public void setFiles(List<String> files)
    {
        this.files = files;
    }
}
