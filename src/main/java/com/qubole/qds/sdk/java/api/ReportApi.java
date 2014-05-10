package com.qubole.qds.sdk.java.api;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/reports-api/
 */
public interface ReportApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/canonical-hive-commands-report/
     *
     * @return builder
     */
    public CanonicalHiveCommandsReportBuilder canonicalHiveCommandsReport();

    /**
     * Corresponds to http://www.qubole.com/docs/commands-report/
     *
     * @return builder
     */
    public AllCommandsReportBuilder allCommandsReport();
}
