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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is custom serializer for sub commands, as in same tag we can get
 * an array or a hash, we needed a custom serializer to handle this scenario
 */
public class SubCommandsDeserializer extends JsonDeserializer<SubCommands>
{
    public SubCommandsDeserializer()
    {
    }

    @Override
    public SubCommands deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException
    {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = jp.getCodec().readTree(jp);

        SubCommands compositeCommand = new SubCommands();

        // we got the json node for the command tag
        // it can either be a set of name value pairs
        // i.e. Map<String, String> as it is today
        // or it can have an array with tag sub_commands
        // which will have Command objects for all the sub commands
        Iterator<Map.Entry<String, JsonNode>> elementsIterator =
                node.fields();
        while (elementsIterator.hasNext())
        {
            Map.Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            JsonNode val = element.getValue();
           // System.out.println("Name = " + name + ";Value = " + val);
            if (name.equalsIgnoreCase("sub_commands")) {
                Command[] subCommands = mapper.treeToValue(val, Command[].class);
                if (subCommands != null) {
                    compositeCommand.setsub_commands(subCommands);
                }
            }
            else {
                // put it in hash map as earlier
                compositeCommand.put(name, val.textValue());
            }
        }
        return compositeCommand;
    }
}
