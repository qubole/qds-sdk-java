package com.qubole.qds.sdk.java.details;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RequestDetails
{
    private final Object entity;
    private final Method method;
    private final Map<String, String> queryParams;
    private final AtomicBoolean canBeRetried = new AtomicBoolean(false);

    public enum Method
    {
        GET,
        POST,
        PUT,
        DELETE
    }

    public static RequestDetails retry()
    {
        RequestDetails entity = new RequestDetails(null, Method.GET);
        entity.allowToBeRetried();
        return entity;
    }

    public RequestDetails(Object entity)
    {
        this(entity, Method.POST, null);
    }

    public RequestDetails(Object entity, Method method)
    {
        this(entity, method, null);
    }

    public RequestDetails(Object entity, Method method, Map<String, String> queryParams)
    {
        this.entity = entity;
        this.method = method;
        this.queryParams = (queryParams != null) ? ImmutableMap.copyOf(queryParams) : null;
    }

    public Object getEntity()
    {
        return entity;
    }

    public Method getMethod()
    {
        return method;
    }

    public Map<String, String> getQueryParams()
    {
        return queryParams;
    }

    public boolean canBeRetried()
    {
        return canBeRetried.get();
    }

    public void allowToBeRetried()
    {
        canBeRetried.set(true);
    }
}
