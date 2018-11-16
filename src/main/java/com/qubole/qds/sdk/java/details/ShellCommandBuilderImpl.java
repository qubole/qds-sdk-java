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

import com.google.common.base.Joiner;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.ShellCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public class ShellCommandBuilderImpl extends CommandBuilderImplBase implements ShellCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public ShellCommandBuilder inline(String inline)
    {
        node.put("inline", inline);
        return this;
    }

    @Override
    public ShellCommandBuilder scriptLocation(String scriptLocation)
    {
        node.put("script_location", scriptLocation);
        return this;
    }

    @Override
    public ShellCommandBuilder files(List<String> fileList)
    {
        String files = Joiner.on(",").join(fileList);
        node.put("files", files);
        return this;
    }

    @Override
    public ShellCommandBuilder archives(List<String> archiveList)
    {
        String archives = Joiner.on(",").join(archiveList);
        node.put("archives", archives);
        return this;
    }

    @Override
    public ShellCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public ShellCommandBuilder name(String commandName) {
        node.put("name", commandName);
        return this;
    }

    @Override
    public ShellCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.SHELL;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    ShellCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "ShellCommand");
    }
}

