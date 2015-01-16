/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.details;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.api.AllCommandsReportBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.AllCommandsReport;
import java.util.Map;

class AllCommandsReportBuilderImpl extends InvocationCallbackBase<AllCommandsReport> implements AllCommandsReportBuilder
{
    private final QdsClient client;
    private final Map<String, String> parameters = Maps.newHashMap();

    @Override
    public AllCommandsReportBuilder start_date(String start_date)
    {
        parameters.put("start_date", start_date);
        return this;
    }

    @Override
    public AllCommandsReportBuilder end_date(String end_date)
    {
        parameters.put("end_date", end_date);
        return this;
    }

    @Override
    public AllCommandsReportBuilder offset(int offset)
    {
        parameters.put("offset", Integer.toString(offset));
        return this;
    }

    @Override
    public AllCommandsReportBuilder limit(int limit)
    {
        parameters.put("limit", Integer.toString(limit));
        return this;
    }

    @Override
    public AllCommandsReportBuilder sort_column(String sort_column)
    {
        parameters.put("sort_column", sort_column);
        return this;
    }

    @Override
    public AllCommandsReportBuilder by_user(boolean by_user)
    {
        parameters.put("by_user", String.valueOf(by_user));
        return this;
    }

    @Override
    protected InvokeArguments<AllCommandsReport> getInvokeArguments()
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.GET, parameters);
        return new InvokeArguments<AllCommandsReport>(client, null, entity, AllCommandsReport.class, "reports", "all_commands");
    }

    AllCommandsReportBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
