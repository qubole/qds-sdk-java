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

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.fasterxml.jackson.databind.node.ObjectNode;

class HadoopCommandBuilderImpl extends CommandBuilderImplBase implements HadoopCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public HadoopCommandBuilder sub_command(SubCommandType subCommandType)
    {
        node.put("sub_command", subCommandType.name().toLowerCase());
        return this;
    }

    @Override
    public HadoopCommandBuilder sub_command_args(String sub_command_args)
    {
        node.put("sub_command_args", sub_command_args);
        return this;
    }

    @Override
    public HadoopCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public HadoopCommandBuilder name(String commandName) {
        node.put("name", commandName);
        return this;
    }

    @Override
    public HadoopCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.HADOOP;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    HadoopCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "HadoopCommand");
    }
}
