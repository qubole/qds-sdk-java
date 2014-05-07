package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.HiveCommand;
import com.qubole.qds.sdk.java.entities.HiveCommandResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class HiveCommandBuilderImpl implements HiveCommandBuilder
{
    private final QdsClient client;
    private final HiveCommand hiveCommand = new HiveCommand();

    @Override
    public Future<HiveCommandResponse> invoke()
    {
        return client.invokeRequest(null, new ClientEntity(hiveCommand), HiveCommandResponse.class, "commands");
    }

    @Override
    public HiveCommandBuilder query(String query)
    {
        hiveCommand.setQuery(query);
        return this;
    }

    @Override
    public HiveCommandBuilder scriptLocation(String scriptLocation)
    {
        hiveCommand.setScript_location(scriptLocation);
        return this;
    }

    @Override
    public HiveCommandBuilder commandType(String commandType)
    {
        hiveCommand.setCommand_type(commandType);
        return this;
    }

    @Override
    public HiveCommandBuilder sampleSize(int sampleSize)
    {
        hiveCommand.setSample_size(sampleSize);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeProgress(double approxModeProgress)
    {
        hiveCommand.setApprox_mode_progress(approxModeProgress);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeMaxRt(int approxModeMaxRt)
    {
        hiveCommand.setApprox_mode_max_rt(approxModeMaxRt);
        return this;
    }

    @Override
    public HiveCommandBuilder approxModeMinRt(int approxModeMinRt)
    {
        hiveCommand.setApprox_mode_min_rt(approxModeMinRt);
        return this;
    }

    @Override
    public HiveCommandBuilder approxAggregations(boolean approxAggregations)
    {
        hiveCommand.setApprox_aggregations(approxAggregations);
        return this;
    }

    @Override
    public HiveCommandBuilder macro(String name, String value)
    {
        if ( hiveCommand.getMacros() == null )
        {
            hiveCommand.setMacros(Lists.<Map<String, String>>newArrayList());
        }

        HashMap<String, String> map = Maps.newHashMap();
        map.put(name, value);
        hiveCommand.getMacros().add(map);
        return this;
    }

    HiveCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
