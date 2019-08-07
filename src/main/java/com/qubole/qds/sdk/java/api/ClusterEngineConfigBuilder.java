package com.qubole.qds.sdk.java.api;

public interface ClusterEngineConfigBuilder {

    public ClusterConfigBuilder type(String type);
    public ClusterConfigBuilder dbtap_id(String dbtap_id);
    public ClusterConfigBuilder fernet_key(String fernet_key);
    public ClusterConfigBuilder overrides(String overrides);
    public ClusterHiveServer2ConfigBuilder hive_settings();

}
