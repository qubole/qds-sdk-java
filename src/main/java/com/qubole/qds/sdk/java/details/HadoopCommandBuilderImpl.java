package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.HadoopCommand;
import java.util.concurrent.Future;

class HadoopCommandBuilderImpl implements HadoopCommandBuilder
{
    private final QdsClient client;
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
    public Future<CommandResponse> invoke()
    {
        ClientEntity entity = new ClientEntity(hadoopCommand, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, CommandResponse.class, "commands");
    }

    HadoopCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
