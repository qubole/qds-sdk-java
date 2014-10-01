package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;
import java.util.Map;

class PigCommandBuilderImpl extends CommandBuilderImplBase implements PigCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public PigCommandBuilder script_location(String script_location)
    {
        node.put("script_location", script_location);
        return this;
    }

    @Override
    public PigCommandBuilder parameters(Map<String, Object> parameters)
    {
        node.putPOJO("parameters", parameters);
        return this;
    }

    @Override
    public PigCommandBuilder latin_statements(String latin_statements)
    {
        node.put("latin_statements", latin_statements);
        return this;
    }

    @Override
    public PigCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    PigCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "PigCommand");
    }
}
