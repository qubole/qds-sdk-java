package com.qubole.qds.sdk.java.api;

public interface ClusterEbsUpscaleConfigBuilder {

    public ClusterConfigBuilder max_ebs_volume_count(int max_ebs_volume_count);
    public ClusterConfigBuilder percent_free_space_threshold(int percent_free_space_threshold);
    public ClusterConfigBuilder absolute_free_space_threshold(int absolute_free_space_threshold);
    public ClusterConfigBuilder sampling_interval(int sampling_interval);
    public ClusterConfigBuilder sampling_window(int sampling_window);
}
