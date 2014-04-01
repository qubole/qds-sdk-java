package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.details.ForPage;
import java.util.concurrent.Future;

/**
 * client interface
 */
public interface QdsClient extends AutoCloseable
{
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
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param entity request entity or null
     * @param responseType type of the response
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, Object entity, Class<T> responseType, String... additionalPaths);

    @Override
    public void close();
}
