package com.qubole.qds.sdk.java.api;

public interface ClusterEc2ConfigBuilder<T>
{
    public T compute_secret_key(String compute_secret_key);
    public T compute_validated(boolean compute_validated);
    public T compute_access_key(String compute_access_key);
    public T aws_region(String aws_region);
    public T aws_preferred_availability_zone(String aws_preferred_availability_zone);
}
