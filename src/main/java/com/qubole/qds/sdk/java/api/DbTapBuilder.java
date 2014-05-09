package com.qubole.qds.sdk.java.api;

public interface DbTapBuilder
{
    public DbTapBuilder db_name(String db_name);

    public DbTapBuilder db_host(String db_host);

    public DbTapBuilder db_user(String db_user);

    public DbTapBuilder db_passwd(String db_passwd);

    public DbTapBuilder db_port(int db_port);

    public DbTapBuilder db_type(String db_type);

    public DbTapBuilder db_location(String db_location);
}
