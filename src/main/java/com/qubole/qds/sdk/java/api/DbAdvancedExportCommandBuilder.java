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

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface DbAdvancedExportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbAdvancedExportCommandBuilder db_table(String db_table);

    public DbAdvancedExportCommandBuilder dbtap_id(String dbtap_id);

    public DbAdvancedExportCommandBuilder export_dir(String export_dir);

    public DbAdvancedExportCommandBuilder db_update_mode(String db_update_mode);

    public DbAdvancedExportCommandBuilder db_update_keys(String db_update_keys);

    public DbAdvancedExportCommandBuilder fields_terminated_by(String fields_terminated_by);

    public DbAdvancedExportCommandBuilder tags(String[] queryTags);

    public DbAdvancedExportCommandBuilder use_customer_cluster(boolean use_customer_cluster);

    public DbAdvancedExportCommandBuilder customer_cluster_label(String customer_cluster_label);

    public BaseCommand build();
}
