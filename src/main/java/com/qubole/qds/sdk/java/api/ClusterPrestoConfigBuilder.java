package com.qubole.qds.sdk.java.api;

public interface ClusterPrestoConfigBuilder<T>
{
    public T is_presto_enabled(boolean is_presto_enabled);

    public T custom_config(String custom_config);
}
