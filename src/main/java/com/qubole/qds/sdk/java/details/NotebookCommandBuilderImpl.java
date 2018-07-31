package com.qubole.qds.sdk.java.details;

import java.util.Map;

import org.codehaus.jackson.node.ObjectNode;

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.BaseCommand.COMMAND_TYPE;
import com.qubole.qds.sdk.java.api.NotebookCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

public class NotebookCommandBuilderImpl extends CommandBuilderImplBase implements NotebookCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    NotebookCommandBuilderImpl(QdsClient client)
    {
        super(client);
    }

    @Override
    public NotebookCommandBuilder command_type(String commandType)
    {
        node.put("command_type", commandType);
        return this;
    }

    @Override
    public NotebookCommandBuilder notebook_id(String notebookId)
    {
        node.put("note_id", notebookId);
        return this;
    }

    @Override
    public NotebookCommandBuilder language(String language)
    {
        node.put("language", language);
        return this;
    }

    @Override
    public NotebookCommandBuilder label(String label)
    {
        node.put("label", label);
        return this;
    }

    @Override
    public NotebookCommandBuilder name(String name)
    {
        node.put("name", name);
        return this;
    }

    @Override
    public NotebookCommandBuilder tags(String[] tags)
    {
        node.putPOJO("tags", tags);
        return this;
    }

    @Override
    public NotebookCommandBuilder arguments(Map<String, String> arguments)
    {
        node.putPOJO("arguments", arguments);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    @Override
    protected COMMAND_TYPE getCommandType()
    {
        return BaseCommand.COMMAND_TYPE.NOTEBOOK;
    }

}
