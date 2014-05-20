package com.qubole.qds.sdk.java.api;

public interface ClusterPrestoConfigBuilder
{
    public ClusterConfigBuilder enable_presto(boolean enable_presto);

    public ClusterConfigBuilder custom_config(String custom_config);
}
