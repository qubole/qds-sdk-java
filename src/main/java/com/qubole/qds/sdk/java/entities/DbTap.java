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
package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DbTap
{
    private int account_id;
    private boolean active;
    private String db_user;
    private int user_id;
    private String db_passwd;
    private String db_name;
    private String created_at;
    private String db_host;
    private String db_location;
    private String db_type;
    private int id;
    private int port;

    public DbTap()
    {
    }

    public DbTap(int account_id, boolean active, String db_user, int user_id, String db_passwd, String db_name, String created_at, String db_host, String db_location, String db_type, int id, int port)
    {
        this.account_id = account_id;
        this.active = active;
        this.db_user = db_user;
        this.user_id = user_id;
        this.db_passwd = db_passwd;
        this.db_name = db_name;
        this.created_at = created_at;
        this.db_host = db_host;
        this.db_location = db_location;
        this.db_type = db_type;
        this.id = id;
        this.port = port;
    }

    public int getAccount_id()
    {
        return account_id;
    }

    public void setAccount_id(int account_id)
    {
        this.account_id = account_id;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getDb_user()
    {
        return db_user;
    }

    public void setDb_user(String db_user)
    {
        this.db_user = db_user;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getDb_passwd()
    {
        return db_passwd;
    }

    public void setDb_passwd(String db_passwd)
    {
        this.db_passwd = db_passwd;
    }

    public String getDb_name()
    {
        return db_name;
    }

    public void setDb_name(String db_name)
    {
        this.db_name = db_name;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public String getDb_host()
    {
        return db_host;
    }

    public void setDb_host(String db_host)
    {
        this.db_host = db_host;
    }

    public String getDb_location()
    {
        return db_location;
    }

    public void setDb_location(String db_location)
    {
        this.db_location = db_location;
    }

    public String getDb_type()
    {
        return db_type;
    }

    public void setDb_type(String db_type)
    {
        this.db_type = db_type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }
}
