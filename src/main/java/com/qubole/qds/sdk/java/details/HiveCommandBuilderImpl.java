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

import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HiveCommandBuilderImpl extends CommandBuilderImplBase implements HiveCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final List<Map<String, String>> macros =  new ArrayList<Map<String, String>>();

    @Override
    public HiveCommandBuilder query(String query)
    {
        node.put("query", query);
        return this;
    }

    @Override
    public HiveCommandBuilder scriptLocation(String scriptLocation)
    {
        node.put("script_location", scriptLocation);
        return this;
    }

    @Override
    public HiveCommandBuilder commandType(String commandType)
    {
        node.put("command_type", commandType);
        return this;
    }

    @Override
    public HiveCommandBuilder sampleSize(int sampleSize)
    {
        node.put("sample_size", sampleSize);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeProgress(double approxModeProgress)
    {
        node.put("approx_mode_progress", approxModeProgress);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeMaxRt(int approxModeMaxRt)
    {
        node.put("approx_mode_max_rt", approxModeMaxRt);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeMinRt(int approxModeMinRt)
    {
        node.put("approx_mode_min_rt", approxModeMinRt);
        return this;
    }

    @Override
    public HiveCommandBuilder approxAggregations(boolean approxAggregations)
    {
        node.put("approx_aggregations", approxAggregations);
        return this;
    }

    @Override
    public HiveCommandBuilder macro(String name, String value)
    {
        Map<String, String> macro = new HashMap<String, String>();
        macro.put(name, value);
        macros.add(macro);
        node.putPOJO("macros", macros);
        return this;
    }

    @Override
    public HiveCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public HiveCommandBuilder name(String queryName) {
        node.put("name", queryName);
        return this;
    }

    @Override
    public HiveCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.HIVE;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    HiveCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "HiveCommand");
    }
}
