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
import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.api.SchemaCommandBuilder;
import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.NameAndType;
import com.qubole.qds.sdk.java.entities.SchemaListDescribed;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.TableProperties;
import javax.ws.rs.core.GenericType;
import java.util.List;

class HiveMetadataApiImpl implements HiveMetadataApi
{
    private final QdsClient client;

    private String [] getSchemaElems(String tableName)
    {
        String [] schemaElems = new String[2];
        schemaElems[0] = "default";
        schemaElems[1] = tableName;

        if (tableName.contains("."))
        {
            schemaElems = tableName.split("\\.");
        }
        return schemaElems;
    }

    @Override
    public InvokableBuilder<List<NameAndType>> table(String tableName)
    {
        GenericType<List<NameAndType>> genericType = new GenericType<List<NameAndType>>(){};
        String [] schemaElems = getSchemaElems(tableName);
        return new GenericInvokableBuilderImpl<List<NameAndType>>(client, null, genericType,
                "hive", schemaElems[0], schemaElems[1]);
    }

    @Override
    public StoreTablePropertiesBuilder storeTableProperties(String tableName)
    {
        String [] schemaElems = getSchemaElems(tableName);
        return new StoreTablePropertiesBuilderImpl(client, schemaElems[0], schemaElems[1]);
    }

    @Override
    public InvokableBuilder<TableProperties> getTableProperties(String tableName)
    {
        String [] schemaElems = getSchemaElems(tableName);
        return new GenericInvokableBuilderImpl<TableProperties>(client, RequestDetails.retry(),
                TableProperties.class, "hive", schemaElems[0], schemaElems[1], "properties");
    }

    @Override
    public InvokableBuilder<Status> deleteTableProperties(String tableName)
    {
        String [] schemaElems = getSchemaElems(tableName);
        return new GenericInvokableBuilderImpl<Status>(client, new RequestDetails(null, RequestDetails.Method.DELETE),
                Status.class, "hive", schemaElems[0], schemaElems[1], "properties");
    }

    @Override
    public SchemaCommandBuilder schema()
    {
        return new SchemaCommandBuilderImpl(client);
    }

    public InvokableBuilder<List<String>> getSchemaNames()
    {
        RequestDetails requestDetails = new RequestDetails(null, RequestDetails.Method.GET, Maps.newHashMap(ImmutableMap.of("describe", "false")));
        GenericType<List<String>> responseType = new GenericType<List<String>>(){};
        return new GenericInvokableBuilderImpl<List<String>>(client, requestDetails, responseType, "hive");
    }

    public PageableInvokableBuilder<SchemaListDescribed> getSchemaListDescribed()
    {
        RequestDetails requestDetails = new RequestDetails(null, RequestDetails.Method.GET, Maps.newHashMap(ImmutableMap.of("describe", "true")));
        return new GenericPageableInvokableBuilderImpl<SchemaListDescribed>(client, requestDetails, SchemaListDescribed.class, "hive");
    }

    HiveMetadataApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
