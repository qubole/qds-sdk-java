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
public class Account
{
    private String storage_access_key;
    private String storage_secret_key;
    private String session_token;
    
    public Account()
    {
    }

    public Account(String storage_access_key, String storage_secret_key, String session_token)
    {
        this.storage_access_key = storage_access_key;
        this.storage_secret_key = storage_secret_key;
        this.session_token = session_token;
    }

    public String getStorage_secret_key()
    {
        return storage_secret_key;
    }

    public void setStorage_secret_key(String storage_secret_key)
    {
        this.storage_secret_key = storage_secret_key;
    }

    public String getStorage_access_key()
    {
        return storage_access_key;
    }

    public void setStorage_access_key(String storage_access_key)
    {
        this.storage_access_key = storage_access_key;
    }

    public String getSession_token()
    {
        return session_token;
    }

    public void setSession_token(String session_token)
    {
        this.session_token = session_token;
    }
}
