package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface HadoopCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public enum SubCommandType
    {
        JAR,
        S3DISTCP,
        STREAMING
    }
    public HadoopCommandBuilder sub_command(SubCommandType subCommandType);

    public HadoopCommandBuilder sub_command_args(String sub_command_args);

    public HadoopCommandBuilder clusterLabel(String clusterLabel);

    public HadoopCommandBuilder name(String commandName);
}
