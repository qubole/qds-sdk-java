package com.qubole.qds.sdk.java.entities;

import java.util.List;

public class Cluster
{
    private String state;
    private PrestoSettings presto_settings;
    private boolean disallow_cluster_termination;
    private SecuritySettings security_settings;
    private boolean enable_ganglia_monitoring;
    private HadoopSettings hadoop_settings;
    private String node_bootstrap_file;
    private List<String> label;
    private int id;
    private Ec2Settings ec2_settings;
}
