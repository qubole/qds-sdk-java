package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.ResultsCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.ResultValue;
import org.codehaus.jackson.node.ObjectNode;
import java.util.concurrent.Future;

class ResultsCommandBuilderImpl extends InvocationCallbackBase<ResultValue> implements ResultsCommandBuilder
{
    private final QdsClient client;
    private final String queryId;
    private Boolean inline;

    @Override
    public InvokableBuilder<ResultValue> inline(Boolean value)
    {
        inline = true;
        return this;
    }

    @Override
    public Future<ResultValue> invoke()
    {
        ClientEntity entity = null;
        if ( inline != null )
        {
            ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
            node.put("inline", inline);
            entity = CommandBuilderImplBase.makeJsonEntity(node, ClientEntity.Method.POST);
        }
        return invokeRequest(client, null, entity, ResultValue.class, "commands", queryId, "results");
    }

    ResultsCommandBuilderImpl(QdsClient client, String queryId)
    {
        this.client = client;
        this.queryId = queryId;
    }
}
