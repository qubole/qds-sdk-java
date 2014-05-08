package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.details.ClientEntity;
import com.qubole.qds.sdk.java.details.ForPage;
import javax.ws.rs.core.GenericType;
import java.util.concurrent.Future;

/**
 * client interface
 */
public interface QdsClient extends AutoCloseable
{
    /**
     * Return a new cluster config builder. Can be used with
     * apis such as {@link ClusterApi#edit(String, ClusterConfigBuilder)}
     *
     * @return builder
     */
    public ClusterConfigBuilder clusterConfig();

    /**
     * Return cluster api factory
     *
     * @return cluster api factory
     */
    public ClusterApi cluster();

    /**
     * Return command api factory
     *
     * @return command api factory
     */
    public CommandApi command();

    /**
     * Return hive metadata api factory
     *
     * @return hive metadata factory
     */
    public HiveMetadataApi hiveMetadata();

    /**
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param entity request entity or null
     * @param responseType type of the response
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, Class<T> responseType, String... additionalPaths);

    /**
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param entity request entity or null
     * @param responseType type of the response
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, ClientEntity entity, GenericType<T> responseType, String... additionalPaths);

    @Override
    public void close();
}
