package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.client.QdsClient;
import javax.ws.rs.core.GenericType;

class InvokeArguments<T>
{
    private final QdsClient client;
    private final ForPage forPage;
    private final ClientEntity entity;
    private final GenericType<T> genericResponseType;
    private final Class<T> responseType;
    private final String[] additionalPaths;

    InvokeArguments(QdsClient client, ForPage forPage, ClientEntity entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.forPage = forPage;
        this.entity = entity;
        this.responseType = responseType;
        this.additionalPaths = additionalPaths;
        this.genericResponseType = null;
    }

    InvokeArguments(QdsClient client, ForPage forPage, ClientEntity entity, GenericType<T> genericResponseType, String... additionalPaths)
    {
        this.client = client;
        this.forPage = forPage;
        this.entity = entity;
        this.genericResponseType = genericResponseType;
        this.responseType = null;
        this.additionalPaths = additionalPaths;
    }

    QdsClient getClient()
    {
        return client;
    }

    ForPage getForPage()
    {
        return forPage;
    }

    ClientEntity getEntity()
    {
        return entity;
    }

    GenericType<T> getGenericResponseType()
    {
        return genericResponseType;
    }

    Class<T> getResponseType()
    {
        return responseType;
    }

    String[] getAdditionalPaths()
    {
        return additionalPaths;
    }
}
