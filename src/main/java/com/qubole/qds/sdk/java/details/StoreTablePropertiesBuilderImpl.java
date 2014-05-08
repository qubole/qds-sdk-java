package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.StoreTableProperties;
import java.util.Map;
import java.util.concurrent.Future;

class StoreTablePropertiesBuilderImpl implements StoreTablePropertiesBuilder
{
    private final QdsClient client;
    private final String tableName;
    private final StoreTableProperties storeTableProperties = new StoreTableProperties();

    @Override
    public StoreTablePropertiesBuilder interval(String interval)
    {
        storeTableProperties.setInterval(interval);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder interval_unit(String interval_unit)
    {
        storeTableProperties.setInterval_unit(interval_unit);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder columns(Map<String, String> columns)
    {
        storeTableProperties.setColumns(columns);
        return this;
    }

    @Override
    public Future<Status> invoke()
    {
        ClientEntity entity = new ClientEntity(storeTableProperties, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, Status.class, "hive", "default", tableName, "properties");
    }

    StoreTablePropertiesBuilderImpl(QdsClient client, String tableName)
    {
        this.client = client;
        this.tableName = tableName;
    }
}
