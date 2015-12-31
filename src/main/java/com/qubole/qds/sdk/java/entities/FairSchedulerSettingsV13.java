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
public class FairSchedulerSettingsV13
{
    private String default_pool;
    private String fairscheduler_config_xml;

    public FairSchedulerSettingsV13()
    {
    }

    public FairSchedulerSettingsV13(String default_pool, String fairscheduler_config_xml)
    {
        this.default_pool = default_pool;
        this.fairscheduler_config_xml = fairscheduler_config_xml;
    }

    public String getDefault_pool()
    {
        return default_pool;
    }

    public void setDefault_pool(String default_pool)
    {
        this.default_pool = default_pool;
    }
    
    public String getFairscheduler_config_xml()
    {
        return fairscheduler_config_xml;
    }

    public void setFairscheduler_config_xml(String fairscheduler_config_xml)
    {
        this.fairscheduler_config_xml = fairscheduler_config_xml;
    }
}
