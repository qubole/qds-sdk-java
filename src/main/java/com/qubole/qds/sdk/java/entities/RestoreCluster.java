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
public class RestoreCluster 
{
    private RestoreCommand command;
    private String command_source;
    private long pid;
    private String qlog;
    private String command_type;
    private long id;
    private long saved_query_mutable_id;
    private long user_id;
    private String label;
    private String template;
    private long qbol_session_id;
    private long progress;
    private boolean can_notify;
    private String status;
    private long account_id;
    private String start_time;
    private CommandMetaData meta_data;
    private long num_result_dir;
    private String submit_time;
    private String path;
    private String pool;
    private String resolved_macros;
    private String name;
    private String created_at;
    private String end_time;
    private String timeout;
    
    RestoreCluster()
    {
    }
    
    RestoreCluster(RestoreCommand command, String command_source, long pid, String qlog, String command_type, long id, long saved_query_mutable_id, long user_id, String label, String template, long qbol_session_id, long progress, boolean can_notify, String status, long account_id, String start_time, CommandMetaData meta_data, long num_result_dir, String submit_time, String path, String pool, String resolved_macros, String name, String created_at, String end_time, String timeout)
    {
        this.command = command;
        this.command_source = command_source;
        this.pid = pid;
        this.qlog = qlog;
        this.command_type = command_type;
        this.id = id;
        this.saved_query_mutable_id = saved_query_mutable_id;
        this.user_id = user_id;
        this.label = label;
        this.template = template;
        this.qbol_session_id = qbol_session_id;
        this.progress = progress;
        this.can_notify = can_notify;
        this.status = status;
        this.account_id = account_id;
        this.start_time = start_time;
        this.meta_data = meta_data;
        this.num_result_dir = num_result_dir;
        this.submit_time = submit_time;
        this.path = path;
        this.pool = pool;
        this.resolved_macros = resolved_macros;
        this.name = name;
        this.created_at = created_at;
        this.end_time = end_time;
        this.timeout = timeout;
    }
    
    public RestoreCommand getCommand()
    {
        return command;
    }

    public void setCommand(RestoreCommand command)
    {
        this.command = command;
    }
    
    public String getCommand_source()
    {
        return command_source;
    }

    public void setCommand_source(String command_source)
    {
        this.command_source = command_source;
    }
    
    public long getPid()
    {
        return pid;
    }

    public void setPid(long pid)
    {
        this.pid = pid;
    }
    
    public String getQlog()
    {
        return qlog;
    }

    public void setQlog(String qlog)
    {
        this.qlog = qlog;
    }
    
    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public long getSaved_query_mutable_id()
    {
        return saved_query_mutable_id;
    }

    public void setSaved_query_mutable_id(long saved_query_mutable_id)
    {
        this.saved_query_mutable_id = saved_query_mutable_id;
    }
    
    public long getUser_id()
    {
        return user_id;
    }

    public void setUser_id(long user_id)
    {
        this.user_id = user_id;
    }
    
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
    
    public String getTemplate()
    {
        return template;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }
    
    public long getQbol_session_id()
    {
        return qbol_session_id;
    }

    public void setQbol_session_id(long qbol_session_id)
    {
        this.qbol_session_id = qbol_session_id;
    }
    
    public long getProgress()
    {
        return progress;
    }

    public void setProgress(long progress)
    {
        this.progress = progress;
    }
    
    public boolean getCan_notify()
    {
        return can_notify;
    }

    public void setCan_notify(boolean can_notify)
    {
        this.can_notify = can_notify;
    }
    
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public long getAccount_id()
    {
        return account_id;
    }

    public void setAccount_id(long account_id)
    {
        this.account_id = account_id;
    }
    
    public String getStart_time()
    {
        return start_time;
    }

    public void setStart_time(String start_time)
    {
        this.start_time = start_time;
    }
    
    public CommandMetaData getMeta_data()
    {
        return meta_data;
    }

    public void setMeta_data(CommandMetaData meta_data)
    {
        this.meta_data = meta_data;
    }
    
    public long getNum_result_dir()
    {
        return num_result_dir;
    }

    public void setNum_result_dir(long num_result_dir)
    {
        this.num_result_dir = num_result_dir;
    }
    
    public String getSubmit_time()
    {
        return submit_time;
    }

    public void setSubmit_time(String submit_time)
    {
        this.submit_time = submit_time;
    }
    
    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
    
    public String getPool()
    {
        return pool;
    }

    public void setPool(String pool)
    {
        this.pool = pool;
    }
    
    public String getResolved_macros()
    {
        return resolved_macros;
    }

    public void setResolved_macros(String resolved_macros)
    {
        this.resolved_macros = resolved_macros;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }
    
    public String getEnd_time()
    {
        return end_time;
    }

    public void setEnd_time(String end_time)
    {
        this.end_time = end_time;
    }
    
    public String getTimeout()
    {
        return timeout;
    }

    public void setTimeout(String timeout)
    {
        this.timeout = timeout;
    }
}
