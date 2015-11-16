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
public class SnapshotCommand 
{
    private Snapshot parameters;
    private String action;
    private String cluster_inst_id;
    private String private_dns;
    private boolean md_cmd;
    
    SnapshotCommand()
    {
    }
    
    SnapshotCommand(Snapshot parameters, String action, String cluster_inst_id, String private_dns, boolean md_cmd)
    {
        this.parameters = parameters;
        this.action = action;
        this.cluster_inst_id = cluster_inst_id;
        this.private_dns = private_dns;
        this.md_cmd = md_cmd;
    }
    
    public Snapshot getParameters()
    {
        return parameters;
    }

    public void setParameters(Snapshot parameters)
    {
        this.parameters = parameters;
    }
    
    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }
    
    public String getCluster_inst_id()
    {
        return cluster_inst_id;
    }

    public void setCluster_inst_id(String cluster_inst_id)
    {
        this.cluster_inst_id = cluster_inst_id;
    }
    
    public String getPrivate_dns()
    {
        return private_dns;
    }

    public void setPrivate_dns(String private_dns)
    {
        this.private_dns = private_dns;
    }
    
    public boolean getMd_cmd()
    {
        return md_cmd;
    }

    public void setMd_cmd(boolean md_cmd)
    {
        this.md_cmd = md_cmd;
    }
}
