package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbTapApi;
import com.qubole.qds.sdk.java.api.DbTapBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbTap;
import com.qubole.qds.sdk.java.entities.DbTapList;
import com.qubole.qds.sdk.java.entities.Status;
import javax.ws.rs.core.GenericType;
import java.util.List;

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
    public InvokableBuilder<List<String>> listTables(int dbTapId)
    {
        GenericType<List<String>> responseType = new GenericType<List<String>>(){};
        return new GenericInvokableBuilderImpl<List<String>>(client, null, responseType, "db_taps", Integer.toString(dbTapId), "tables");
    }

    @Override
    public InvokableBuilder<Status> delete(int dbTapId)
    {
        ClientEntity entity = new ClientEntity(null, ClientEntity.Method.DELETE);
        return new GenericInvokableBuilderImpl<Status>(client, entity, Status.class, "db_taps", Integer.toString(dbTapId));
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
