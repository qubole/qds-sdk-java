package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CompositeCommandBuilder;
import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import org.codehaus.jackson.node.ObjectNode;

import java.util.ArrayList;

public class CompositeCommandBuilderImpl extends CommandBuilderImplBase implements CompositeCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    ArrayList<ObjectNode> subCommands = new ArrayList<ObjectNode>();

    @Override
    public CompositeCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public CompositeCommandBuilder name(String queryName) {
        node.put("name", queryName);
        return this;
    }

    @Override
    public CompositeCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    public CompositeCommandBuilder addWorkflowSubCommand(BaseCommand command)
    {
        // for now we will work with our impl classes only
        if (((command instanceof BaseCommandImpl) == false)
                || (checkCommandTypeSupported(command) == false))
        {
            throw new RuntimeException("Command Type not supported: " + command.getCommandType());
        }

        BaseCommandImpl baseCommandImpl = (BaseCommandImpl) command;
        ObjectNode cmdNode = baseCommandImpl.getNode();
        if (cmdNode == null)
        {
            throw new RuntimeException("Incomplete Command");
        }

        // remove not supported attributes
        // in workflow case, workflow level overrides will work
        cmdNode.remove("tags");
        cmdNode.remove("name");
        cmdNode.remove("label");

        subCommands.add(cmdNode);
        node.putPOJO("sub_commands", subCommands.toArray());
        return this;
    }

    // add a check if a command type is supported in
    // workflow or not
    private boolean checkCommandTypeSupported(BaseCommand command)
    {
        return true;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    CompositeCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "CompositeCommand");
    }

}
