package com.qubole.qds.sdk.java.api;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/command-api/
 */
public interface CommandApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/view-command-history/
     *
     * @return new builder
     */
    public CommandHistoryBuilder history();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-hive-command/
     *
     * @return new builder
     */
    public HiveCommandBuilder hive();
}
