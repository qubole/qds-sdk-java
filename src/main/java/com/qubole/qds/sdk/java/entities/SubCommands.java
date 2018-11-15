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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;

@JsonDeserialize(using = SubCommandsDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
/*
* This class would behave like map for normal commands and can keep an array of sub commands for
* composite command scenario. This would be eventually used both in command response, status calls
*/
public class SubCommands extends HashMap<String, String>
{
    private Command[] sub_commands;
    public SubCommands()
    {

    }

    public SubCommands(Command[] commands)
    {
        this.sub_commands = commands;
    }

    public Command[] getsub_commands()
    {
        return this.sub_commands;
    }
    public void setsub_commands(Command[] commands)
    {
        this.sub_commands = commands;
    }

}
