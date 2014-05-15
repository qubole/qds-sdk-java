package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CanonicalQuery
{
    private String canonical_query;
    private long fs_bytes_written;
    private long fs_bytes_read;
    private int frequency;
    private int cpu;
    private String recent_example;

    public CanonicalQuery()
    {
    }

    public CanonicalQuery(String canonical_query, long fs_bytes_written, long fs_bytes_read, int frequency, int cpu, String recent_example)
    {
        this.canonical_query = canonical_query;
        this.fs_bytes_written = fs_bytes_written;
        this.fs_bytes_read = fs_bytes_read;
        this.frequency = frequency;
        this.cpu = cpu;
        this.recent_example = recent_example;
    }

    public String getCanonical_query()
    {
        return canonical_query;
    }

    public void setCanonical_query(String canonical_query)
    {
        this.canonical_query = canonical_query;
    }

    public long getFs_bytes_written()
    {
        return fs_bytes_written;
    }

    public void setFs_bytes_written(long fs_bytes_written)
    {
        this.fs_bytes_written = fs_bytes_written;
    }

    public long getFs_bytes_read()
    {
        return fs_bytes_read;
    }

    public void setFs_bytes_read(long fs_bytes_read)
    {
        this.fs_bytes_read = fs_bytes_read;
    }

    public int getFrequency()
    {
        return frequency;
    }

    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    public int getCpu()
    {
        return cpu;
    }

    public void setCpu(int cpu)
    {
        this.cpu = cpu;
    }

    public String getRecent_example()
    {
        return recent_example;
    }

    public void setRecent_example(String recent_example)
    {
        this.recent_example = recent_example;
    }
}
