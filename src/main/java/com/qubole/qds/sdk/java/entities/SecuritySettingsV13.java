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
public class SecuritySettingsV13
{
    private boolean encrypted_ephemerals;
    private String ssh_public_key;
    private String persistent_security_group;

    public SecuritySettingsV13()
    {
    }

    public SecuritySettingsV13(boolean encrypted_ephemerals, String ssh_public_key, String persistent_security_group)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
        this.ssh_public_key = ssh_public_key;
        this.persistent_security_group = persistent_security_group;
    }

    public boolean isEncrypted_ephemerals()
    {
        return encrypted_ephemerals;
    }

    public void setEncrypted_ephemerals(boolean encrypted_ephemerals)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
    }

    public String getSsh_public_key()
    {
        return ssh_public_key;
    }

    public void setSsh_public_key(String ssh_public_key)
    {
        this.ssh_public_key = ssh_public_key;
    }
    
    public String getPersistent_security_group()
    {
        return persistent_security_group;
    }

    public void setPersistent_security_group(String persistent_security_group)
    {
        this.persistent_security_group = persistent_security_group;
    }
}
