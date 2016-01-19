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

import java.io.IOException;
import org.codehaus.jackson.node.ObjectNode;
import com.qubole.qds.sdk.java.api.AccountConfigBuilder;

public class AccountConfigBuilderImpl implements AccountConfigBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public AccountConfigBuilder name(String name) 
    {
        node.put("name", name);
        return this;
    }

    @Override
    public AccountConfigBuilder acc_key(String acc_key) 
    {
        node.put("acc_key", acc_key);
        return this;
    }

    @Override
    public AccountConfigBuilder secret(String secret) 
    {
        node.put("secret", secret);
        return this;
    }

    @Override
    public AccountConfigBuilder level(String level) 
    {
        node.put("level", level);
        return this;
    }

    @Override
    public AccountConfigBuilder compute_type(String compute_type) 
    {
        node.put("compute_type", compute_type);
        return this;
    }

    @Override
    public AccountConfigBuilder storage_type(String storage_type) 
    {
        node.put("storage_type", storage_type);
        return this;
    }

    @Override
    public AccountConfigBuilder aws_region(String aws_region) 
    {
        node.put("aws_region", aws_region);
        return this;
    }

    @Override
    public AccountConfigBuilder CacheQuotaSizeInGB(String CacheQuotaSizeInGB) 
    {
        node.put("CacheQuotaSizeInGB", CacheQuotaSizeInGB);
        return this;
    }

    @Override
    public AccountConfigBuilder use_previous_account_plan(boolean use_previous_account_plan) 
    {
        node.put("use_previous_account_plan", use_previous_account_plan);
        return this;
    }

    @Override
    public AccountConfigBuilder compute_access_key(String compute_access_key) 
    {
        node.put("compute_access_key", compute_access_key);
        return this;
    }

    @Override
    public AccountConfigBuilder compute_secret_key(String compute_secret_key) 
    {
        node.put("compute_secret_key", compute_secret_key);
        return this;
    }

    @Override
    public AccountConfigBuilder defloc(String defloc) 
    {
        node.put("defloc", defloc);
        return this;
    }
    
    public ObjectNode getNode()
    {
        ObjectNode clusterNode = QdsClientImpl.getMapper().createObjectNode();
        clusterNode.put("account", node);
        return clusterNode;
    }

    @Override
    public String toString()
    {
        try
        {
            return QdsClientImpl.getMapper().writer().writeValueAsString(getNode());
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }
}

