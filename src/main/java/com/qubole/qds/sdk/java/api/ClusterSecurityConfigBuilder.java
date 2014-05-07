package com.qubole.qds.sdk.java.api;

public interface ClusterSecurityConfigBuilder<T>
{
    public T encrypted_ephemerals(boolean encrypted_ephemerals);

    public T customer_ssh_key(String customer_ssh_key);
}
