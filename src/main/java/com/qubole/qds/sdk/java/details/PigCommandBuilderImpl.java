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

import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;
import java.util.Map;

class PigCommandBuilderImpl extends CommandBuilderImplBase implements PigCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public PigCommandBuilder script_location(String script_location)
    {
        node.put("script_location", script_location);
        return this;
    }

    @Override
    public PigCommandBuilder parameters(Map<String, Object> parameters)
    {
        node.putPOJO("parameters", parameters);
        return this;
    }

    @Override
    public PigCommandBuilder latin_statements(String latin_statements)
    {
        node.put("latin_statements", latin_statements);
        return this;
    }

    @Override
    public PigCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public PigCommandBuilder name(String commmandName) {
        node.put("name", commmandName);
        return this;
    }

    @Override
    public PigCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    PigCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "PigCommand");
    }
}
