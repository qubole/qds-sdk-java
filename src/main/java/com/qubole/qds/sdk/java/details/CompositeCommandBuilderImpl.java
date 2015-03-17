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

import com.qubole.qds.sdk.java.api.CompositeCommandBuilder;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import org.codehaus.jackson.node.ObjectNode;

import java.util.ArrayList;

public class CompositeCommandBuilderImpl extends CommandBuilderImplBase implements CompositeCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    ArrayList<ObjectNode> subCommands = new ArrayList<ObjectNode>();

    @Override
    public CompositeCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public CompositeCommandBuilder name(String queryName) {
        node.put("name", queryName);
        return this;
    }

    @Override
    public CompositeCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    public CompositeCommandBuilder addSubCommand(BaseCommand command)
    {
        // for now we will work with our impl classes only
        if (((command instanceof BaseCommandImpl) == false)
                || (checkCommandTypeSupported(command) == false))
        {
            throw new RuntimeException("Command Type not supported: " + command.getCommandType());
        }

        BaseCommandImpl baseCommandImpl = (BaseCommandImpl) command;
        ObjectNode cmdNode = baseCommandImpl.getNode();
        if (cmdNode == null)
        {
            throw new RuntimeException("Incomplete Command");
        }

        // remove not supported attributes
        // in workflow case, workflow level overrides will work
        cmdNode.remove("tags");
        cmdNode.remove("name");
        cmdNode.remove("label");

        subCommands.add(cmdNode);
        node.putPOJO("sub_commands", subCommands.toArray());
        return this;
    }

    // add a check if a command type is supported in
    // workflow or not
    private boolean checkCommandTypeSupported(BaseCommand command)
    {
        // for command type none or composite
        // we dont support adding it as base command
        if ((command.getCommandType() == BaseCommand.COMMAND_TYPE.NONE)
            || (command.getCommandType() == BaseCommand.COMMAND_TYPE.COMPOSITE))
        {
            return false;
        }
        return true;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.COMPOSITE;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    CompositeCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "CompositeCommand");
    }

}
