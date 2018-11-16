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
package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.DbTapBuilder;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

class DbTapBuilderImpl implements DbTapBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public DbTapBuilder db_name(String db_name)
    {
        node.put("db_name", db_name);
        return this;
    }

    @Override
    public DbTapBuilder db_host(String db_host)
    {
        node.put("db_host", db_host);
        return this;
    }

    @Override
    public DbTapBuilder db_user(String db_user)
    {
        node.put("db_user", db_user);
        return this;
    }

    @Override
    public DbTapBuilder db_passwd(String db_passwd)
    {
        node.put("db_passwd", db_passwd);
        return this;
    }

    @Override
    public DbTapBuilder db_port(int db_port)
    {
        node.put("db_port", db_port);
        return this;
    }

    @Override
    public DbTapBuilder db_type(String db_type)
    {
        node.put("db_type", db_type);
        return this;
    }

    @Override
    public DbTapBuilder db_location(String db_location)
    {
        node.put("db_location", db_location);
        return this;
    }

    @Override
    public String toString()
    {
        try
        {
            return QdsClientImpl.getMapper().writer().writeValueAsString(node);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }
}
