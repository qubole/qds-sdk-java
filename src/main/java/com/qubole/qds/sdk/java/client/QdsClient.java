package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.details.ForPage;
import java.util.concurrent.Future;

public interface QdsClient extends AutoCloseable
{
    public ClusterApi cluster();

    public CommandApi command();

    public <T> Future<T> invokeRequest(ForPage forPage, Object entity, Class<T> responseType, String... additionalPaths);

    @Override
    public void close();
}
