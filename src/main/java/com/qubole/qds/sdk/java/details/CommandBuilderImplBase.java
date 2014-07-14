package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;

abstract class CommandBuilderImplBase extends InvocationCallbackBase<CommandResponse> implements InvokableBuilder<CommandResponse>
{
    private final QdsClient client;
    private final RequestDetails.Method method;

    @Override
    protected InvokeArguments<CommandResponse> getInvokeArguments()
    {
        RequestDetails entity = makeJsonEntity(getEntity(), method);
        return new InvokeArguments<CommandResponse>(client, null, entity, CommandResponse.class, "commands");
    }

    static RequestDetails makeJsonEntity(ObjectNode node, RequestDetails.Method method)
    {
        String json;
        try
        {
            json = QdsClientImpl.getMapper().writeValueAsString(node);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize " + node, e);
        }
        return new RequestDetails(json, method);
    }

    protected abstract ObjectNode getEntity();

    protected CommandBuilderImplBase(QdsClient client)
    {
        this(client, RequestDetails.Method.POST);
    }

    protected CommandBuilderImplBase(QdsClient client, RequestDetails.Method method)
    {
        this.client = client;
        this.method = method;
    }
}
