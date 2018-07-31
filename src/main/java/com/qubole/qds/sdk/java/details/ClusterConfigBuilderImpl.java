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

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterEc2ConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterFairSchedulerConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterHadoopConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterPrestoConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterSecurityConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterSpotInstanceConfigBuilder;
import org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class ClusterConfigBuilderImpl implements ClusterConfigBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode presto_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode security_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode hadoop_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode fairscheduler_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode spot_instance_settings = QdsClientImpl.getMapper().createObjectNode();
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
            return QdsClientImpl.getMapper().writer().writeValueAsString(getNode());
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }

    @Override
    public ClusterConfigBuilder state(String state)
    {
        node.put("state", state);
        return this;
    }

    @Override
    public ClusterPrestoConfigBuilder presto_settings()
    {
        if (!node.has("presto_settings"))
        {
            node.put("presto_settings", presto_settings);
        }

        return new ClusterPrestoConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder enable_presto(boolean enable_presto)
            {
                presto_settings.put("enable_presto", enable_presto);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_config(String custom_config)
            {
                presto_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }

    @Override
    public ClusterConfigBuilder disallow_cluster_termination(boolean disallow_cluster_termination)
    {
        node.put("disallow_cluster_termination", disallow_cluster_termination);
        return this;
    }

    @Override
    public ClusterSecurityConfigBuilder security_settings()
    {
        if (!node.has("security_settings"))
        {
            node.put("security_settings", security_settings);
        }

        return new ClusterSecurityConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder encrypted_ephemerals(boolean encrypted_ephemerals)
            {
                security_settings.put("encrypted_ephemerals", encrypted_ephemerals);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder customer_ssh_key(String customer_ssh_key)
            {
                security_settings.put("customer_ssh_key", customer_ssh_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder persistent_security_group(String persistent_security_group)
            {
                security_settings.put("persistent_security_group", persistent_security_group);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }

    @Override
    public ClusterConfigBuilder enable_ganglia_monitoring(boolean enable_ganglia_monitoring)
    {
        node.put("enable_ganglia_monitoring", enable_ganglia_monitoring);
        return this;
    }

    @Override
    public ClusterHadoopConfigBuilder hadoop_settings()
    {
        if (!node.has("hadoop_settings"))
        {
            node.put("hadoop_settings", hadoop_settings);
        }

        return new ClusterHadoopConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder master_instance_type(String master_instance_type)
            {
                hadoop_settings.put("master_instance_type", master_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterFairSchedulerConfigBuilder fairscheduler_settings()
            {
                if (!hadoop_settings.has("fairscheduler_settings"))
                {
                    hadoop_settings.put("fairscheduler_settings", fairscheduler_settings);
                }
                return new ClusterFairSchedulerConfigBuilder()
                {
                    @Override
                    public ClusterConfigBuilder default_pool(String default_pool)
                    {
                        fairscheduler_settings.put("default_pool", default_pool);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }

            @Override
            public ClusterConfigBuilder max_nodes(int max_nodes)
            {
                hadoop_settings.put("max_nodes", max_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_instance_type(String slave_instance_type)
            {
                hadoop_settings.put("slave_instance_type", slave_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_request_type(String slave_request_type)
            {
                hadoop_settings.put("slave_request_type", slave_request_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder initial_nodes(int initial_nodes)
            {
                hadoop_settings.put("initial_nodes", initial_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_config(String custom_config)
            {
                hadoop_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_ec2_tags(Map<String, String> custom_ec2_tags)
            {
                hadoop_settings.put("custom_ec2_tags", QdsClientImpl.getMapper().valueToTree(custom_ec2_tags));
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder use_hbase(boolean use_hbase) {
                hadoop_settings.put("use_hbase", use_hbase);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder use_spark(boolean use_spark)
            {
                hadoop_settings.put("use_spark", use_spark);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder use_hadoop2(boolean use_hadoop2)
            {
                hadoop_settings.put("use_hadoop2", use_hadoop2);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterSpotInstanceConfigBuilder spot_instance_settings()
            {
                if (!hadoop_settings.has("spot_instance_settings"))
                {
                    hadoop_settings.put("spot_instance_settings", spot_instance_settings);
                }
                return new ClusterSpotInstanceConfigBuilder()
                {
                    @Override
                    public ClusterConfigBuilder maximum_bid_price_percentage(String maximum_bid_price_percentage)
                    {
                        spot_instance_settings.put("maximum_bid_price_percentage", maximum_bid_price_percentage);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder timeout_for_request(int timeout_for_request)
                    {
                        spot_instance_settings.put("timeout_for_request", timeout_for_request);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder maximum_spot_instance_percentage(int maximum_spot_instance_percentage)
                    {
                        spot_instance_settings.put("maximum_spot_instance_percentage", maximum_spot_instance_percentage);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }
        };
    }

    @Override
    public ClusterConfigBuilder node_bootstrap_file(String node_bootstrap_file)
    {
        node.put("node_bootstrap_file", node_bootstrap_file);
        return this;
    }

    @Override
    public ClusterConfigBuilder label(List<String> label)
    {
        node.putPOJO("label", label);
        return this;
    }

    @Override
    public ClusterConfigBuilder id(int id)
    {
        node.put("id", id);
        return this;
    }

    @Override
    public ClusterEc2ConfigBuilder ec2_settings()
    {
        if (!node.has("ec2_settings"))
        {
            node.put("ec2_settings", ec2_settings);
        }

        return new ClusterEc2ConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder compute_secret_key(String compute_secret_key)
            {
                ec2_settings.put("compute_secret_key", compute_secret_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder compute_validated(boolean compute_validated)
            {
                ec2_settings.put("compute_validated", compute_validated);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder compute_access_key(String compute_access_key)
            {
                ec2_settings.put("compute_access_key", compute_access_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder aws_region(String aws_region)
            {
                ec2_settings.put("aws_region", aws_region);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder aws_preferred_availability_zone(String aws_preferred_availability_zone)
            {
                ec2_settings.put("aws_preferred_availability_zone", aws_preferred_availability_zone);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder subnet_id(String subnet_id)
            {
                ec2_settings.put("subnet_id", subnet_id);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder vpc_id(String vpc_id)
            {
                ec2_settings.put("vpc_id", vpc_id);
                return ClusterConfigBuilderImpl.this;
            }

        };
    }
}
