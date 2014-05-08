package com.qubole.qds.sdk.java.details;

import com.google.common.base.Preconditions;

public class ClientEntity
{
    private final Object entity;
    private final Method method;

    public enum Method
    {
        POST,
        PUT,
        DELETE
    }

    public ClientEntity(Object entity)
    {
        this(entity, Method.POST);
    }

    public ClientEntity(Object entity, Method method)
    {
        this.entity = Preconditions.checkNotNull(entity, "entity cannot be null");
        this.method = method;
    }

    public Object getEntity()
    {
        return entity;
    }

    public Method getMethod()
    {
        return method;
    }

    public static ClientEntity forDelete()
    {
        return new ClientEntity();
    }

    private ClientEntity()
    {
        entity = null;
        method = Method.DELETE;
    }
}
