package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Commands;

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
    public PageableInvokableBuilder<Commands> history();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-hive-command/
     *
     * @return new builder
     */
    public HiveCommandBuilder hive();

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-status/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<Command> status(String queryId);
}
