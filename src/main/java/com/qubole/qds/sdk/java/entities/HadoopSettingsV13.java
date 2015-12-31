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
public class HadoopSettingsV13
{   
    private boolean use_hadoop2;
    private boolean use_spark;
    private boolean use_hbase;
    private boolean use_qubole_placement_policy;
    private String custom_config;
    private FairSchedulerSettingsV13 fairscheduler_settings;

    public HadoopSettingsV13()
    {
    }

    public HadoopSettingsV13(String custom_config, FairSchedulerSettingsV13 fairscheduler_settings, boolean use_qubole_placement_policy, boolean use_hbase, boolean use_spark, boolean use_hadoop2)
    {
        this.use_hadoop2 = use_hadoop2;
        this.fairscheduler_settings = fairscheduler_settings;
        this.use_spark = use_spark;
        this.use_hbase = use_hbase;
        this.use_qubole_placement_policy = use_qubole_placement_policy;
        this.custom_config = custom_config;
    }

    public FairSchedulerSettingsV13 getFairscheduler_settings()
    {
        return fairscheduler_settings;
    }

    public void setFairscheduler_settings(FairSchedulerSettingsV13 fairscheduler_settings)
    {
        this.fairscheduler_settings = fairscheduler_settings;
    }

    public String getCustom_config()
    {
        return custom_config;
    }

    public void setCustom_config(String custom_config)
    {
        this.custom_config = custom_config;
    }

    public boolean getUse_hadoop2()
    {
        return use_hadoop2;
    }

    public void setUse_hadoop2(boolean use_hadoop2)
    {
        this.use_hadoop2 = use_hadoop2;
    }
    
    public boolean getUse_spark()
    {
        return use_spark;
    }

    public void setUse_spark(boolean use_spark)
    {
        this.use_spark = use_spark;
    }
    
    public boolean getUse_hbase()
    {
        return use_hbase;
    }

    public void setUse_hbase(boolean use_hbase)
    {
        this.use_hbase = use_hbase;
    }
    
    public boolean getUse_qubole_placement_policy()
    {
        return use_qubole_placement_policy;
    }

    public void setUse_qubole_placement_policy(boolean use_qubole_placement_policy)
    {
        this.use_qubole_placement_policy = use_qubole_placement_policy;
    }
}
