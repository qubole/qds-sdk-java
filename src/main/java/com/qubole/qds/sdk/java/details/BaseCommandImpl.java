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

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class BaseCommandImpl implements BaseCommand
{
    private ObjectNode node = null;
    private COMMAND_TYPE cmdType = COMMAND_TYPE.NONE;
    public BaseCommandImpl(COMMAND_TYPE cmdType, ObjectNode node)
    {
        this.cmdType = cmdType;
        this.node = node;
    }

    public ObjectNode getNode()
    {
        return this.node;
    }

    @Override
    public BaseCommand.COMMAND_TYPE getCommandType()
    {
        return this.cmdType;
    }

    @Override
    public String getJSONString()
    {
        String json;
        try
        {
            json = QdsClientImpl.getMapper().writeValueAsString(node);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not serialize " + node, e);
        }
        return json;
    }
}
