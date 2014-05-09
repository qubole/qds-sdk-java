package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.DbTap;
import com.qubole.qds.sdk.java.entities.DbTapList;
import java.util.List;

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
     * Return a new db tap builder. Can be used with
     * apis such as {@link #create(DbTapBuilder)}
     *
     * @return builder
     */
    public DbTapBuilder dbTap();
}
