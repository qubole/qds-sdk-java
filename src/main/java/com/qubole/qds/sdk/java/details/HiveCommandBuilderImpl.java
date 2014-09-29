package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;
import java.util.Map;

public class HiveCommandBuilderImpl extends CommandBuilderImplBase implements HiveCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final Map<String, String> macros = Maps.newHashMap();

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
        macros.put(name, value);
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
