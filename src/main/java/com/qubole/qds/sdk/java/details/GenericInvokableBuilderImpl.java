package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import java.util.concurrent.Future;

public class GenericInvokableBuilderImpl<T> implements InvokableBuilder<T>
{
    private final QdsClient client;
    private final ClientEntity entity;
    private final Class<T> responseType;
    private final String[] additionalPaths;

    @Override
    public Future<T> invoke()
    {
        return client.invokeRequest(null, entity, responseType, additionalPaths);
    }

    GenericInvokableBuilderImpl(QdsClient client, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.entity = entity;
        this.responseType = responseType;
        this.additionalPaths = additionalPaths;
    }
}
