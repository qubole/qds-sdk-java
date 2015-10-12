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

public interface DbSimpleImportCommandBuilder extends InvokableCommandBuilder<CommandResponse>
{
    public DbSimpleImportCommandBuilder hive_table(String hive_table);

    public DbSimpleImportCommandBuilder dbtap_id(String dbtap_id);

    public DbSimpleImportCommandBuilder db_table(String db_table);

    public DbSimpleImportCommandBuilder db_where(String db_where);

    public DbSimpleImportCommandBuilder db_parallelism(String db_parallelism);

    public DbSimpleImportCommandBuilder tags(String[] queryTags);

    public BaseCommand build();
}
