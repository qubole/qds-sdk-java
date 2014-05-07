package com.qubole.qds.sdk.java.entities;

public class ClusterNodeOld
{
    private String state;
    private String ip;
    private String type;
    private String ami;
    private String alias;
    private String spot_instance;
    private String private_ip;
    private String instance;

    public ClusterNodeOld()
    {
    }

    public ClusterNodeOld(String state, String ip, String type, String ami, String alias, String spot_instance, String private_ip, String instance)
    {
        this.state = state;
        this.ip = ip;
        this.type = type;
        this.ami = ami;
        this.alias = alias;
        this.spot_instance = spot_instance;
        this.private_ip = private_ip;
        this.instance = instance;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAmi()
    {
        return ami;
    }

    public void setAmi(String ami)
    {
        this.ami = ami;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getSpot_instance()
    {
        return spot_instance;
    }

    public void setSpot_instance(String spot_instance)
    {
        this.spot_instance = spot_instance;
    }

    public String getPrivate_ip()
    {
        return private_ip;
    }

    public void setPrivate_ip(String private_ip)
    {
        this.private_ip = private_ip;
    }

    public String getInstance()
    {
        return instance;
    }

    public void setInstance(String instance)
    {
        this.instance = instance;
    }
}
