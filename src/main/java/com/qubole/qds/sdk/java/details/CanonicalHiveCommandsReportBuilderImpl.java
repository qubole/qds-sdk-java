package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.CanonicalHiveCommandsReportBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CanonicalHiveCommandsReport;
import java.util.Map;

class CanonicalHiveCommandsReportBuilderImpl extends InvocationCallbackBase<CanonicalHiveCommandsReport> implements CanonicalHiveCommandsReportBuilder
{
    private final QdsClient client;
    private final Map<String, String> parameters = Maps.newHashMap();

    public CanonicalHiveCommandsReportBuilder start_date(String start_date)
    {
        parameters.put("start_date", start_date);
        return this;
    }

    @Override
    public CanonicalHiveCommandsReportBuilder end_date(String end_date)
    {
        parameters.put("end_date", end_date);
        return this;
    }

    @Override
    public CanonicalHiveCommandsReportBuilder offset(int offset)
    {
        parameters.put("offset", Integer.toString(offset));
        return this;
    }

    @Override
    public CanonicalHiveCommandsReportBuilder limit(int limit)
    {
        parameters.put("limit", Integer.toString(limit));
        return this;
    }

    @Override
    public CanonicalHiveCommandsReportBuilder sort_column(String sort_column)
    {
        parameters.put("sort_column", sort_column);
        return this;
    }

    @Override
    protected InvokeArguments<CanonicalHiveCommandsReport> getInvokeArguments()
    {
        ClientEntity entity = new ClientEntity(null, ClientEntity.Method.GET, parameters);
        return new InvokeArguments<CanonicalHiveCommandsReport>(client, null, entity, CanonicalHiveCommandsReport.class, "reports", "canonical_hive_commands");
    }

    CanonicalHiveCommandsReportBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
