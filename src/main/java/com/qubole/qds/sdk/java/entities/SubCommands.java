package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

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

    public Command[] getsub_commands() { return this.sub_commands; }
    public void setsub_commands(Command[] commands) { this.sub_commands = commands; }

}
