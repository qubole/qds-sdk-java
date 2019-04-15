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

import com.qubole.qds.sdk.java.api.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qubole.qds.sdk.java.entities.InstanceWeight;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class ClusterConfigBuilderImpl implements ClusterConfigBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode node_configuration = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode presto_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode security_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode hadoop_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode fairscheduler_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode heterogenous_instance_config = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode spot_instance_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode stable_spot_instance_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode spot_block_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode ebs_upscale_config = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode ec2_settings = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode engine_config = QdsClientImpl.getMapper().createObjectNode();
    private final ObjectNode hive_settings = QdsClientImpl.getMapper().createObjectNode();

    public ObjectNode getNode()
    {
        /*ObjectNode clusterNode = QdsClientImpl.getMapper().createObjectNode();
        clusterNode.putPOJO("cluster", node);*/
        return node;
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
    public ClusterNodeConfigBuilder node_configuration()
    {
        if (!node.has("node_configuration"))
        {
            node.putPOJO("node_configuration", node_configuration);
        }

        return new ClusterNodeConfigBuilder() {


            @Override
            public ClusterConfigBuilder master_instance_type(String master_instance_type)
            {
                node_configuration.put("master_instance_type", master_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder max_nodes(int max_nodes)
            {
                node_configuration.put("max_nodes", max_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_instance_type(String slave_instance_type)
            {
                node_configuration.put("slave_instance_type", slave_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_request_type(String slave_request_type)
            {
                node_configuration.put("slave_request_type", slave_request_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder initial_nodes(int initial_nodes)
            {
                node_configuration.put("initial_nodes", initial_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_ec2_tags(Map<String, String> custom_ec2_tags)
            {
                node_configuration.putPOJO("custom_ec2_tags", QdsClientImpl.getMapper().valueToTree(custom_ec2_tags));
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterHeterogenousInstanceConfigBuilder heterogenous_instance_config()
            {
                if (!node_configuration.has("heterogenous_instance_config"))
                {
                    node_configuration.putPOJO("heterogenous_instance_config", heterogenous_instance_config);
                }
                return new ClusterHeterogenousInstanceConfigBuilder() {
                    @Override
                    public ClusterConfigBuilder memory(List<InstanceWeight> weights) {
                        heterogenous_instance_config.putPOJO("memory", weights);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }

            @Override
            public ClusterSpotInstanceConfigBuilder spot_instance_settings()
            {
                if (!node_configuration.has("spot_instance_settings"))
                {
                    node_configuration.putPOJO("spot_instance_settings", spot_instance_settings);
                }
                return new ClusterSpotInstanceConfigBuilder()
                {
                    @Override
                    public ClusterConfigBuilder maximum_bid_price_percentage(double maximum_bid_price_percentage)
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

            @Override
            public ClusterSpotInstanceConfigBuilder stable_spot_instance_settings() {
                if (!node_configuration.has("stable_spot_instance_settings"))
                {
                    node_configuration.putPOJO("stable_spot_instance_settings", stable_spot_instance_settings);
                }
                return new ClusterSpotInstanceConfigBuilder() {
                    @Override
                    public ClusterConfigBuilder maximum_bid_price_percentage(double maximum_bid_price_percentage) {
                        stable_spot_instance_settings.put("maximum_bid_price_percentage", maximum_bid_price_percentage);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder timeout_for_request(int timeout_for_request) {
                        stable_spot_instance_settings.put("timeout_for_rquest", timeout_for_request);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder maximum_spot_instance_percentage(int maximum_spot_instance_percentage) {
                        return null;
                    }
                };
            }

            @Override
            public ClusterSpotBlockConfigBuilder spot_block_settings() {
                if (!node_configuration.has("spot_block_settings"))
                {
                    node_configuration.putPOJO("spot_block_settings", spot_block_settings);
                }
                return new ClusterSpotBlockConfigBuilder() {

                    @Override
                    public ClusterConfigBuilder duration(int duration) {
                        spot_block_settings.put("duration", duration);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }

            @Override
            public ClusterConfigBuilder fallback_to_ondemand(boolean fallback_to_ondemand) {
                node_configuration.put("fallback_to_ondemand", fallback_to_ondemand);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder ebs_volume_type(String ebs_volume_type) {
                node_configuration.put("ebs_volume_type", ebs_volume_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder ebs_volume_size(String ebs_volume_size) {
                node_configuration.put("ebs_volume_size", ebs_volume_size);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder ebs_volume_count(int ebs_volume_count) {
                node_configuration.put("ebs_volume_count", ebs_volume_count);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterEbsUpscaleConfigBuilder ebs_upscale_config() {
                if (!node_configuration.has("ebs_upscale_config"))
                {
                    node_configuration.putPOJO("ebs_upscale_config", ebs_upscale_config);
                }
                return new ClusterEbsUpscaleConfigBuilder() {
                    @Override
                    public ClusterConfigBuilder max_ebs_volume_count(int max_ebs_volume_count) {
                        ebs_upscale_config.put("max_ebs_volume_count", max_ebs_volume_count);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder percent_free_space_threshold(int percent_free_space_threshold) {
                        ebs_upscale_config.put("percent_free_space_threshold", percent_free_space_threshold);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder absolute_free_space_threshold(int absolute_free_space_threshold) {
                        ebs_upscale_config.put("absolute_free_space_threshold", absolute_free_space_threshold);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder sampling_interval(int sampling_interval) {
                        ebs_upscale_config.put("sampling_interval", sampling_interval);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder sampling_window(int sampling_window) {
                        ebs_upscale_config.put("sampling_window", sampling_window);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }

            @Override
            public ClusterConfigBuilder idle_cluster_timeout(String idle_cluster_timeout) {
                node_configuration.put("idle_cluster_timeout", idle_cluster_timeout);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder node_base_cooldown_period(String node_base_cooldown_period) {
                node_configuration.put("node_base_cooldown_period", node_base_cooldown_period);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder node_spot_cooldown_period(String node_spot_cooldown_period) {
                node_configuration.put("node_spot_cooldown_period", node_spot_cooldown_period);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }

    @Override
    public ClusterPrestoConfigBuilder presto_settings()
    {
        if (!node.has("presto_settings"))
        {
            node.putPOJO("presto_settings", presto_settings);
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
            node.putPOJO("security_settings", security_settings);
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
            node.putPOJO("hadoop_settings", hadoop_settings);
        }

        return new ClusterHadoopConfigBuilder()
        {

            @Override
            public ClusterFairSchedulerConfigBuilder fairscheduler_settings()
            {
                if (!hadoop_settings.has("fairscheduler_settings"))
                {
                    hadoop_settings.putPOJO("fairscheduler_settings", fairscheduler_settings);
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
            public ClusterConfigBuilder custom_config(String custom_config)
            {
                hadoop_settings.put("custom_config", custom_config);
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
            public ClusterConfigBuilder use_qubole_placement_policy(boolean use_qubole_placement_policy)
            {
                hadoop_settings.put("use_qubole_placement_policy", use_qubole_placement_policy);
                return ClusterConfigBuilderImpl.this;
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
            node.putPOJO("ec2_settings", ec2_settings);
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

            @Override
            public ClusterConfigBuilder role_instance_profile(String role_instance_profile)
            {
                ec2_settings.put("role_instance_profile", role_instance_profile);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder bastion_node_public_dns(String bastion_node_public_dns)
            {
                ec2_settings.put("bastion_node_public_dns", bastion_node_public_dns);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder bastion_node_port(int bastion_node_port)
            {
                ec2_settings.put("bastion_node_port", bastion_node_port);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder bastion_node_user(String bastion_node_user)
            {
                ec2_settings.put("bastion_node_user", bastion_node_user);
                return ClusterConfigBuilderImpl.this;
            }

        };
    }

    @Override
    public ClusterEngineConfigBuilder engine_config()
    {
        if(!node.has("engine_config")) {
            node.putPOJO("engine_config", engine_config);
        }
        return new ClusterEngineConfigBuilder() {
            @Override
            public ClusterConfigBuilder type(String type) {
                engine_config.put("type", type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder dbtap_id(String dbtap_id) {
                engine_config.put("dbtap_id", dbtap_id);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder fernet_key(String fernet_key) {
                engine_config.put("fernet_key", fernet_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder overrides(String overrides) {
                engine_config.put("overrides", overrides);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterHiveServer2ConfigBuilder hive_settings() {
                if (!engine_config.has("hive_settings"))
                 {

                    engine_config.putPOJO("hive_settings", hive_settings);
                 }
                return new ClusterHiveServer2ConfigBuilder() {
                    @Override
                    public ClusterConfigBuilder is_hs2(boolean is_hs2) {
                        hive_settings.put("is_hs2", is_hs2);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder hive_version(String hive_version) {
                        hive_settings.put("hive_version", hive_version);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder hive_qubole_metadata_cache(String hive_qubole_metadata_cache) {
                        hive_settings.put("hive.qubole.metadata.cache", hive_qubole_metadata_cache);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder hs2_thrift_port(String hs2_thrift_port) {
                        hive_settings.put("hs2_thrift_port", hs2_thrift_port);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder overrides(String overrides) {
                        hive_settings.put("overrides", overrides);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder pig_version(String pig_version) {
                        hive_settings.put("pig_version", pig_version);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder pig_execution_engine(String pig_execution_engine) {
                        hive_settings.put("pig_execution_engine", pig_execution_engine);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }
        };
    }
}
