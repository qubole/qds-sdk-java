package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.CommandsReportBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandsReport;
import java.util.Map;
import java.util.concurrent.Future;

class CommandsReportBuilderImpl implements CommandsReportBuilder
{
    private final QdsClient client;
    private final Map<String, String> parameters = Maps.newHashMap();

    @Override
    public CommandsReportBuilder start_date(String start_date)
    {
        parameters.put("start_date", start_date);
        return this;
    }

    @Override
    public CommandsReportBuilder end_date(String end_date)
    {
        parameters.put("end_date", end_date);
        return this;
    }

    @Override
    public CommandsReportBuilder offset(int offset)
    {
        parameters.put("offset", Integer.toString(offset));
        return this;
    }

    @Override
    public CommandsReportBuilder limit(int limit)
    {
        parameters.put("limit", Integer.toString(limit));
        return this;
    }

    @Override
    public CommandsReportBuilder sort_column(String sort_column)
    {
        parameters.put("sort_column", sort_column);
        return this;
    }

    @Override
    public CommandsReportBuilder by_user(String by_user)
    {
        parameters.put("by_user", by_user);
        return this;
    }

    @Override
    public Future<CommandsReport> invoke()
    {
        ClientEntity entity = new ClientEntity(null, ClientEntity.Method.GET, parameters);
        return client.invokeRequest(null, entity, CommandsReport.class, "reports", "all_commands");
    }

    CommandsReportBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
