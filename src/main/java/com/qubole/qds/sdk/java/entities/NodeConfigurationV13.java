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

import java.util.Map;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeConfigurationV13
{   
    private String master_instance_type;
    private String slave_instance_type;
    private int initial_nodes;
    private int max_nodes;
    private String slave_request_type;
    private String fallback_to_ondemand;
    private String ebs_volume_type;
    private String ebs_volume_size;
    private int ebs_volume_count;
    private Map<String, String> custom_ec2_tags;
    private SpotInstanceSettingsV13 spot_instance_settings;
    private StableSpotInstanceSettingsV13 stable_spot_instance_settings;

    public NodeConfigurationV13()
    {
    }

    public NodeConfigurationV13(String master_instance_type, String slave_instance_type, int  initial_nodes, int max_nodes, String slave_request_type,String fallback_to_ondemand, String  ebs_volume_type, String ebs_volume_size, int ebs_volume_count, Map<String, String> custom_ec2_tags, SpotInstanceSettingsV13 spot_instance_settings, StableSpotInstanceSettingsV13 stable_spot_instance_settings)
    {
        this.master_instance_type = master_instance_type;
        this.slave_instance_type = slave_instance_type;
        this.initial_nodes = initial_nodes;
        this.max_nodes = max_nodes;
        this.slave_request_type = slave_request_type;
        this.fallback_to_ondemand = fallback_to_ondemand;
        this.ebs_volume_type = ebs_volume_type;
        this.ebs_volume_size = ebs_volume_size;
        this.ebs_volume_count = ebs_volume_count;
        this.custom_ec2_tags = custom_ec2_tags;
        this.spot_instance_settings = spot_instance_settings;
        this.stable_spot_instance_settings = stable_spot_instance_settings;
    } 

    public SpotInstanceSettingsV13 getSpot_instance_settings()
    {
        return spot_instance_settings;
    }

    public void setSpot_instance_settings(SpotInstanceSettingsV13 spot_instance_settings)
    {
        this.spot_instance_settings = spot_instance_settings;
    }
    
    public StableSpotInstanceSettingsV13 getStable_spot_instance_settings()
    {
        return stable_spot_instance_settings;
    }

    public void setStable_spot_instance_settings(StableSpotInstanceSettingsV13 stable_spot_instance_settings)
    {
        this.stable_spot_instance_settings = stable_spot_instance_settings;
    }

    public Map<String, String> getCustom_ec2_tags()
    {
        return custom_ec2_tags;
    }

    public void setCustom_ec2_tags(Map<String, String> custom_ec2_tags)
    {
        this.custom_ec2_tags = custom_ec2_tags;
    }

    public int getEbs_volume_count()
    {
        return ebs_volume_count;
    }

    public void setEbs_volume_count(int ebs_volume_count)
    {
        this.ebs_volume_count = ebs_volume_count;
    }
    
    public int getInitial_nodes()
    {
        return initial_nodes;
    }

    public void setInitial_nodes(int initial_nodes)
    {
        this.initial_nodes = initial_nodes;
    }
    
    public int getMax_nodes()
    {
        return max_nodes;
    }

    public void setMax_nodes(int max_nodes)
    {
        this.max_nodes = max_nodes;
    }
    
    public String getMaster_instance_type()
    {
        return master_instance_type;
    }

    public void setMaster_instance_type(String master_instance_type)
    {
        this.master_instance_type = master_instance_type;
    }
    
    public String getSlave_instance_type()
    {
        return slave_instance_type;
    }

    public void setSlave_instance_type(String slave_instance_type)
    {
        this.slave_instance_type = slave_instance_type;
    }
    
    public String getSlave_request_type()
    {
        return slave_request_type;
    }

    public void setSlave_request_type(String slave_request_type)
    {
        this.slave_request_type = slave_request_type;
    }
    
    public String getFallback_to_ondemand()
    {
        return fallback_to_ondemand;
    }

    public void setFallback_to_ondemand(String fallback_to_ondemand)
    {
        this.fallback_to_ondemand = fallback_to_ondemand;
    }
    
    public String getEbs_volume_type()
    {
        return ebs_volume_type;
    }

    public void setEbs_volume_type(String ebs_volume_type)
    {
        this.ebs_volume_type = ebs_volume_type;
    }
    
    public String getEbs_volume_size()
    {
        return ebs_volume_size;
    }

    public void setEbs_volume_size(String ebs_volume_size)
    {
        this.ebs_volume_size = ebs_volume_size;
    }
}
