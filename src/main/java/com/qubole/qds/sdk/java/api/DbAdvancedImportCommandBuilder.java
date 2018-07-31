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

public interface DbAdvancedImportCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public DbAdvancedImportCommandBuilder hive_table(String hive_table);

    public DbAdvancedImportCommandBuilder hive_serde(String hive_serde);

    public DbAdvancedImportCommandBuilder dbtap_id(String dbtap_id);

    public DbAdvancedImportCommandBuilder db_extract_query(String db_extract_query);

    public DbAdvancedImportCommandBuilder db_boundary_query(String db_boundary_query);

    public DbAdvancedImportCommandBuilder db_split_column(String db_split_column);

    public DbAdvancedImportCommandBuilder db_parallelism(String db_parallelism);

    public DbAdvancedImportCommandBuilder tags(String[] queryTags);

    public DbAdvancedImportCommandBuilder use_customer_cluster(boolean use_customer_cluster);

    public DbAdvancedImportCommandBuilder customer_cluster_label(String customer_cluster_label);

    public BaseCommand build();
}
