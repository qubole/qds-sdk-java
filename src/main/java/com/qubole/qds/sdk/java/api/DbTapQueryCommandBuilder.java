package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbTapQueryCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbTapQueryCommandBuilder query(String query);

    public DbTapQueryCommandBuilder db_tap_id(int db_tap_id);

    public DbTapQueryCommandBuilder commandType(String commandType);

}
