package com.qubole.qds.sdk.java.entities;

import java.util.List;

public class ClusterState
{
    private String state;
    private String last_health_check_action_at;
    private String start_at;
    private String down_at;
    private int cluster_id;
    private String terminate_reason;
    private List<ClusterNode> nodes;
    private String last_health_check_action;
    private int config_id;

    public ClusterState()
    {
    }

    public ClusterState(String state, String last_health_check_action_at, String start_at, String down_at, int cluster_id, String terminate_reason, List<ClusterNode> nodes, String last_health_check_action, int config_id)
    {
        this.state = state;
        this.last_health_check_action_at = last_health_check_action_at;
        this.start_at = start_at;
        this.down_at = down_at;
        this.cluster_id = cluster_id;
        this.terminate_reason = terminate_reason;
        this.nodes = nodes;
        this.last_health_check_action = last_health_check_action;
        this.config_id = config_id;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getLast_health_check_action_at()
    {
        return last_health_check_action_at;
    }

    public void setLast_health_check_action_at(String last_health_check_action_at)
    {
        this.last_health_check_action_at = last_health_check_action_at;
    }

    public String getStart_at()
    {
        return start_at;
    }

    public void setStart_at(String start_at)
    {
        this.start_at = start_at;
    }

    public String getDown_at()
    {
        return down_at;
    }

    public void setDown_at(String down_at)
    {
        this.down_at = down_at;
    }

    public int getCluster_id()
    {
        return cluster_id;
    }

    public void setCluster_id(int cluster_id)
    {
        this.cluster_id = cluster_id;
    }

    public String getTerminate_reason()
    {
        return terminate_reason;
    }

    public void setTerminate_reason(String terminate_reason)
    {
        this.terminate_reason = terminate_reason;
    }

    public List<ClusterNode> getNodes()
    {
        return nodes;
    }

    public void setNodes(List<ClusterNode> nodes)
    {
        this.nodes = nodes;
    }

    public String getLast_health_check_action()
    {
        return last_health_check_action;
    }

    public void setLast_health_check_action(String last_health_check_action)
    {
        this.last_health_check_action = last_health_check_action;
    }

    public int getConfig_id()
    {
        return config_id;
    }

    public void setConfig_id(int config_id)
    {
        this.config_id = config_id;
    }
}
