package com.qubole.qds.sdk.java.api;

public interface ClusterHadoopConfigBuilder
{
    public ClusterConfigBuilder master_instance_type(String master_instance_type);
    public ClusterFairSchedulerConfigBuilder fairscheduler_settings();
    public ClusterConfigBuilder max_nodes(int max_nodes);
    public ClusterConfigBuilder slave_instance_type(String slave_instance_type);
    public ClusterConfigBuilder slave_request_type(String slave_request_type);
    public ClusterConfigBuilder initial_nodes(int initial_nodes);
    public ClusterConfigBuilder custom_config(String custom_config);
    public ClusterSpotInstanceConfigBuilder spot_instance_settings();
}
