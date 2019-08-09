package com.qubole.qds.sdk.java.api;

import java.util.Map;

public interface ClusterNodeConfigBuilder {


    public ClusterConfigBuilder master_instance_type(String master_instance_type);
    public ClusterConfigBuilder slave_instance_type(String slave_instance_type);
    public ClusterConfigBuilder slave_request_type(String slave_request_type);
    public ClusterConfigBuilder initial_nodes(int initial_nodes);
    public ClusterConfigBuilder max_nodes(int max_nodes);
    public ClusterConfigBuilder custom_ec2_tags(Map<String, String> custom_ec2_tags);
    public ClusterHeterogenousInstanceConfigBuilder heterogenous_instance_config();
    public ClusterSpotInstanceConfigBuilder spot_instance_settings();
    public ClusterSpotInstanceConfigBuilder stable_spot_instance_settings();
    public ClusterSpotBlockConfigBuilder spot_block_settings();
    public ClusterConfigBuilder fallback_to_ondemand(boolean fallback_to_ondemand);
    public ClusterConfigBuilder ebs_volume_type(String ebs_volume_type);
    public ClusterConfigBuilder ebs_volume_size(String ebs_volume_size);
    public ClusterConfigBuilder ebs_volume_count(int ebs_volume_count);
    public ClusterEbsUpscaleConfigBuilder ebs_upscale_config();
    public ClusterConfigBuilder idle_cluster_timeout(String idle_cluster_timeout);
    public ClusterConfigBuilder node_base_cooldown_period(String node_base_cooldown_period);
    public ClusterConfigBuilder node_spot_cooldown_period(String node_spot_cooldown_period);

}
