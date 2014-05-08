package com.qubole.qds.sdk.java.entities;

public class PrestoCommand
{
    private String query;
    private String script_location;
    private String command_type;

    public PrestoCommand()
    {
    }

    public PrestoCommand(String query, String script_location, String command_type)
    {
        this.query = query;
        this.script_location = script_location;
        this.command_type = command_type;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public String getScript_location()
    {
        return script_location;
    }

    public void setScript_location(String script_location)
    {
        this.script_location = script_location;
    }

    public String getCommand_type()
    {
        return command_type;
    }

    public void setCommand_type(String command_type)
    {
        this.command_type = command_type;
    }
}
