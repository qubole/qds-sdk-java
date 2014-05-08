package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.HadoopCommand;

class HadoopCommandBuilderImpl extends CommandBuilderImplBase implements HadoopCommandBuilder
{
    private final HadoopCommand hadoopCommand = new HadoopCommand(SubCommandType.JAR.name().toLowerCase(), "", "HadoopCommand");

    @Override
    public HadoopCommandBuilder sub_command(SubCommandType subCommandType)
    {
        hadoopCommand.setSub_command(subCommandType.name().toLowerCase());
        return this;
    }

    @Override
    public HadoopCommandBuilder sub_command_args(String sub_command_args)
    {
        hadoopCommand.setSub_command_args(sub_command_args);
        return this;
    }

    @Override
    protected Object getEntity()
    {
        return hadoopCommand;
    }

    HadoopCommandBuilderImpl(QdsClient client)
    {
        super(client);
    }
}
