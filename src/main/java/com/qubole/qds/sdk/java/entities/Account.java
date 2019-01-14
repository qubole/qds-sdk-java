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
public class Account
{
    private String authorized_ssh_key;
    private String storage_type;
    private String compute_type;
    private String storage_secret_key;
    private String compute_secret_key;
    private String storage_access_key;
    private String compute_access_key;
    private boolean storage_validated;
    private boolean compute_validated;
    private String name;
    private int id;
    private String storage_location;

    public Account()
    {
    }

    public Account(String authorized_ssh_key, String storage_type, String compute_type, String storage_secret_key, String compute_secret_key, String storage_access_key, String compute_access_key, boolean storage_validated, boolean compute_validated, String name, int id, String storage_location)
    {
        this.authorized_ssh_key = authorized_ssh_key;
        this.storage_type = storage_type;
        this.compute_type = compute_type;
        this.storage_secret_key = storage_secret_key;
        this.compute_secret_key = compute_secret_key;
        this.storage_access_key = storage_access_key;
        this.compute_access_key = compute_access_key;
        this.storage_validated = storage_validated;
        this.compute_validated = compute_validated;
        this.name = name;
        this.id = id;
        this.storage_location = storage_location;
    }

    public String getAuthorized_ssh_key()
    {
        return authorized_ssh_key;
    }

    public void setAuthorized_ssh_key(String authorized_ssh_key)
    {
        this.authorized_ssh_key = authorized_ssh_key;
    }

    public String getStorage_type()
    {
        return storage_type;
    }

    public void setStorage_type(String storage_type)
    {
        this.storage_type = storage_type;
    }

    public String getCompute_type()
    {
        return compute_type;
    }

    public void setCompute_type(String compute_type)
    {
        this.compute_type = compute_type;
    }

    public String getStorage_secret_key()
    {
        return storage_secret_key;
    }

    public void setStorage_secret_key(String storage_secret_key)
    {
        this.storage_secret_key = storage_secret_key;
    }

    public String getCompute_secret_key()
    {
        return compute_secret_key;
    }

    public void setCompute_secret_key(String compute_secret_key)
    {
        this.compute_secret_key = compute_secret_key;
    }

    public String getStorage_access_key()
    {
        return storage_access_key;
    }

    public void setStorage_access_key(String storage_access_key)
    {
        this.storage_access_key = storage_access_key;
    }

    public String getCompute_access_key()
    {
        return compute_access_key;
    }

    public void setCompute_access_key(String compute_access_key)
    {
        this.compute_access_key = compute_access_key;
    }

    public boolean isStorage_validated()
    {
        return storage_validated;
    }

    public void setStorage_validated(boolean storage_validated)
    {
        this.storage_validated = storage_validated;
    }

    public boolean isCompute_validated()
    {
        return compute_validated;
    }

    public void setCompute_validated(boolean compute_validated)
    {
        this.compute_validated = compute_validated;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStorage_location()
    {
        return storage_location;
    }

    public void setStorage_location(String storage_location)
    {
        this.storage_location = storage_location;
    }
}

