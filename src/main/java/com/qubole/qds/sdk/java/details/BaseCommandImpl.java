package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;

public class BaseCommandImpl implements BaseCommand
{
    private ObjectNode node = null;
    private COMMAND_TYPE cmdType = COMMAND_TYPE.NONE;
    public BaseCommandImpl(COMMAND_TYPE cmdType, ObjectNode node)
    {
        this.cmdType = cmdType;
        this.node = node;
    }

    public ObjectNode getNode() { return this.node; }

    public BaseCommand.COMMAND_TYPE getCommandType()
    {
        return this.cmdType;
    }

    public String getJSONString()
    {
        String json;
        try
        {
            json = QdsClientImpl.getMapper().writeValueAsString(node);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize " + node, e);
        }
        return json;
    }
}
