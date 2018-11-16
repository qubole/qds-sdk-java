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

import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Status;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;

class StoreTablePropertiesBuilderImpl extends InvocationCallbackBase<Status> implements StoreTablePropertiesBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final QdsClient client;
    private final String tableName;
    private final String schemaName;

    @Override
    public StoreTablePropertiesBuilder interval(String interval)
    {
        node.put("interval", interval);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder interval_unit(String interval_unit)
    {
        node.put("interval_unit", interval_unit);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder columns(Map<String, String> columns)
    {
        node.putPOJO("columns", columns);
        return this;
    }

    @Override
    protected InvokeArguments<Status> getInvokeArguments()
    {
        RequestDetails entity = CommandBuilderImplBase.makeJsonEntity(node, RequestDetails.Method.POST);
        return new InvokeArguments<Status>(client, null, entity, Status.class, "hive", schemaName, tableName, "properties");
    }

    StoreTablePropertiesBuilderImpl(QdsClient client, String schemaName, String tableName)
    {
        this.client = client;
        this.schemaName = schemaName;
        this.tableName = tableName;
    }
}
