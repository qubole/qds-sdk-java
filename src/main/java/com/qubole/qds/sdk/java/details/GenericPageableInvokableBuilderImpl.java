package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import java.util.concurrent.Future;

public class GenericPageableInvokableBuilderImpl<T> implements PageableInvokableBuilder<T>
{
    private final QdsClient client;
    private final ClientEntity entity;
    private final Class<T> responseType;
    private final String[] additionalPaths;
    private ForPage forPage;

    @Override
    public InvokableBuilder<T> forPage(int page, int perPage)
    {
        forPage = new ForPage(page, perPage);
        return this;
    }

    @Override
    public Future<T> invoke()
    {
        return client.invokeRequest(forPage, entity, responseType, additionalPaths);
    }

    GenericPageableInvokableBuilderImpl(QdsClient client, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.entity = entity;
        this.responseType = responseType;
        this.additionalPaths = additionalPaths;
    }
}
