package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbTapApi;
import com.qubole.qds.sdk.java.api.DbTapBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbTap;
import com.qubole.qds.sdk.java.entities.DbTapList;

class DbTapApiImpl implements DbTapApi
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<DbTap> create(DbTapBuilder dbTap)
    {
        ClientEntity entity = new ClientEntity(dbTap.toString(), ClientEntity.Method.POST);
        return new GenericInvokableBuilderImpl<DbTap>(client, entity, DbTap.class, "db_taps");
    }

    @Override
    public InvokableBuilder<DbTap> edit(int dbTapId, DbTapBuilder dbTap)
    {
        ClientEntity entity = new ClientEntity(dbTap.toString(), ClientEntity.Method.PUT);
        return new GenericInvokableBuilderImpl<DbTap>(client, entity, DbTap.class, "db_taps", Integer.toString(dbTapId));
    }

    @Override
    public PageableInvokableBuilder<DbTapList> list()
    {
        return new GenericPageableInvokableBuilderImpl<DbTapList>(client, null, DbTapList.class, "db_taps");
    }

    @Override
    public InvokableBuilder<DbTap> view(int dbTapId)
    {
        return new GenericInvokableBuilderImpl<DbTap>(client, null, DbTap.class, "db_taps", Integer.toString(dbTapId));
    }

    @Override
    public DbTapBuilder dbTap()
    {
        return new DbTapBuilderImpl();
    }

    DbTapApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
