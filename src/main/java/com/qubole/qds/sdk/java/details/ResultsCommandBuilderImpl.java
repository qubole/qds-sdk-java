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

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.ResultsCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.util.Map;

class ResultsCommandBuilderImpl extends InvocationCallbackBase<ResultValue> implements ResultsCommandBuilder
{
    private final QdsClient client;
    private final String queryId;
    private Boolean inline;

    @Override
    public InvokableBuilder<ResultValue> inline(Boolean value)
    {
        inline = value;
        return this;
    }

    @Override
    protected InvokeArguments<ResultValue> getInvokeArguments()
    {
        RequestDetails entity;
        if ( inline != null )
        {
            Map<String, String> queryParams = Maps.newHashMap();
            queryParams.put("inline", inline.toString());
            entity = new RequestDetails(null, RequestDetails.Method.GET, queryParams);
            entity.allowToBeRetried();
        }
        else
        {
            entity = RequestDetails.retry();
        }
        return new InvokeArguments<ResultValue>(client, null, entity, ResultValue.class, "commands", queryId, "results");
    }

    ResultsCommandBuilderImpl(QdsClient client, String queryId)
    {
        this.client = client;
        this.queryId = queryId;
    }
}
