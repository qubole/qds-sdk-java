package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CanonicalHiveCommandsReportBuilder;
import com.qubole.qds.sdk.java.api.AllCommandsReportBuilder;
import com.qubole.qds.sdk.java.api.ReportsApi;
import com.qubole.qds.sdk.java.client.QdsClient;

class ReportsApiImpl implements ReportsApi
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

    ReportsApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
