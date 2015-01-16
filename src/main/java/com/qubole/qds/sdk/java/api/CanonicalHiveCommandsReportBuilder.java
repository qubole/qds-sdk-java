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
package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CanonicalHiveCommandsReport;

public interface CanonicalHiveCommandsReportBuilder extends InvokableBuilder<CanonicalHiveCommandsReport>
{
    public CanonicalHiveCommandsReportBuilder start_date(String start_date);

    public CanonicalHiveCommandsReportBuilder end_date(String end_date);

    public CanonicalHiveCommandsReportBuilder offset(int offset);

    public CanonicalHiveCommandsReportBuilder limit(int limit);

    public CanonicalHiveCommandsReportBuilder sort_column(String sort_column);

    public CanonicalHiveCommandsReportBuilder show_ast(boolean show_ast);
}
