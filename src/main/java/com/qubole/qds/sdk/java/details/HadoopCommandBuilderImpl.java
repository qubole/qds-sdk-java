package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class HadoopCommandBuilderImpl extends CommandBuilderImplBase implements HadoopCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public HadoopCommandBuilder sub_command(SubCommandType subCommandType)
    {
        node.put("sub_command", subCommandType.name().toLowerCase());
        return this;
    }

    @Override
    public HadoopCommandBuilder sub_command_args(String sub_command_args)
    {
        node.put("sub_command_args", sub_command_args);
        return this;
    }

    @Override
    public HadoopCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    HadoopCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "HadoopCommand");
    }
}
