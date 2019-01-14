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
public class CommandMetaData
{
    private String results_resource;
    private String logs_resource;

    public CommandMetaData()
    {
    }

    public CommandMetaData(String results_resource, String logs_resource)
    {
        this.results_resource = results_resource;
        this.logs_resource = logs_resource;
    }

    public String getResults_resource()
    {
        return results_resource;
    }

    public void setResults_resource(String results_resource)
    {
        this.results_resource = results_resource;
    }

    public String getLogs_resource()
    {
        return logs_resource;
    }

    public void setLogs_resource(String logs_resource)
    {
        this.logs_resource = logs_resource;
    }
}
