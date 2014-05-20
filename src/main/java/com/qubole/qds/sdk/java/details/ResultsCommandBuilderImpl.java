package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.ResultsCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.util.Map;
import java.util.concurrent.Future;

class ResultsCommandBuilderImpl extends InvocationCallbackBase<ResultValue> implements ResultsCommandBuilder
{
    private final QdsClient client;
    private final String queryId;
    private Boolean inline;

    @Override
    public InvokableBuilder<ResultValue> inline(Boolean value)
    {
        inline = value;
        return this;
    }

    @Override
    public Future<ResultValue> invoke()
    {
        ClientEntity entity = null;
        if ( inline != null )
        {
            Map<String, String> queryParams = Maps.newHashMap();
            queryParams.put("inline", inline.toString());
            entity = new ClientEntity(null, ClientEntity.Method.GET, queryParams);
        }
        return invokeRequest(client, null, entity, ResultValue.class, "commands", queryId, "results");
    }

    ResultsCommandBuilderImpl(QdsClient client, String queryId)
    {
        this.client = client;
        this.queryId = queryId;
    }
}
