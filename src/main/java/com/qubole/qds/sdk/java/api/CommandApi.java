package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.details.CommandHistoryBuilder;
import com.qubole.qds.sdk.java.details.HiveCommandBuilder;

public interface CommandApi
{
    public CommandHistoryBuilder history();

    public HiveCommandBuilder hive();
}
