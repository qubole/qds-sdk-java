package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Cluster;
import java.util.List;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/cluster-api/
 */
public interface ClusterApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/list-clusters/
     *
     * @return new builder
     */
    public ClusterListBuilder list();

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
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "start"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterStartBuilder start(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "terminate"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterTerminateBuilder terminate(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/edit-cluster/ - use <code>mask</code>
     * to control which fields are changed. Important: if mask is null ALL fields are changed.
     * Otherwise mask is a list of fields of the form: "field-path-1,field-path-2,...". Where
     * "field path" is "field.field.field". i.e. to change encrypted_ephemerals in the security
     * settings, set the value you desire in newConfig and pass "security_settings.encrypted_ephemerals"
     * as one of the mask values.
     *
     * @param labelOrId the Cluster label/id
     * @param newConfig new cluster config
     * @param mask list of fields to change
     * @return new builder
     */
    public ClusterEditBuilder edit(String labelOrId, Cluster newConfig, List<String> mask);
}
