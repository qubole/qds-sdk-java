/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query
{
    private long id;
    private long cpu;
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

    public Query(long id, long cpu, String created_at, long fs_bytes_written, long fs_bytes_read, String command_type, String submitted_by, String status, String command_summary)
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

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getCpu()
    {
        return cpu;
    }

    public void setCpu(long cpu)
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
