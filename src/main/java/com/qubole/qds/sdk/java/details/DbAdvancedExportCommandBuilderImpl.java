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

import com.qubole.qds.sdk.java.api.DbAdvancedExportCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class DbAdvancedExportCommandBuilderImpl extends CommandBuilderImplBase implements DbAdvancedExportCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbAdvancedExportCommandBuilder db_table(String db_table)
    {
        node.put("db_table", db_table);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder dbtap_id(String dbtap_id)
    {
        node.put("dbtap_id", dbtap_id);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder export_dir(String export_dir)
    {
        node.put("export_dir", export_dir);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_mode(String db_update_mode)
    {
        node.put("db_update_mode", db_update_mode);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder db_update_keys(String db_update_keys)
    {
        node.put("db_update_keys", db_update_keys);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder fields_terminated_by(String fields_terminated_by)
    {
        node.put("fields_terminated_by", fields_terminated_by);
        return this;
    }

    @Override
    public DbAdvancedExportCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    DbAdvancedExportCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("mode", 2);
        node.put("command_type", "DbExportCommand");
    }
}
