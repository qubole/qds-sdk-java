package com.qubole.qds.sdk.java.api;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/reports-api/
 */
public interface ReportsApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/canonical-hive-commands-report/
     *
     * @return builder
     */
    public CanonicalHiveCommandsReportBuilder canonicalHiveCommands();

    /**
     * Corresponds to http://www.qubole.com/docs/commands-report/
     *
     * @return builder
     */
    public CommandsReportBuilder commandsReport();
}
