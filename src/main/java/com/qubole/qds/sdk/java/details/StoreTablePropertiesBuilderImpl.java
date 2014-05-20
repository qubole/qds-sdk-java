package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.StoreTablePropertiesBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Status;
import org.codehaus.jackson.node.ObjectNode;
import java.util.Map;

class StoreTablePropertiesBuilderImpl extends InvocationCallbackBase<Status> implements StoreTablePropertiesBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final QdsClient client;
    private final String tableName;

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
        ClientEntity entity = CommandBuilderImplBase.makeJsonEntity(node, ClientEntity.Method.POST);
        return new InvokeArguments<Status>(client, null, entity, Status.class, "hive", "default", tableName, "properties");
    }

    StoreTablePropertiesBuilderImpl(QdsClient client, String tableName)
    {
        this.client = client;
        this.tableName = tableName;
    }
}
