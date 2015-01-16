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
public class Schedule
{
    private int concurrency;
    private String time_unit;
    private ScheduleCommand command;
    private int user_id;
    private DependencyInfo dependency_info;
    private int time_out;
    private List<Map<String, String>> macros;
    private String end_time;
    private String start_time;
    private int frequency;
    private int id;
    private String time_zone;
    private String command_type;
    private String status;
    private int digest_time_minute;
    private String next_materialized_time;
    private boolean can_notify;
    private String template;
    private String name;
    private String label;
    private boolean is_digest;
    private int digest_time_hour;
    private Map<String, Map<String, String>> incremental;

    public Schedule()
    {
    }

    public Schedule(int concurrency, String time_unit, ScheduleCommand command, int user_id, DependencyInfo dependency_info, int time_out, List<Map<String, String>> macros, String end_time, String start_time, int frequency, int id, String time_zone, String command_type, String status, int digest_time_minute, String next_materialized_time, boolean can_notify, String template, String name, String label, boolean is_digest, int digest_time_hour, Map<String, Map<String, String>> incremental)
    {
        this.concurrency = concurrency;
        this.time_unit = time_unit;
        this.command = command;
        this.user_id = user_id;
        this.dependency_info = dependency_info;
        this.time_out = time_out;
        this.macros = macros;
        this.end_time = end_time;
        this.start_time = start_time;
        this.frequency = frequency;
        this.id = id;
        this.time_zone = time_zone;
        this.command_type = command_type;
        this.status = status;
        this.digest_time_minute = digest_time_minute;
        this.next_materialized_time = next_materialized_time;
        this.can_notify = can_notify;
        this.template = template;
        this.name = name;
        this.label = label;
        this.is_digest = is_digest;
        this.digest_time_hour = digest_time_hour;
        this.incremental = incremental;
    }

    public int getConcurrency()
    {
        return concurrency;
    }

    public void setConcurrency(int concurrency)
    {
        this.concurrency = concurrency;
    }

    public String getTime_unit()
    {
        return time_unit;
    }

    public void setTime_unit(String time_unit)
    {
        this.time_unit = time_unit;
    }

    public ScheduleCommand getCommand()
    {
        return command;
    }

    public void setCommand(ScheduleCommand command)
    {
        this.command = command;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public DependencyInfo getDependency_info()
    {
        return dependency_info;
    }

    public void setDependency_info(DependencyInfo dependency_info)
    {
        this.dependency_info = dependency_info;
    }

    public int getTime_out()
    {
        return time_out;
    }

    public void setTime_out(int time_out)
    {
        this.time_out = time_out;
    }

    public List<Map<String, String>> getMacros()
    {
        return macros;
    }

    public void setMacros(List<Map<String, String>> macros)
    {
        this.macros = macros;
    }

    public String getEnd_time()
    {
        return end_time;
    }

    public void setEnd_time(String end_time)
    {
        this.end_time = end_time;
    }

    public String getStart_time()
    {
        return start_time;
    }

    public void setStart_time(String start_time)
    {
        this.start_time = start_time;
    }

    public int getFrequency()
    {
        return frequency;
    }

    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTime_zone()
    {
        return time_zone;
    }

    public void setTime_zone(String time_zone)
    {
        this.time_zone = time_zone;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getDigest_time_minute()
    {
        return digest_time_minute;
    }

    public void setDigest_time_minute(int digest_time_minute)
    {
        this.digest_time_minute = digest_time_minute;
    }

    public String getNext_materialized_time()
    {
        return next_materialized_time;
    }

    public void setNext_materialized_time(String next_materialized_time)
    {
        this.next_materialized_time = next_materialized_time;
    }

    public boolean isCan_notify()
    {
        return can_notify;
    }

    public void setCan_notify(boolean can_notify)
    {
        this.can_notify = can_notify;
    }

    public String getTemplate()
    {
        return template;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public boolean isIs_digest()
    {
        return is_digest;
    }

    public void setIs_digest(boolean is_digest)
    {
        this.is_digest = is_digest;
    }

    public int getDigest_time_hour()
    {
        return digest_time_hour;
    }

    public void setDigest_time_hour(int digest_time_hour)
    {
        this.digest_time_hour = digest_time_hour;
    }

    public Map<String, Map<String, String>> getIncremental()
    {
        return incremental;
    }

    public void setIncremental(Map<String, Map<String, String>> incremental)
    {
        this.incremental = incremental;
    }
}
