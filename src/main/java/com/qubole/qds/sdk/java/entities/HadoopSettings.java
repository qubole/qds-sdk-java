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
public class HadoopSettings
{
    private String master_instance_type;
    private FairSchedulerSettings fairscheduler_settings;
    private int max_nodes;
    private String slave_instance_type;
    private String slave_request_type;
    private int initial_nodes;
    private String custom_config;
    private SpotInstanceSettings spot_instance_settings;
    private boolean use_hadoop2;

    public HadoopSettings()
    {
    }

    public HadoopSettings(String master_instance_type, FairSchedulerSettings fairscheduler_settings, int max_nodes, String slave_instance_type, String slave_request_type, int initial_nodes, String custom_config, SpotInstanceSettings spot_instance_settings,boolean use_hadoop2)
    {
        this.master_instance_type = master_instance_type;
        this.fairscheduler_settings = fairscheduler_settings;
        this.max_nodes = max_nodes;
        this.slave_instance_type = slave_instance_type;
        this.slave_request_type = slave_request_type;
        this.initial_nodes = initial_nodes;
        this.custom_config = custom_config;
        this.spot_instance_settings = spot_instance_settings;
        this.use_hadoop2 = use_hadoop2;
    }

    public String getMaster_instance_type()
    {
        return master_instance_type;
    }

    public void setMaster_instance_type(String master_instance_type)
    {
        this.master_instance_type = master_instance_type;
    }

    public FairSchedulerSettings getFairscheduler_settings()
    {
        return fairscheduler_settings;
    }

    public void setFairscheduler_settings(FairSchedulerSettings fairscheduler_settings)
    {
        this.fairscheduler_settings = fairscheduler_settings;
    }

    public int getMax_nodes()
    {
        return max_nodes;
    }

    public void setMax_nodes(int max_nodes)
    {
        this.max_nodes = max_nodes;
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

    public int getInitial_nodes()
    {
        return initial_nodes;
    }

    public void setInitial_nodes(int initial_nodes)
    {
        this.initial_nodes = initial_nodes;
    }

    public String getCustom_config()
    {
        return custom_config;
    }

    public void setCustom_config(String custom_config)
    {
        this.custom_config = custom_config;
    }

    public SpotInstanceSettings getSpot_instance_settings()
    {
        return spot_instance_settings;
    }

    public void setSpot_instance_settings(SpotInstanceSettings spot_instance_settings)
    {
        this.spot_instance_settings = spot_instance_settings;
    }
    
    public boolean getUse_hadoop2()
    {
        return use_hadoop2;
    }

    public void setUse_hadoop2(boolean use_hadoop2)
    {
        this.use_hadoop2 = use_hadoop2;
    }
}
