package com.qubole.qds.sdk.java.details;

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
        this.entity = entity;
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
}
