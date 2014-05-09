package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CanonicalHiveCommandsReport;

public interface CanonicalHiveCommandsReportBuilder extends InvokableBuilder<CanonicalHiveCommandsReport>
{
    public CanonicalHiveCommandsReportBuilder start_date(String start_date);

    public CanonicalHiveCommandsReportBuilder end_date(String end_date);

    public CanonicalHiveCommandsReportBuilder offset(int offset);

    public CanonicalHiveCommandsReportBuilder limit(int limit);

    public CanonicalHiveCommandsReportBuilder sort_column(String sort_column);
}
