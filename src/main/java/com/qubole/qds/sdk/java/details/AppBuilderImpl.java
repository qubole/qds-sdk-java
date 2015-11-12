package com.qubole.qds.sdk.java.details;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.node.ObjectNode;

import com.qubole.qds.sdk.java.api.AppBuilder;

public class AppBuilderImpl implements AppBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    
    @Override
    public String toString()
    {
        try
        {
            return QdsClientImpl.getMapper().writer().writeValueAsString(node);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }
    
    @Override
    public AppBuilder name(String name) 
    {
        node.put("name", name);
        return this;
    }

    @Override
    public AppBuilder config(Map<String, String> config) 
    {
        node.put("config", QdsClientImpl.getMapper().valueToTree(config));
        return this;
    }

    @Override
    public AppBuilder kind(String kind) 
    {
        node.put("kind", kind);
        return this;
    }
}
