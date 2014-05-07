package com.qubole.qds.sdk.java.entities;

import java.util.Map;

public class ClusterStatus
{
    private String state;
    private String launch_ts;
    private String uptime;
    private DataNode datanode;
    private String autoscale_instance_request;
    private String launch_time;
    private String jt_web;
    private DataNode tasktracker;
    private Map<String, ClusterNodeOld> nodes;

    public ClusterStatus()
    {
    }

    public ClusterStatus(String state, String launch_ts, String uptime, DataNode datanode, String autoscale_instance_request, String launch_time, String jt_web, DataNode tasktracker, Map<String, ClusterNodeOld> nodes)
    {
        this.state = state;
        this.launch_ts = launch_ts;
        this.uptime = uptime;
        this.datanode = datanode;
        this.autoscale_instance_request = autoscale_instance_request;
        this.launch_time = launch_time;
        this.jt_web = jt_web;
        this.tasktracker = tasktracker;
        this.nodes = nodes;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getLaunch_ts()
    {
        return launch_ts;
    }

    public void setLaunch_ts(String launch_ts)
    {
        this.launch_ts = launch_ts;
    }

    public String getUptime()
    {
        return uptime;
    }

    public void setUptime(String uptime)
    {
        this.uptime = uptime;
    }

    public DataNode getDatanode()
    {
        return datanode;
    }

    public void setDatanode(DataNode datanode)
    {
        this.datanode = datanode;
    }

    public String getAutoscale_instance_request()
    {
        return autoscale_instance_request;
    }

    public void setAutoscale_instance_request(String autoscale_instance_request)
    {
        this.autoscale_instance_request = autoscale_instance_request;
    }

    public String getLaunch_time()
    {
        return launch_time;
    }

    public void setLaunch_time(String launch_time)
    {
        this.launch_time = launch_time;
    }

    public String getJt_web()
    {
        return jt_web;
    }

    public void setJt_web(String jt_web)
    {
        this.jt_web = jt_web;
    }

    public DataNode getTasktracker()
    {
        return tasktracker;
    }

    public void setTasktracker(DataNode tasktracker)
    {
        this.tasktracker = tasktracker;
    }

    public Map<String, ClusterNodeOld> getNodes()
    {
        return nodes;
    }

    public void setNodes(Map<String, ClusterNodeOld> nodes)
    {
        this.nodes = nodes;
    }
}
