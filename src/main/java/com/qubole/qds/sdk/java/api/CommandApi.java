package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Commands;
import javax.ws.rs.core.Response;

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
     * Corresponds to http://www.qubole.com/docs/submit-a-hadoop-jar-command/
     *
     * @return new builder
     */
    public HadoopCommandBuilder hadoop();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-pig-command/
     *
     * @return new builder
     */
    public PigCommandBuilder pig();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-presto-command-2/
     *
     * @return new builder
     */
    public PrestoCommandBuilder presto();

    /**
     *
     * @return new builder
     */
    public DbTapQueryCommandBuilder dbTapQuery();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-import-command/ - simple mode
     *
     * @return new builder
     */
    public DbSimpleImportCommandBuilder dbImportSimple();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-export-command/ - simple mode
     *
     * @return new builder
     */
    public DbSimpleExportCommandBuilder dbExportSimple();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-import-command/ - advanced mode
     *
     * @return new builder
     */
    public DbAdvancedImportCommandBuilder dbImportAdvanced();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-export-command/ - advanced mode
     *
     * @return new builder
     */
    public DbAdvancedExportCommandBuilder dbExportAdvanced();

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-status/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<Command> status(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-results/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public ResultsCommandBuilder results(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-logs/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<String> logs(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/cancel-a-command/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<Response> cancel(String queryId);
}
