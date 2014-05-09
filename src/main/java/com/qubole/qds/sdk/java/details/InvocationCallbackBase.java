package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import java.util.concurrent.Future;

abstract class InvocationCallbackBase<T> implements InvokableBuilder<T>
{
    private InvocationCallback<T> callback;

    public InvokableBuilder<T> withCallback(InvocationCallback<T> callback)
    {
        this.callback = callback;
        return this;
    }

    Future<T> invokeRequest(QdsClient client, ForPage forPage, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        if ( callback != null )
        {
            return client.invokeRequest(forPage, entity, callback, additionalPaths);
        }
        return client.invokeRequest(forPage, entity, responseType, additionalPaths);
    }

    protected Future<T> invokeRequest(QdsClient client, ForPage forPage, ClientEntity entity, GenericType<T> responseType, String... additionalPaths)
    {
        if ( callback != null )
        {
            return client.invokeRequest(forPage, entity, callback, additionalPaths);
        }
        return client.invokeRequest(forPage, entity, responseType, additionalPaths);
    }
}
