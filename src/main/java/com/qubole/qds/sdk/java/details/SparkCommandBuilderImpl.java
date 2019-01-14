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

import com.fasterxml.jackson.databind.node.ObjectNode;

import com.qubole.qds.sdk.java.api.BaseCommand.COMMAND_TYPE;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.SparkCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

public class SparkCommandBuilderImpl extends CommandBuilderImplBase implements SparkCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public SparkCommandBuilder program(String program)
    {
        node.put("program", program);
        return this;
    }

    @Override
    public SparkCommandBuilder cmdLine(String cmdLine)
    {
        node.put("cmdline", cmdLine);
        return this;
    }

    @Override
    public SparkCommandBuilder language(String language)
    {
        node.put("language", language);
        return this;
    }

    @Override
    public SparkCommandBuilder sql(String sql)
    {
        node.put("sql", sql);
        return this;
    }

    @Override
    public SparkCommandBuilder userProgramArguments(String userProgramArguments) {
        node.put("user_program_arguments", userProgramArguments);
        return this;
    }

    @Override
    public SparkCommandBuilder arguments(String arguments) {
        node.put("arguments", arguments);
        return this;
    }

    @Override
    public SparkCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public SparkCommandBuilder name(String commandName) {
        node.put("name", commandName);
        return this;
    }

    @Override
    public SparkCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    SparkCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "SparkCommand");
    }

    @Override
    protected COMMAND_TYPE getCommandType() {
        return BaseCommand.COMMAND_TYPE.SPARK;
    }
}

