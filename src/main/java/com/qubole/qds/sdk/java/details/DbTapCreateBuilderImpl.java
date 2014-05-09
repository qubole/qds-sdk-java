package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbTapCreateBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DbTap;
import com.qubole.qds.sdk.java.entities.DbTapResponse;
import java.util.concurrent.Future;

class DbTapCreateBuilderImpl implements DbTapCreateBuilder
{
    private final QdsClient client;
    private final DbTap dbTap = new DbTap();

    @Override
    public DbTapCreateBuilder db_name(String db_name)
    {
        dbTap.setDb_name(db_name);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_host(String db_host)
    {
        dbTap.setDb_host(db_host);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_user(String db_user)
    {
        dbTap.setDb_user(db_user);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_passwd(String db_passwd)
    {
        dbTap.setDb_passwd(db_passwd);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_port(int db_port)
    {
        dbTap.setDb_port(db_port);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_type(String db_type)
    {
        dbTap.setDb_type(db_type);
        return this;
    }

    @Override
    public DbTapCreateBuilder db_location(String db_location)
    {
        dbTap.setDb_location(db_location);
        return this;
    }

    @Override
    public Future<DbTapResponse> invoke()
    {
        ClientEntity entity = new ClientEntity(dbTap, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, DbTapResponse.class, "db_taps");
    }

    DbTapCreateBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
