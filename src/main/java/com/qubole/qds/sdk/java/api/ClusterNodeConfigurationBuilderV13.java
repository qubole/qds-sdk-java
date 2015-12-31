package com.qubole.qds.sdk.java.api;

import java.util.Map;

public interface ClusterNodeConfigurationBuilderV13
{
    public ClusterConfigBuilderV13 master_instance_type(String master_instance_type);
    
    public ClusterConfigBuilderV13 slave_instance_type(String slave_instance_type);
    
    public ClusterConfigBuilderV13 initial_nodes(int initial_nodes);
    
    public ClusterConfigBuilderV13 max_nodes(int max_nodes);
    
    public ClusterConfigBuilderV13 slave_request_type(String slave_request_type);
    
    public ClusterConfigBuilderV13 fallback_to_ondemand(boolean fallback_to_ondemand);
    
    public ClusterConfigBuilderV13 ebs_volume_type(String ebs_volume_type);
    
    public ClusterConfigBuilderV13 ebs_volume_size(String ebs_volume_size);
    
    public ClusterConfigBuilderV13 ebs_volume_count(int ebs_volume_count);
    
    public ClusterConfigBuilderV13 custom_ec2_tags(Map<String,String> custom_ec2_tags);
    
    public ClusterSpotInstanceConfigBuilderV13 spot_instance_settings();
    
    public ClusterStableSpotInstanceConfigBuilderV13 stable_spot_instance_settings();
}
