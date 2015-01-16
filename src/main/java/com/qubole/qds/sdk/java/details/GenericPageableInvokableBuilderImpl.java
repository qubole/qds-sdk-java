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
