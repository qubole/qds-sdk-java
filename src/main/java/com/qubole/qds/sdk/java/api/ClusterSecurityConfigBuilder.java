package com.qubole.qds.sdk.java.api;

public interface ClusterSecurityConfigBuilder
{
    public ClusterConfigBuilder encrypted_ephemerals(boolean encrypted_ephemerals);

    public ClusterConfigBuilder customer_ssh_key(String customer_ssh_key);
}
