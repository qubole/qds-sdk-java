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
     * @deprecated use {@link #state(String)} instead
     */
    public ClusterStatusBuilder status();

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-state/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterStateBuilder state(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-information/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterInformationBuilder information(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/list-clusters/
     *
     * @return new builder
     */
    public ClusterListBuilder list();
}
