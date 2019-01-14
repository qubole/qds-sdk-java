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
public class ClusterNode
{
    private String instance_type;
    private String ec2_instance_id;
    private boolean is_spot_instance;
    private String up_time;
    private String private_ip;
    private String last_seen_time;
    private String role;
    private String down_time;
    private String hostname;

    public ClusterNode()
    {
    }

    public ClusterNode(String instance_type, String ec2_instance_id, boolean is_spot_instance, String up_time, String private_ip, String last_seen_time, String role, String down_time, String hostname)
    {
        this.instance_type = instance_type;
        this.ec2_instance_id = ec2_instance_id;
        this.is_spot_instance = is_spot_instance;
        this.up_time = up_time;
        this.private_ip = private_ip;
        this.last_seen_time = last_seen_time;
        this.role = role;
        this.down_time = down_time;
        this.hostname = hostname;
    }

    public String getInstance_type()
    {
        return instance_type;
    }

    public void setInstance_type(String instance_type)
    {
        this.instance_type = instance_type;
    }

    public String getEc2_instance_id()
    {
        return ec2_instance_id;
    }

    public void setEc2_instance_id(String ec2_instance_id)
    {
        this.ec2_instance_id = ec2_instance_id;
    }

    public boolean isIs_spot_instance()
    {
        return is_spot_instance;
    }

    public void setIs_spot_instance(boolean is_spot_instance)
    {
        this.is_spot_instance = is_spot_instance;
    }

    public String getUp_time()
    {
        return up_time;
    }

    public void setUp_time(String up_time)
    {
        this.up_time = up_time;
    }

    public String getPrivate_ip()
    {
        return private_ip;
    }

    public void setPrivate_ip(String private_ip)
    {
        this.private_ip = private_ip;
    }

    public String getLast_seen_time()
    {
        return last_seen_time;
    }

    public void setLast_seen_time(String last_seen_time)
    {
        this.last_seen_time = last_seen_time;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getDown_time()
    {
        return down_time;
    }

    public void setDown_time(String down_time)
    {
        this.down_time = down_time;
    }

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }
}
