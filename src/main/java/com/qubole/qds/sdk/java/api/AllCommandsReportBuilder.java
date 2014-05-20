package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.AllCommandsReport;

public interface AllCommandsReportBuilder extends InvokableBuilder<AllCommandsReport>
{
    public AllCommandsReportBuilder start_date(String start_date);

    public AllCommandsReportBuilder end_date(String end_date);

    public AllCommandsReportBuilder offset(int offset);

    public AllCommandsReportBuilder limit(int limit);

    public AllCommandsReportBuilder sort_column(String sort_column);

    public AllCommandsReportBuilder by_user(boolean by_user);
}
