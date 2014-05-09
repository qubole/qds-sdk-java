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

    @Override
    public InvokableBuilder<List<NameAndType>> table(String tableName)
    {
        GenericType<List<NameAndType>> genericType = new GenericType<List<NameAndType>>(){};
        return new GenericInvokableBuilderImpl<List<NameAndType>>(client, null, genericType, "hive", "default", tableName);
    }

    @Override
    public StoreTablePropertiesBuilder storeTableProperties(String tableName)
    {
        return new StoreTablePropertiesBuilderImpl(client, tableName);
    }

    @Override
    public InvokableBuilder<TableProperties> getTableProperties(String tableName)
    {
        return new GenericInvokableBuilderImpl<TableProperties>(client, null, TableProperties.class, "hive", "default", tableName, "properties");
    }

    @Override
    public InvokableBuilder<Status> deleteTableProperties(String tableName)
    {
        return new GenericInvokableBuilderImpl<Status>(client, new ClientEntity(null, ClientEntity.Method.DELETE), Status.class, "hive", "default", tableName, "properties");
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
