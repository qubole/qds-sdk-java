package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterItem
{
    private Cluster cluster;

    public ClusterItem()
    {
    }

    public ClusterItem(Cluster cluster)
    {
        this.cluster = cluster;
    }

    public Cluster getCluster()
    {
        return cluster;
    }

    public void setCluster(Cluster cluster)
    {
        this.cluster = cluster;
    }
}
