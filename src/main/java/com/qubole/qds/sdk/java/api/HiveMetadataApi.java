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

import com.qubole.qds.sdk.java.entities.NameAndType;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.TableProperties;
import java.util.List;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/hive-metadata-api/
 */
public interface HiveMetadataApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/table/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<List<NameAndType>> table(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/store-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public StoreTablePropertiesBuilder storeTableProperties(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/get-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<TableProperties> getTableProperties(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/delete-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<Status> deleteTableProperties(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/schema-or-database/
     *
     * @return builder
     */
    public SchemaCommandBuilder schema();
}
