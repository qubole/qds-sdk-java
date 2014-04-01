package com.qubole.qds.sdk.java.entities;

import java.util.List;
import java.util.Map;

public class HiveCommandResponse
{
    private Map<String, String> command;
    private int qbol_session_id;
    private String created_at;
    private int user_id;
    private String status;
    private String command_type;
    private int id;
    private int progress;
    private Map<String, String> meta_data;
    private String pool;
    private String template;
    private Map<String, String> resolved_macros;
    private String nominal_time;
    private String sequence_id;
    private int pid;
    private String label;
    private int num_result_dir;
    private boolean can_notify;
    private String start_time;
    private String end_time;
    private String path;
    private int timeout;
    private String submit_time;
    private String qlog;

    public HiveCommandResponse()
    {
    }

    public HiveCommandResponse(Map<String, String> command, int qbol_session_id, String created_at, String pool, int user_id, String status, String command_type, int id, int progress, Map<String, String> meta_data, String template, Map<String, String> resolved_macros, String nominal_time, String sequence_id, int pid, String label, int num_result_dir, boolean can_notify, String start_time, String end_time, String path, int timeout, String submit_time, String qlog)
    {
        this.command = command;
        this.qbol_session_id = qbol_session_id;
        this.created_at = created_at;
        this.pool = pool;
        this.user_id = user_id;
        this.status = status;
        this.command_type = command_type;
        this.id = id;
        this.progress = progress;
        this.meta_data = meta_data;
        this.template = template;
        this.resolved_macros = resolved_macros;
        this.nominal_time = nominal_time;
        this.sequence_id = sequence_id;
        this.pid = pid;
        this.label = label;
        this.num_result_dir = num_result_dir;
        this.can_notify = can_notify;
        this.start_time = start_time;
        this.end_time = end_time;
        this.path = path;
        this.timeout = timeout;
        this.submit_time = submit_time;
        this.qlog = qlog;
    }

    public String getQlog()
    {
        return qlog;
    }

    public void setQlog(String qlog)
    {
        this.qlog = qlog;
    }

    public String getSubmit_time()
    {
        return submit_time;
    }

    public void setSubmit_time(String submit_time)
    {
        this.submit_time = submit_time;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
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

    public boolean isCan_notify()
    {
        return can_notify;
    }

    public void setCan_notify(boolean can_notify)
    {
        this.can_notify = can_notify;
    }

    public int getNum_result_dir()
    {
        return num_result_dir;
    }

    public void setNum_result_dir(int num_result_dir)
    {
        this.num_result_dir = num_result_dir;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public String getSequence_id()
    {
        return sequence_id;
    }

    public void setSequence_id(String sequence_id)
    {
        this.sequence_id = sequence_id;
    }

    public String getNominal_time()
    {
        return nominal_time;
    }

    public void setNominal_time(String nominal_time)
    {
        this.nominal_time = nominal_time;
    }

    public Map<String, String> getResolved_macros()
    {
        return resolved_macros;
    }

    public void setResolved_macros(Map<String, String> resolved_macros)
    {
        this.resolved_macros = resolved_macros;
    }

    public String getTemplate()
    {
        return template;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }

    public String getPool()
    {
        return pool;
    }

    public void setPool(String pool)
    {
        this.pool = pool;
    }

    public Map<String, String> getCommand()
    {
        return command;
    }

    public void setCommand(Map<String, String> command)
    {
        this.command = command;
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getProgress()
    {
        return progress;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }

    public Map<String, String> getMeta_data()
    {
        return meta_data;
    }

    public void setMeta_data(Map<String, String> meta_data)
    {
        this.meta_data = meta_data;
    }
}
