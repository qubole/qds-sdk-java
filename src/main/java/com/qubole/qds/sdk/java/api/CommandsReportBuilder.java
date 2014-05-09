package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandsReport;

public interface CommandsReportBuilder extends InvokableBuilder<CommandsReport>
{
    public CommandsReportBuilder start_date(String start_date);

    public CommandsReportBuilder end_date(String end_date);

    public CommandsReportBuilder offset(int offset);

    public CommandsReportBuilder limit(int limit);

    public CommandsReportBuilder sort_column(String sort_column);

    public CommandsReportBuilder by_user(String by_user);
}
