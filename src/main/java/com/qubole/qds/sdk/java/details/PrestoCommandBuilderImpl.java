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
import com.qubole.qds.sdk.java.api.PrestoCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.fasterxml.jackson.databind.node.ObjectNode;

class PrestoCommandBuilderImpl extends CommandBuilderImplBase implements PrestoCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public PrestoCommandBuilder script_location(String script_location)
    {
        node.put("script_location", script_location);
        return this;
    }

    @Override
    public PrestoCommandBuilder query(String query)
    {
        node.put("query", query);
        return this;
    }

    @Override
    public PrestoCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public PrestoCommandBuilder name(String queryName) {
        node.put("name", queryName);
        return this;
    }

    @Override
    public PrestoCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.PRESTO;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    PrestoCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "PrestoCommand");
    }
}
