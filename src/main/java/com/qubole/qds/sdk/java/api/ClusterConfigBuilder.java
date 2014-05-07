package com.qubole.qds.sdk.java.api;

import java.util.List;

public interface ClusterConfigBuilder
{
    public ClusterConfigBuilder state(String state);

    public ClusterPrestoConfigBuilder presto_settings();

    public ClusterConfigBuilder disallow_cluster_termination(boolean disallow_cluster_termination);

    public ClusterSecurityConfigBuilder security_settings();

    public ClusterConfigBuilder enable_ganglia_monitoring(boolean enable_ganglia_monitoring);

    public ClusterHadoopConfigBuilder hadoop_settings();

    public ClusterConfigBuilder node_bootstrap_file(String node_bootstrap_file);

    public ClusterConfigBuilder label(List<String> label);

    public ClusterConfigBuilder id(int id);

    public ClusterEc2ConfigBuilder ec2_settings();
}
