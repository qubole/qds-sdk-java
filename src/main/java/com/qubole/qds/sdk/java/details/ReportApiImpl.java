package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CanonicalHiveCommandsReportBuilder;
import com.qubole.qds.sdk.java.api.AllCommandsReportBuilder;
import com.qubole.qds.sdk.java.api.ReportApi;
import com.qubole.qds.sdk.java.client.QdsClient;

class ReportApiImpl implements ReportApi
{
    private final QdsClient client;

    @Override
    public CanonicalHiveCommandsReportBuilder canonicalHiveCommandsReport()
    {
        return new CanonicalHiveCommandsReportBuilderImpl(client);
    }

    @Override
    public AllCommandsReportBuilder allCommandsReport()
    {
        return new AllCommandsReportBuilderImpl(client);
    }

    ReportApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
