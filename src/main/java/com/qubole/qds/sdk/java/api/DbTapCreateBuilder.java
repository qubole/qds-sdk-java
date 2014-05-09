package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.DbTapResponse;

public interface DbTapCreateBuilder extends InvokableBuilder<DbTapResponse>
{
    public DbTapCreateBuilder db_name(String db_name);

    public DbTapCreateBuilder db_host(String db_host);

    public DbTapCreateBuilder db_user(String db_user);

    public DbTapCreateBuilder db_passwd(String db_passwd);

    public DbTapCreateBuilder db_port(int db_port);

    public DbTapCreateBuilder db_type(String db_type);

    public DbTapCreateBuilder db_location(String db_location);
}
