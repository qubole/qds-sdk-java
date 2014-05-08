package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.TableProperties;
import java.util.Map;
import java.util.concurrent.Future;

class StoreTablePropertiesBuilderImpl implements StoreTablePropertiesBuilder
{
    private final QdsClient client;
    private final String tableName;
    private final TableProperties tableProperties = new TableProperties();

    @Override
    public StoreTablePropertiesBuilder interval(String interval)
    {
        tableProperties.setInterval(interval);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder interval_unit(String interval_unit)
    {
        tableProperties.setInterval_unit(interval_unit);
        return this;
    }

    @Override
    public StoreTablePropertiesBuilder columns(Map<String, String> columns)
    {
        tableProperties.setColumns(columns);
        return this;
    }

    @Override
    public Future<Status> invoke()
    {
        ClientEntity entity = new ClientEntity(tableProperties, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, Status.class, "hive", "default", tableName, "properties");
    }

    StoreTablePropertiesBuilderImpl(QdsClient client, String tableName)
    {
        this.client = client;
        this.tableName = tableName;
    }
}
