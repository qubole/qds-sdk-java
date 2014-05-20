package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import javax.ws.rs.core.GenericType;

class GenericInvokableBuilderImpl<T> extends InvocationCallbackBase<T> implements InvokableBuilder<T>
{
    private final QdsClient client;
    private final ClientEntity entity;
    private final Class<T> responseType;
    private final GenericType<T> genericResponseType;
    private final String[] additionalPaths;

    @Override
    protected InvokeArguments<T> getInvokeArguments()
    {
        if ( genericResponseType != null )
        {
            return new InvokeArguments<T>(client, null, entity, genericResponseType, additionalPaths);
        }
        return new InvokeArguments<T>(client, null, entity, responseType, additionalPaths);
    }

    GenericInvokableBuilderImpl(QdsClient client, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.entity = entity;
        this.responseType = responseType;
        this.genericResponseType = null;
        this.additionalPaths = additionalPaths;
    }

    GenericInvokableBuilderImpl(QdsClient client, ClientEntity entity, GenericType<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.entity = entity;
        this.responseType = null;
        this.genericResponseType = responseType;
        this.additionalPaths = additionalPaths;
    }
}
