package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.Invokable;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.HiveCommand;
import com.qubole.qds.sdk.java.entities.HiveCommandResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class HiveCommandBuilder implements Invokable<HiveCommandResponse>
{
    private final QdsClient client;
    private final HiveCommand hiveCommand = new HiveCommand();

    @Override
    public Future<HiveCommandResponse> invoke()
    {
        return client.invokeRequest(null, hiveCommand, HiveCommandResponse.class, "commands");
    }

    public HiveCommandBuilder query(String query)
    {
        hiveCommand.setQuery(query);
        return this;
    }

    public HiveCommandBuilder scriptLocation(String scriptLocation)
    {
        hiveCommand.setScript_location(scriptLocation);
        return this;
    }

    public HiveCommandBuilder commandType(String commandType)
    {
        hiveCommand.setCommand_type(commandType);
        return this;
    }

    public HiveCommandBuilder sampleSize(int sampleSize)
    {
        hiveCommand.setSample_size(sampleSize);
        return this;
    }

    public HiveCommandBuilder approxModeProgress(double approxModeProgress)
    {
        hiveCommand.setApprox_mode_progress(approxModeProgress);
        return this;
    }

    public HiveCommandBuilder approxModeMaxRt(int approxModeMaxRt)
    {
        hiveCommand.setApprox_mode_max_rt(approxModeMaxRt);
        return this;
    }

    public HiveCommandBuilder approxModeMinRt(int approxModeMinRt)
    {
        hiveCommand.setApprox_mode_min_rt(approxModeMinRt);
        return this;
    }

    public HiveCommandBuilder approxAggregations(boolean approxAggregations)
    {
        hiveCommand.setApprox_aggregations(approxAggregations);
        return this;
    }

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

    HiveCommandBuilder(QdsClient client)
    {
        this.client = client;
    }
}
