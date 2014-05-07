package com.qubole.qds.sdk.java.api;

import java.util.List;

public interface ClusterConfigBuilder<T>
{
    public T state(String state);

    public ClusterPrestoConfigBuilder<T> presto_settings();

    public T disallow_cluster_termination(boolean disallow_cluster_termination);

    public ClusterSecurityConfigBuilder<T> security_settings();

    public T enable_ganglia_monitoring(boolean enable_ganglia_monitoring);

    public ClusterHadoopConfigBuilder<T> hadoop_settings();

    public T node_bootstrap_file(String node_bootstrap_file);

    public T label(List<String> label);

    public T id(int id);

    public ClusterEc2ConfigBuilder<T> ec2_settings();
}
