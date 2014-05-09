package com.qubole.qds.sdk.java.entities;

public class DbTap
{
    private String db_name;
    private String db_host;
    private String db_user;
    private String db_passwd;
    private Integer db_port;
    private String db_type;
    private String db_location;

    public DbTap()
    {
    }

    public DbTap(String db_name, String db_host, String db_user, String db_passwd, Integer db_port, String db_type, String db_location)
    {
        this.db_name = db_name;
        this.db_host = db_host;
        this.db_user = db_user;
        this.db_passwd = db_passwd;
        this.db_port = db_port;
        this.db_type = db_type;
        this.db_location = db_location;
    }

    public String getDb_name()
    {
        return db_name;
    }

    public void setDb_name(String db_name)
    {
        this.db_name = db_name;
    }

    public String getDb_host()
    {
        return db_host;
    }

    public void setDb_host(String db_host)
    {
        this.db_host = db_host;
    }

    public String getDb_user()
    {
        return db_user;
    }

    public void setDb_user(String db_user)
    {
        this.db_user = db_user;
    }

    public String getDb_passwd()
    {
        return db_passwd;
    }

    public void setDb_passwd(String db_passwd)
    {
        this.db_passwd = db_passwd;
    }

    public int getDb_port()
    {
        return (db_port != null) ? db_port : 0;
    }

    public void setDb_port(int db_port)
    {
        this.db_port = db_port;
    }

    public String getDb_type()
    {
        return db_type;
    }

    public void setDb_type(String db_type)
    {
        this.db_type = db_type;
    }

    public String getDb_location()
    {
        return db_location;
    }

    public void setDb_location(String db_location)
    {
        this.db_location = db_location;
    }
}
