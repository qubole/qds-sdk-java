package com.qubole.qds.sdk.java.api;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/cluster-api/
 */
public interface ClusterApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/check-cluster-status/
     *
     * @return new builder
     */
    public ClusterStatusBuilder status();
}
