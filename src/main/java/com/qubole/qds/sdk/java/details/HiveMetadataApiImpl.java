package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.SchemaCommandBuilder;
import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.NameAndType;
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
            schemaElems = tableName.split(".");
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

    HiveMetadataApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
