package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.HiveCommandResponse;

public interface HiveCommandBuilder extends InvokableBuilder<HiveCommandResponse>
{
    public HiveCommandBuilder query(String query);

    public HiveCommandBuilder scriptLocation(String scriptLocation);

    public HiveCommandBuilder commandType(String commandType);

    public HiveCommandBuilder sampleSize(int sampleSize);

    public HiveCommandBuilder approxModeProgress(double approxModeProgress);

    public HiveCommandBuilder approxModeMaxRt(int approxModeMaxRt);

    public HiveCommandBuilder approxModeMinRt(int approxModeMinRt);

    public HiveCommandBuilder approxAggregations(boolean approxAggregations);

    public HiveCommandBuilder macro(String name, String value);
}
