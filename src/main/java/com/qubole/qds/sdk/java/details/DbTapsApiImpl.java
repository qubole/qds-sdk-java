package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbTapCreateBuilder;
import com.qubole.qds.sdk.java.api.DbTapsApi;
import com.qubole.qds.sdk.java.client.QdsClient;

class DbTapsApiImpl implements DbTapsApi
{
    private final QdsClient client;

    @Override
    public DbTapCreateBuilder create()
    {
        return new DbTapCreateBuilderImpl(client);
    }

    DbTapsApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
