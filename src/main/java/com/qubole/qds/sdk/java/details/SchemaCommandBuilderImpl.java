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
import com.qubole.qds.sdk.java.api.SchemaCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Schema;
import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

class SchemaCommandBuilderImpl extends InvocationCallbackBase<List<Schema>> implements SchemaCommandBuilder
{
    private final QdsClient client;
    private String filter;
    private boolean describe;
    private String schemaName = "default";

    @Override
    public SchemaCommandBuilder filter(String filter)
    {
        this.filter = filter;
        return this;
    }

    @Override
    public SchemaCommandBuilder described()
    {
        describe = true;
        return this;
    }

    @Override
    public SchemaCommandBuilder schema(String schemaName)
    {
        this.schemaName = schemaName;
        return this;
    }
    @Override
    protected InvokeArguments<List<Schema>> getInvokeArguments()
    {
        Map<String, String> params = Maps.newHashMap();
        if ( filter != null )
        {
            params.put("filter", filter);
        }
        if ( describe )
        {
            params.put("describe", "true");
        }

        GenericType<List<Schema>> responseType = new GenericType<List<Schema>>(){};
        return new InvokeArguments<List<Schema>>(client, null, new RequestDetails(null, RequestDetails.Method.GET, params), responseType, "hive", schemaName);
    }

    SchemaCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
