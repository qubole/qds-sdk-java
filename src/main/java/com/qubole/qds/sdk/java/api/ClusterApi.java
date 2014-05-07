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
     * @deprecated use {@link #state()} instead
     */
    public ClusterStatusBuilder status();

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-state/
     *
     * @return new builder
     */
    public ClusterStateBuilder state();
}
