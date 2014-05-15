package com.qubole.qds.sdk.java.details;

import com.google.common.base.Preconditions;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.RawInvokableBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

abstract class InvocationCallbackBase<T> implements InvokableBuilder<T>
{
    private InvocationCallback<T> callback;

    public InvokableBuilder<T> withCallback(InvocationCallback<T> callback)
    {
        this.callback = callback;
        return this;
    }

    @Override
    public final RawInvokableBuilder raw()
    {
        return new RawInvokableBuilder()
        {
            @Override
            public Future<Response> invoke()
            {
                Preconditions.checkState(callback == null, "withCallback() cannot be used in combination with invokeRaw()");

                InvokeArguments<T> invokeArguments = getInvokeArguments();
                return invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), Response.class, invokeArguments.getAdditionalPaths());
            }
        };
    }

    @Override
    public final Future<T> invoke()
    {
        InvokeArguments<T> invokeArguments = getInvokeArguments();

        if ( callback != null )
        {
            return invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), callback, invokeArguments.getAdditionalPaths());
        }

        if ( invokeArguments.getGenericResponseType() != null )
        {
            return invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), invokeArguments.getGenericResponseType(), invokeArguments.getAdditionalPaths());
        }

        return invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), invokeArguments.getResponseType(), invokeArguments.getAdditionalPaths());
    }

    protected abstract InvokeArguments<T> getInvokeArguments();
}
