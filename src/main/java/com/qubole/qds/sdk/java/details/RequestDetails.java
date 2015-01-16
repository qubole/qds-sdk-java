/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
