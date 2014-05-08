package com.qubole.qds.sdk.java.entities;

public class HadoopCommand
{
    private String sub_command;
    private String sub_command_args;
    private String command_type;

    public HadoopCommand()
    {
    }

    public HadoopCommand(String sub_command, String sub_command_args, String command_type)
    {
        this.sub_command = sub_command;
        this.sub_command_args = sub_command_args;
        this.command_type = command_type;
    }

    public String getSub_command()
    {
        return sub_command;
    }

    public void setSub_command(String sub_command)
    {
        this.sub_command = sub_command;
    }

    public String getSub_command_args()
    {
        return sub_command_args;
    }

    public void setSub_command_args(String sub_command_args)
    {
        this.sub_command_args = sub_command_args;
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
