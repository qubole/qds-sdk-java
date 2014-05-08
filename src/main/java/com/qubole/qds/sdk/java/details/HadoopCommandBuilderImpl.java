package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.HadoopCommand;
import java.util.concurrent.Future;

class HadoopCommandBuilderImpl implements HadoopCommandBuilder
{
    private final QdsClient client;
    private SubCommandType subCommandType = SubCommandType.JAR;
    private String sub_command_args = "";

    @Override
    public HadoopCommandBuilder sub_command(SubCommandType subCommandType)
    {
        this.subCommandType = subCommandType;
        return this;
    }

    @Override
    public HadoopCommandBuilder sub_command_args(String sub_command_args)
    {
        this.sub_command_args = sub_command_args;
        return this;
    }

    @Override
    public Future<CommandResponse> invoke()
    {
        HadoopCommand hadoopCommand = new HadoopCommand(subCommandType.name().toLowerCase(), sub_command_args, "HadoopCommand");
        ClientEntity entity = new ClientEntity(hadoopCommand, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, CommandResponse.class, "commands");
    }

    HadoopCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
