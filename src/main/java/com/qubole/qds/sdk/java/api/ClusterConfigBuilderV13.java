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
package com.qubole.qds.sdk.java.api;

import java.util.List;

public interface ClusterConfigBuilderV13
{
    public ClusterConfigBuilderV13 label(List<String> label);
    
    public ClusterConfigBuilderV13 id(int id);
    
    public ClusterConfigBuilderV13 spark_version(String spark_version);
    
    public ClusterConfigBuilderV13 disallow_cluster_termination(boolean disallow_cluster_termination);

    public ClusterConfigBuilderV13 enable_ganglia_monitoring(boolean enable_ganglia_monitoring);

    public ClusterConfigBuilderV13 node_bootstrap_file(String node_bootstrap_file);

    public ClusterConfigBuilderV13 state(String state);
    
    public ClusterEc2ConfigBuilderV13 ec2_settings();
    
    public ClusterNodeConfigurationBuilderV13 node_configuration();
    
    public ClusterHadoopConfigurationBuilderV13 hadoop_settings();
    
    public ClusterSecurityConfigBuilderV13 security_settings();
    
    public ClusterPrestoConfigBuilderV13 presto_settings();
}
