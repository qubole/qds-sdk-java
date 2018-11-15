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
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cluster
{
    private String state;
    private PrestoSettings presto_settings;
    private boolean disallow_cluster_termination;
    private SecuritySettings security_settings;
    private boolean enable_ganglia_monitoring;
    private HadoopSettings hadoop_settings;
    private String node_bootstrap_file;
    private List<String> label;
    private int id;
    private Ec2Settings ec2_settings;

    public Cluster()
    {
    }

    public Cluster(String state, PrestoSettings presto_settings, boolean disallow_cluster_termination, SecuritySettings security_settings, boolean enable_ganglia_monitoring, HadoopSettings hadoop_settings, String node_bootstrap_file, List<String> label, int id, Ec2Settings ec2_settings)
    {
        this.state = state;
        this.presto_settings = presto_settings;
        this.disallow_cluster_termination = disallow_cluster_termination;
        this.security_settings = security_settings;
        this.enable_ganglia_monitoring = enable_ganglia_monitoring;
        this.hadoop_settings = hadoop_settings;
        this.node_bootstrap_file = node_bootstrap_file;
        this.label = label;
        this.id = id;
        this.ec2_settings = ec2_settings;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public PrestoSettings getPresto_settings()
    {
        return presto_settings;
    }

    public void setPresto_settings(PrestoSettings presto_settings)
    {
        this.presto_settings = presto_settings;
    }

    public boolean isDisallow_cluster_termination()
    {
        return disallow_cluster_termination;
    }

    public void setDisallow_cluster_termination(boolean disallow_cluster_termination)
    {
        this.disallow_cluster_termination = disallow_cluster_termination;
    }

    public SecuritySettings getSecurity_settings()
    {
        return security_settings;
    }

    public void setSecurity_settings(SecuritySettings security_settings)
    {
        this.security_settings = security_settings;
    }

    public boolean isEnable_ganglia_monitoring()
    {
        return enable_ganglia_monitoring;
    }

    public void setEnable_ganglia_monitoring(boolean enable_ganglia_monitoring)
    {
        this.enable_ganglia_monitoring = enable_ganglia_monitoring;
    }

    public HadoopSettings getHadoop_settings()
    {
        return hadoop_settings;
    }

    public void setHadoop_settings(HadoopSettings hadoop_settings)
    {
        this.hadoop_settings = hadoop_settings;
    }

    public String getNode_bootstrap_file()
    {
        return node_bootstrap_file;
    }

    public void setNode_bootstrap_file(String node_bootstrap_file)
    {
        this.node_bootstrap_file = node_bootstrap_file;
    }

    public List<String> getLabel()
    {
        return label;
    }

    public void setLabel(List<String> label)
    {
        this.label = label;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Ec2Settings getEc2_settings()
    {
        return ec2_settings;
    }

    public void setEc2_settings(Ec2Settings ec2_settings)
    {
        this.ec2_settings = ec2_settings;
    }
}
