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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Command
{
    private String status;
    private String pool;
    private String template;
    private String resolved_macros;
    private int qbol_session_id;
    private String created_at;
    private int user_id;
    private String nominal_time;
    private String command_type;
    private CommandMetaData meta_data;
    private SubCommands command;
    private String sequence_id;
    private int pid;
    private String label;
    private int num_result_dir;
    private boolean can_notify;
    private int progress;
    private long start_time;
    private long end_time;
    private String path;
    private int id;
    private String timeout;
    private long submit_time;
    private String qlog;
    private String name;
    private String[] tags;

    public Command()
    {
    }

    public Command(String status, String pool, String template, String resolved_macros, int qbol_session_id,
                   String created_at, int user_id, String nominal_time, String command_type, CommandMetaData meta_data,
                   SubCommands command, String sequence_id, int pid, String label, int num_result_dir,
                   boolean can_notify, int progress, long start_time, long end_time, String path, int id,
                   String timeout, long submit_time, String qlog, String name, String[] tags)
    {
        this.status = status;
        this.pool = pool;
        this.template = template;
        this.resolved_macros = resolved_macros;
        this.qbol_session_id = qbol_session_id;
        this.created_at = created_at;
        this.user_id = user_id;
        this.nominal_time = nominal_time;
        this.command_type = command_type;
        this.meta_data = meta_data;
        this.command = command;
        this.sequence_id = sequence_id;
        this.pid = pid;
        this.label = label;
        this.num_result_dir = num_result_dir;
        this.can_notify = can_notify;
        this.progress = progress;
        this.start_time = start_time;
        this.end_time = end_time;
        this.path = path;
        this.id = id;
        this.timeout = timeout;
        this.submit_time = submit_time;
        this.qlog = qlog;
        this.name = name;
        this.tags = tags;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getPool()
    {
        return pool;
    }

    public void setPool(String pool)
    {
        this.pool = pool;
    }

    public String getTemplate()
    {
        return template;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }

    public String getResolved_macros()
    {
        return resolved_macros;
    }

    public void setResolved_macros(String resolved_macros)
    {
        this.resolved_macros = resolved_macros;
    }

    public int getQbol_session_id()
    {
        return qbol_session_id;
    }

    public void setQbol_session_id(int qbol_session_id)
    {
        this.qbol_session_id = qbol_session_id;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getNominal_time()
    {
        return nominal_time;
    }

    public void setNominal_time(String nominal_time)
    {
        this.nominal_time = nominal_time;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public CommandMetaData getMeta_data()
    {
        return meta_data;
    }

    public void setMeta_data(CommandMetaData meta_data)
    {
        this.meta_data = meta_data;
    }

    public SubCommands getCommand()
    {
        return command;
    }

    public void setCommand(SubCommands command)
    {
        this.command = command;
    }

    public String getSequence_id()
    {
        return sequence_id;
    }

    public void setSequence_id(String sequence_id)
    {
        this.sequence_id = sequence_id;
    }

    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public int getNum_result_dir()
    {
        return num_result_dir;
    }

    public void setNum_result_dir(int num_result_dir)
    {
        this.num_result_dir = num_result_dir;
    }

    public boolean isCan_notify()
    {
        return can_notify;
    }

    public void setCan_notify(boolean can_notify)
    {
        this.can_notify = can_notify;
    }

    public int getProgress()
    {
        return progress;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }

    public long getStart_time()
    {
        return start_time;
    }

    public void setStart_time(long start_time)
    {
        this.start_time = start_time;
    }

    public long getEnd_time()
    {
        return end_time;
    }

    public void setEnd_time(long end_time)
    {
        this.end_time = end_time;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTimeout()
    {
        return timeout;
    }

    public void setTimeout(String timeout)
    {
        this.timeout = timeout;
    }

    public long getSubmit_time()
    {
        return submit_time;
    }

    public void setSubmit_time(long submit_time)
    {
        this.submit_time = submit_time;
    }

    public String getQlog()
    {
        return qlog;
    }

    public void setQlog(String qlog)
    {
        this.qlog = qlog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
