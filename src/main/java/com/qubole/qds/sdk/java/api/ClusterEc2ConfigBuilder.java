package com.qubole.qds.sdk.java.api;

public interface ClusterEc2ConfigBuilder
{
    public ClusterConfigBuilder compute_secret_key(String compute_secret_key);
    public ClusterConfigBuilder compute_validated(boolean compute_validated);
    public ClusterConfigBuilder compute_access_key(String compute_access_key);
    public ClusterConfigBuilder aws_region(String aws_region);
    public ClusterConfigBuilder aws_preferred_availability_zone(String aws_preferred_availability_zone);
}
