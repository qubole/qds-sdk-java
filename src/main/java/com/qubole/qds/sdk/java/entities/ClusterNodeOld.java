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
