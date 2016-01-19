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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewAccount 
{
    private long account_id;
    private String authentication_token;
    private long capabilities;
    private String created_at;
    private boolean disabled;
    private long id;
    private boolean is_admin;
    private boolean is_default;
    private String setting_id;
    private String setting_type;
    private String updated_at;
    private long user_id;
    
    NewAccount()
    {
    }
    
    NewAccount(long account_id, String authentication_token, long capabilities, String created_at, boolean disabled, long id, boolean is_admin, boolean is_default, String setting_id, String setting_type, String updated_at, long user_id)
    {
        this.account_id = account_id;
        this.authentication_token = authentication_token;
        this.capabilities = capabilities;
        this.created_at = created_at;
        this.disabled = disabled;
        this.id = id;
        this.is_admin = is_admin;
        this.is_default = is_default;
        this.setting_id = setting_id;
        this.setting_type = setting_type;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }
    
    public long getAccount_id()
    {
        return account_id;
    }

    public void setAccount_id(long account_id)
    {
        this.account_id = account_id;
    }
    
    public String getAuthentication_token()
    {
        return authentication_token;
    }

    public void setAuthentication_token(String authentication_token)
    {
        this.authentication_token = authentication_token;
    }
    
    public long getCapabilities()
    {
        return capabilities;
    }

    public void setCapabilities(long capabilities)
    {
        this.capabilities = capabilities;
    }
    
    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }
    
    public boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public boolean getIs_admin()
    {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin)
    {
        this.is_admin = is_admin;
    }
    
    public boolean getIs_default()
    {
        return is_default;
    }

    public void setIs_default(boolean is_default)
    {
        this.is_default = is_default;
    }
    
    public String getSetting_id()
    {
        return setting_id;
    }

    public void setSetting_id(String setting_id)
    {
        this.setting_id = setting_id;
    }
    
    public String getSetting_type()
    {
        return setting_type;
    }

    public void setSetting_type(String setting_type)
    {
        this.setting_type = setting_type;
    }
    
    public String getUpdated_at()
    {
        return updated_at;
    }

    public void setUpdated_at(String updated_at)
    {
        this.updated_at = updated_at;
    }
    
    public long getUser_id()
    {
        return user_id;
    }

    public void setUser_id(long user_id)
    {
        this.user_id = user_id;
    }
}

