package com.qubole.qds.sdk.java.entities;

import java.util.Map;

public class PigCommand
{
    private String script_location;
    private Map<String, Object> parameters;
    private String latin_statements;
    private String command_type;

    public PigCommand()
    {
    }

    public PigCommand(String script_location, Map<String, Object> parameters, String latin_statements, String command_type)
    {
        this.script_location = script_location;
        this.parameters = parameters;
        this.latin_statements = latin_statements;
        this.command_type = command_type;
    }

    public String getScript_location()
    {
        return script_location;
    }

    public void setScript_location(String script_location)
    {
        this.script_location = script_location;
    }

    public Map<String, Object> getParameters()
    {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters)
    {
        this.parameters = parameters;
    }

    public String getLatin_statements()
    {
        return latin_statements;
    }

    public void setLatin_statements(String latin_statements)
    {
        this.latin_statements = latin_statements;
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
