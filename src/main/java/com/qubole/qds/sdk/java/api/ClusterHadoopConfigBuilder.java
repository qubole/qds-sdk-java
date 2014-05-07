package com.qubole.qds.sdk.java.api;

public interface ClusterHadoopConfigBuilder<T>
{
    public T master_instance_type(String master_instance_type);
    public ClusterFairSchedulerConfigBuilder<T> fairscheduler_settings();
    public T max_nodes(int max_nodes);
    public T slave_instance_type(String slave_instance_type);
    public T slave_request_type(String slave_request_type);
    public T initial_nodes(int initial_nodes);
    public T custom_config(String custom_config);
    public ClusterSpotInstanceConfigBuilder<T> spot_instance_settings();
}
