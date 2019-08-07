package com.qubole.qds.sdk.java.api;

public interface ClusterHiveServer2ConfigBuilder {

    public ClusterConfigBuilder is_hs2(boolean is_hs2);
    public ClusterConfigBuilder hive_version(String hive_version);
    public ClusterConfigBuilder hive_qubole_metadata_cache(String hive_qubole_metadata_cache);
    public ClusterConfigBuilder hs2_thrift_port(String hs2_thrift_port);
    public ClusterConfigBuilder overrides(String overrides);
    public ClusterConfigBuilder pig_version(String pig_version);
    public ClusterConfigBuilder pig_execution_engine(String pig_execution_engine);
}
