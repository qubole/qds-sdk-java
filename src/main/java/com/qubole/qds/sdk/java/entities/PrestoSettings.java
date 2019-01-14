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
public class PrestoSettings
{
    private boolean enable_presto;
    private String custom_config;

    public PrestoSettings()
    {
    }

    public PrestoSettings(boolean enable_presto, String custom_config)
    {
        this.enable_presto = enable_presto;
        this.custom_config = custom_config;
    }

    public boolean isEnable_presto()
    {
        return enable_presto;
    }

    public void setEnable_presto(boolean enable_presto)
    {
        this.enable_presto = enable_presto;
    }

    public String getCustom_config()
    {
        return custom_config;
    }

    public void setCustom_config(String custom_config)
    {
        this.custom_config = custom_config;
    }
}
