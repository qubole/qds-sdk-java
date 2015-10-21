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

import com.qubole.qds.sdk.java.entities.DbTap;
import com.qubole.qds.sdk.java.entities.DbTapList;
import com.qubole.qds.sdk.java.entities.Schema;
import com.qubole.qds.sdk.java.entities.Status;
import java.util.List;
import java.util.Map;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/dbtaps-api-qds-api-reference/
 */
public interface DbTapApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/create-a-dbtap/
     *
     * @param dbTap the data
     * @return new builder
     */
    public InvokableBuilder<DbTap> create(DbTapBuilder dbTap);

    /**
     * Corresponds to http://www.qubole.com/docs/edit-a-dbtap/
     *
     * @param dbTapId id to edit
     * @param dbTap the data
     * @return new builder
     */
    public InvokableBuilder<DbTap> edit(int dbTapId, DbTapBuilder dbTap);

    /**
     * Corresponds to http://www.qubole.com/docs/list-dbtaps/
     *
     * @return new builder
     */
    public PageableInvokableBuilder<DbTapList> list();

    /**
     * Corresponds to http://www.qubole.com/docs/view-a-dbtap/
     *
     * @param dbTapId id to view
     * @return new builder
     */
    public InvokableBuilder<DbTap> view(int dbTapId);

    /**
     * Corresponds to http://www.qubole.com/docs/list-tables-in-a-dbtap/
     *
     * @param dbTapId id to list
     * @return new builder
     */
    public InvokableBuilder<List<String>> listTables(int dbTapId);

    /**
     * Corresponds to http://www.qubole.com/docs/delete-a-dbtap/
     *
     * @param dbTapId id to delete
     * @return new builder
     */
    public InvokableBuilder<Status> delete(int dbTapId);

    /**
     * Return a new db tap builder. Can be used with
     * apis such as {@link #create(DbTapBuilder)}
     *
     * @return builder
     */
    public DbTapBuilder dbTap();

    public InvokableBuilder<Map<String, Map<String, Object>>> getSchemas(int dbTapId, boolean described);
}
