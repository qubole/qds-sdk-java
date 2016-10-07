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

import java.util.Arrays;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.DbSimpleImportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbSimpleImportCommandBuilderImpl extends CommandBuilderImplBase implements DbSimpleImportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbSimpleImportCommandBuilder hive_table(String hive_table)
    {
        node.put("hive_table", hive_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder hive_serde(String hive_serde)
    {
        node.put("hive_serde", hive_serde);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_columns(String[] db_columns)
    {
        String dbCols = Arrays.toString(db_columns);
        node.put("db_columns", dbCols.substring(1, dbCols.length()-1));
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_where(String db_where)
    {
        node.put("db_where", db_where);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder db_parallelism(String db_parallelism)
    {
        node.put("db_parallelism", db_parallelism);
        return this;
    }

    @Override
    public DbSimpleImportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.DB_IMPORT;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbSimpleImportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 1);
        node.put("command_type", "DbImportCommand");
    }
}
