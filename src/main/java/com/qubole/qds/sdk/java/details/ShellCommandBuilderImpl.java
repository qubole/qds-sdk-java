package com.qubole.qds.sdk.java.details;

import com.google.common.base.Joiner;
import com.qubole.qds.sdk.java.api.ShellCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

import java.util.List;

public class ShellCommandBuilderImpl extends CommandBuilderImplBase implements ShellCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public ShellCommandBuilder inline(String inline)
    {
        node.put("inline", inline);
        return this;
    }

    @Override
    public ShellCommandBuilder scriptLocation(String scriptLocation)
    {
        node.put("script_location", scriptLocation);
        return this;
    }

    @Override
    public ShellCommandBuilder files(List<String> fileList)
    {
        String files = Joiner.on(",").join(fileList);
        node.put("files", files);
        return this;
    }

    @Override
    public ShellCommandBuilder archives(List<String> archiveList)
    {
        String archives = Joiner.on(",").join(archiveList);
        node.put("archives", archives);
        return this;
    }

    @Override
    public ShellCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public ShellCommandBuilder name(String commandName) {
        node.put("name", commandName);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    ShellCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "ShellCommand");
    }
}

