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
    public CanonicalHiveCommandsReportBuilder show_ast(boolean show_ast)
    {
        parameters.put("show_ast", String.valueOf(show_ast));
        return this;
    }

    @Override
    protected InvokeArguments<CanonicalHiveCommandsReport> getInvokeArguments()
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.GET, parameters);
        return new InvokeArguments<CanonicalHiveCommandsReport>(client, null, entity, CanonicalHiveCommandsReport.class, "reports", "canonical_hive_commands");
    }

    CanonicalHiveCommandsReportBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
