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
package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterEc2ConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterFairSchedulerConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterHadoopConfigurationBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterNodeConfigurationBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterPrestoConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterSecurityConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterSpotInstanceConfigBuilderV13;
import com.qubole.qds.sdk.java.api.ClusterStableSpotInstanceConfigBuilderV13;
import org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class ClusterConfigBuilderV13Impl implements ClusterConfigBuilderV13
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode presto_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode security_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode node_configuration = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode spot_instance_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode stable_spot_instance_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode hadoop_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode fairscheduler_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode ec2_settings = QdsClientImpl.getMapper().createObjectNode();

    public ObjectNode getNode()
    {
        ObjectNode clusterNode = QdsClientImpl.getMapper().createObjectNode();
        clusterNode.put("cluster", node);
        return clusterNode;
    }

    @Override
    public String toString()
    {
        try
        {
            return QdsClientImpl.getMapper().writer().writeValueAsString(node);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }

    @Override
    public ClusterConfigBuilderV13 state(String state)
    {
        node.put("state", state);
        return this;
    }
    
    @Override
    public ClusterConfigBuilderV13 spark_version(String spark_version)
    {
        node.put("spark_version", spark_version);
        return this;
    }
    
    @Override
    public ClusterConfigBuilderV13 disallow_cluster_termination(boolean disallow_cluster_termination)
    {
        node.put("disallow_cluster_termination", disallow_cluster_termination);
        return this;
    }
    
    @Override
    public ClusterConfigBuilderV13 enable_ganglia_monitoring(boolean enable_ganglia_monitoring)
    {
        node.put("enable_ganglia_monitoring", enable_ganglia_monitoring);
        return this;
    }
    
    @Override
    public ClusterConfigBuilderV13 node_bootstrap_file(String node_bootstrap_file)
    {
        node.put("node_bootstrap_file", node_bootstrap_file);
        return this;
    }

    @Override
    public ClusterConfigBuilderV13 label(List<String> label)
    {
        node.putPOJO("label", label);
        return this;
    }

    @Override
    public ClusterConfigBuilderV13 id(int id)
    {
        node.put("id", id);
        return this;
    }
    
    @Override
    public ClusterPrestoConfigBuilderV13 presto_settings()
    {
        if ( !node.has("presto_settings") )
        {
            node.put("presto_settings", presto_settings);
        }

        return new ClusterPrestoConfigBuilderV13()
        {
            @Override
            public ClusterConfigBuilderV13 enable_presto(boolean enable_presto)
            {
                presto_settings.put("enable_presto", enable_presto);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 custom_config(String custom_config)
            {
                presto_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 jvm_config(String jvm_config)
            {
                presto_settings.put("jvm_config", jvm_config);
                return ClusterConfigBuilderV13Impl.this;
            }
        };
    }

    @Override
    public ClusterSecurityConfigBuilderV13 security_settings()
    {
        if ( !node.has("security_settings") )
        {
            node.put("security_settings", security_settings);
        }

        return new ClusterSecurityConfigBuilderV13()
        {
            @Override
            public ClusterConfigBuilderV13 encrypted_ephemerals(boolean encrypted_ephemerals)
            {
                security_settings.put("encrypted_ephemerals", encrypted_ephemerals);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 ssh_public_key(String ssh_public_key)
            {
                security_settings.put("ssh_public_key", ssh_public_key);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 persistent_security_group(String persistent_security_group)
            {
                security_settings.put("persistent_security_group", persistent_security_group);
                return ClusterConfigBuilderV13Impl.this;
            }
        };
    }

    @Override
    public ClusterHadoopConfigurationBuilderV13 hadoop_settings()
    {
        if ( !node.has("hadoop_settings") )
        {
            node.put("hadoop_settings", hadoop_settings);
        }
        
        return new ClusterHadoopConfigurationBuilderV13()
        {
            @Override
            public ClusterConfigBuilderV13 custom_config(String custom_config)
            {
                hadoop_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 use_hadoop2(boolean use_hadoop2)
            {
                hadoop_settings.put("use_hadoop2", use_hadoop2);
                return ClusterConfigBuilderV13Impl.this;
            }
            
            @Override
            public ClusterConfigBuilderV13 use_hbase(boolean use_hbase)
            {
                hadoop_settings.put("use_hbase", use_hbase);
                return ClusterConfigBuilderV13Impl.this;
            }
            
            @Override
            public ClusterConfigBuilderV13 use_spark(boolean use_spark)
            {
                hadoop_settings.put("use_spark", use_spark);
                return ClusterConfigBuilderV13Impl.this;
            }
            
            @Override
            public ClusterConfigBuilderV13 use_qubole_placement_policy(boolean use_qubole_placement_policy)
            {
                hadoop_settings.put("use_qubole_placement_policy", use_qubole_placement_policy);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterFairSchedulerConfigBuilderV13 fairscheduler_settings()
            {
                if ( !hadoop_settings.has("fairscheduler_settings") )
                {
                    hadoop_settings.put("fairscheduler_settings", fairscheduler_settings);
                }
                return new ClusterFairSchedulerConfigBuilderV13()
                {
                    @Override
                    public ClusterConfigBuilderV13 default_pool(String default_pool)
                    {
                        fairscheduler_settings.put("default_pool", default_pool);
                        return ClusterConfigBuilderV13Impl.this;
                    }

                    @Override
                    public ClusterConfigBuilderV13 fairscheduler_config_xml(String fairscheduler_config_xml)
                    {
                        fairscheduler_settings.put("fairscheduler_config_xml", fairscheduler_config_xml);
                        return ClusterConfigBuilderV13Impl.this;
                    }
                };
            }
        };
    }
    
    @Override
    public ClusterEc2ConfigBuilderV13 ec2_settings()
    {
        if ( !node.has("ec2_settings") )
        {
            node.put("ec2_settings", ec2_settings);
        }

        return new ClusterEc2ConfigBuilderV13()
        {
            @Override
            public ClusterConfigBuilderV13 compute_secret_key(String compute_secret_key)
            {
                ec2_settings.put("compute_secret_key", compute_secret_key);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 compute_validated(boolean compute_validated)
            {
                ec2_settings.put("compute_validated", compute_validated);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 compute_access_key(String compute_access_key)
            {
                ec2_settings.put("compute_access_key", compute_access_key);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 aws_region(String aws_region)
            {
                ec2_settings.put("aws_region", aws_region);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 aws_preferred_availability_zone(String aws_preferred_availability_zone)
            {
                ec2_settings.put("aws_preferred_availability_zone", aws_preferred_availability_zone);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 subnet_id(String subnet_id)
            {
                ec2_settings.put("subnet_id", subnet_id);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 vpc_id(String vpc_id)
            {
                ec2_settings.put("vpc_id", vpc_id);
                return ClusterConfigBuilderV13Impl.this;
            }

        };
    }
    
    @Override
    public ClusterNodeConfigurationBuilderV13 node_configuration()
    {
        if ( !node.has("node_configuration") )
        {
            node.put("node_configuration", node_configuration);
        }

        return new ClusterNodeConfigurationBuilderV13()
        {

            @Override
            public ClusterConfigBuilderV13 master_instance_type(String master_instance_type)
            {
                node_configuration.put("master_instance_type", master_instance_type);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 slave_instance_type(String slave_instance_type)
            {
                node_configuration.put("slave_instance_type", slave_instance_type);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 initial_nodes(int initial_nodes)
            {
                node_configuration.put("initial_nodes", initial_nodes);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 max_nodes(int max_nodes)
            {
                node_configuration.put("max_nodes", max_nodes);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 slave_request_type(String slave_request_type)
            {
                node_configuration.put("slave_request_type", slave_request_type);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 fallback_to_ondemand(boolean fallback_to_ondemand)
            {
                node_configuration.put("fallback_to_ondemand", fallback_to_ondemand);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 ebs_volume_type(String ebs_volume_type)
            {
                node_configuration.put("ebs_volume_type", ebs_volume_type);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 ebs_volume_size(String ebs_volume_size)
            {
                node_configuration.put("ebs_volume_size", ebs_volume_size);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 ebs_volume_count(int ebs_volume_count)
            {
                node_configuration.put("ebs_volume_count", ebs_volume_count);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterConfigBuilderV13 custom_ec2_tags(Map<String, String> custom_ec2_tags)
            {
                node_configuration.putPOJO("custom_ec2_tags", custom_ec2_tags);
                return ClusterConfigBuilderV13Impl.this;
            }

            @Override
            public ClusterSpotInstanceConfigBuilderV13 spot_instance_settings()
            {
                if ( !node_configuration.has("spot_instance_settings") )
                {
                    node_configuration.put("spot_instance_settings", spot_instance_settings);
                }
                
                return new ClusterSpotInstanceConfigBuilderV13()
                {
                    @Override
                    public ClusterConfigBuilderV13 maximum_bid_price_percentage(String maximum_bid_price_percentage)
                    {
                        spot_instance_settings.put("maximum_bid_price_percentage", maximum_bid_price_percentage);
                        return ClusterConfigBuilderV13Impl.this;
                    }

                    @Override
                    public ClusterConfigBuilderV13 timeout_for_request(int timeout_for_request)
                    {
                        spot_instance_settings.put("timeout_for_request", timeout_for_request);
                        return ClusterConfigBuilderV13Impl.this;
                    }

                    @Override
                    public ClusterConfigBuilderV13 maximum_spot_instance_percentage(int maximum_spot_instance_percentage)
                    {
                        spot_instance_settings.put("maximum_spot_instance_percentage", maximum_spot_instance_percentage);
                        return ClusterConfigBuilderV13Impl.this;
                    }
                };
            }

            @Override
            public ClusterStableSpotInstanceConfigBuilderV13 stable_spot_instance_settings()
            {
                if ( !node_configuration.has("stable_spot_instance_settings") )
                {
                    node_configuration.put("stable_spot_instance_settings", stable_spot_instance_settings);
                }
                
                return new ClusterStableSpotInstanceConfigBuilderV13()
                {
                    @Override
                    public ClusterConfigBuilderV13 maximum_bid_price_percentage(String maximum_bid_price_percentage)
                    {
                        stable_spot_instance_settings.put("maximum_bid_price_percentage", maximum_bid_price_percentage);
                        return ClusterConfigBuilderV13Impl.this;
                    }

                    @Override
                    public ClusterConfigBuilderV13 timeout_for_request(int timeout_for_request)
                    {
                        stable_spot_instance_settings.put("timeout_for_request", timeout_for_request);
                        return ClusterConfigBuilderV13Impl.this;
                    }
                };
            }
            
        };
        
    }
}
