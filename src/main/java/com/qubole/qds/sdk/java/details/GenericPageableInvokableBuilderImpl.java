package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

class GenericPageableInvokableBuilderImpl<T> extends InvocationCallbackBase<T> implements PageableInvokableBuilder<T>
{
    private final QdsClient client;
    private final RequestDetails entity;
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
    protected InvokeArguments<T> getInvokeArguments()
    {
        return new InvokeArguments<T>(client, forPage, entity, responseType, additionalPaths);
    }

    GenericPageableInvokableBuilderImpl(QdsClient client, RequestDetails entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.entity = entity;
        this.responseType = responseType;
        this.additionalPaths = additionalPaths;
    }
}
