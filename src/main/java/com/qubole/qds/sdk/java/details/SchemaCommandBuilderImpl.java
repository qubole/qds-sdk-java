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
