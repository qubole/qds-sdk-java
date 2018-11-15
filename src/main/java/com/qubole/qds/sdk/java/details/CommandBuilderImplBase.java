/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
        catch (IOException e)
        {
            throw new RuntimeException("Could not serialize " + node, e);
        }
        return new RequestDetails(json, method);
    }

    protected abstract ObjectNode getEntity();

    protected abstract BaseCommand.COMMAND_TYPE getCommandType();

    public BaseCommand build()
    {
        ObjectNode cmdNode = QdsClientImpl.getMapper().createObjectNode();
        cmdNode.putAll(getEntity());

        BaseCommandImpl command = new BaseCommandImpl(getCommandType(), cmdNode);
        return command;
    }

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
