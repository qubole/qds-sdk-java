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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HiveTable
{
    private String initial_instance;
    private String window_end;
    private String name;
    private Interval interval;
    private String time_zone;
    private String window_start;
    private Map<String, List<String>> columns;

    public HiveTable()
    {
    }

    public HiveTable(String initial_instance, String window_end, String name, Interval interval, String time_zone, String window_start, Map<String, List<String>> columns)
    {
        this.initial_instance = initial_instance;
        this.window_end = window_end;
        this.name = name;
        this.interval = interval;
        this.time_zone = time_zone;
        this.window_start = window_start;
        this.columns = columns;
    }

    public String getInitial_instance()
    {
        return initial_instance;
    }

    public void setInitial_instance(String initial_instance)
    {
        this.initial_instance = initial_instance;
    }

    public String getWindow_end()
    {
        return window_end;
    }

    public void setWindow_end(String window_end)
    {
        this.window_end = window_end;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Interval getInterval()
    {
        return interval;
    }

    public void setInterval(Interval interval)
    {
        this.interval = interval;
    }

    public String getTime_zone()
    {
        return time_zone;
    }

    public void setTime_zone(String time_zone)
    {
        this.time_zone = time_zone;
    }

    public String getWindow_start()
    {
        return window_start;
    }

    public void setWindow_start(String window_start)
    {
        this.window_start = window_start;
    }

    public Map<String, List<String>> getColumns()
    {
        return columns;
    }

    public void setColumns(Map<String, List<String>> columns)
    {
        this.columns = columns;
    }
}
