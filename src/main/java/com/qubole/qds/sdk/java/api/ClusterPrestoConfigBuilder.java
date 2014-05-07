package com.qubole.qds.sdk.java.api;

public interface ClusterPrestoConfigBuilder
{
    public ClusterConfigBuilder is_presto_enabled(boolean is_presto_enabled);

    public ClusterConfigBuilder custom_config(String custom_config);
}
