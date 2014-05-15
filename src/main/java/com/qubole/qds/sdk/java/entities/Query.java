package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query
{
    private int id;
    private int cpu;
    private String created_at;
    private long fs_bytes_written;
    private long fs_bytes_read;
    private String command_type;
    private String submitted_by;
    private String status;
    private String command_summary;

    public Query()
    {
    }

    public Query(int id, int cpu, String created_at, long fs_bytes_written, long fs_bytes_read, String command_type, String submitted_by, String status, String command_summary)
    {
        this.id = id;
        this.cpu = cpu;
        this.created_at = created_at;
        this.fs_bytes_written = fs_bytes_written;
        this.fs_bytes_read = fs_bytes_read;
        this.command_type = command_type;
        this.submitted_by = submitted_by;
        this.status = status;
        this.command_summary = command_summary;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCpu()
    {
        return cpu;
    }

    public void setCpu(int cpu)
    {
        this.cpu = cpu;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
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

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public String getSubmitted_by()
    {
        return submitted_by;
    }

    public void setSubmitted_by(String submitted_by)
    {
        this.submitted_by = submitted_by;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCommand_summary()
    {
        return command_summary;
    }

    public void setCommand_summary(String command_summary)
    {
        this.command_summary = command_summary;
    }
}
