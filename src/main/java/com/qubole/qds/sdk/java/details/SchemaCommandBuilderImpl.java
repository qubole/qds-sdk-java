package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.SchemaCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Schema;
import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

class SchemaCommandBuilderImpl implements SchemaCommandBuilder
{
    private final QdsClient client;
    private String filter;
    private boolean describe;

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
    public Future<List<Schema>> invoke()
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
        return client.invokeRequest(null, new ClientEntity(null, ClientEntity.Method.GET, params), responseType, "hive", "default");
    }

    SchemaCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
