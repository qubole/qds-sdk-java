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
public class NodeOperation
{
    private String private_dns;
    private String command;

    public NodeOperation()
    {
    }

    public NodeOperation(String private_dns)
    {
        this.private_dns = private_dns;
    }

    public NodeOperation(String private_dns, String command)
    {
        this.private_dns = private_dns;
        this.command = command;
    }

    public String getPrivate_dns()
    {
        return private_dns;
    }

    public void setPrivate_dns(String private_dns)
    {
        this.private_dns = private_dns;
    }

    public String getCommand()
    {
        return command;
    }

    public void setCommand(String command)
    {
        this.command = command;
    }
}
