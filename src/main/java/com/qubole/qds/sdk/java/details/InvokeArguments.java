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

import com.qubole.qds.sdk.java.client.QdsClient;
import javax.ws.rs.core.GenericType;

public class InvokeArguments<T>
{
    private final QdsClient client;
    private final ForPage forPage;
    private final RequestDetails entity;
    private final GenericType<T> genericResponseType;
    private final Class<T> responseType;
    private final String[] additionalPaths;

    InvokeArguments(QdsClient client, ForPage forPage, RequestDetails entity, Class<T> responseType, String... additionalPaths)
    {
        this.client = client;
        this.forPage = forPage;
        this.entity = entity;
        this.responseType = responseType;
        this.additionalPaths = additionalPaths;
        this.genericResponseType = null;
    }

    InvokeArguments(QdsClient client, ForPage forPage, RequestDetails entity, GenericType<T> genericResponseType, String... additionalPaths)
    {
        this.client = client;
        this.forPage = forPage;
        this.entity = entity;
        this.genericResponseType = genericResponseType;
        this.responseType = null;
        this.additionalPaths = additionalPaths;
    }

    public QdsClient getClient()
    {
        return client;
    }

    public ForPage getForPage()
    {
        return forPage;
    }

    public RequestDetails getEntity()
    {
        return entity;
    }

    public GenericType<T> getGenericResponseType()
    {
        return genericResponseType;
    }

    public Class<T> getResponseType()
    {
        return responseType;
    }
    
    public String[] getAdditionalPaths()
    {
        return additionalPaths;
    }
}
