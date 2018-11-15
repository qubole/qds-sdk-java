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
public class CanonicalQuery
{
    private String canonical_query;
    private String canonical_query_id;
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

    public String getCanonical_query_id() {
        return canonical_query_id;
    }

    public void setCanonical_query_id(String canonical_query_id) {
        this.canonical_query_id = canonical_query_id;
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
