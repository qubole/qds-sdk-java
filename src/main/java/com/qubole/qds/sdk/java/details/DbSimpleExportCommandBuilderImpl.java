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

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.DbSimpleExportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.fasterxml.jackson.databind.node.ObjectNode;

class DbSimpleExportCommandBuilderImpl extends CommandBuilderImplBase implements DbSimpleExportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbSimpleExportCommandBuilder hive_table(String hive_table)
    {
        node.put("hive_table", hive_table);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder partition_spec(String partition_spec)
    {
        node.put("partition_spec", partition_spec);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_mode(String db_update_mode)
    {
        node.put("db_update_mode", db_update_mode);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder db_update_keys(String db_update_keys)
    {
        node.put("db_update_keys", db_update_keys);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder use_customer_cluster(boolean use_customer_cluster)
    {
        node.put("use_customer_cluster", use_customer_cluster);
        return this;
    }

    @Override
    public DbSimpleExportCommandBuilder customer_cluster_label(String customer_cluster_label)
    {
        node.put("customer_cluster_label", customer_cluster_label);
        return this;
    }

    @Override
    protected BaseCommand.COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.DB_EXPORT;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbSimpleExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 1);
        node.put("command_type", "DbExportCommand");
    }
}
