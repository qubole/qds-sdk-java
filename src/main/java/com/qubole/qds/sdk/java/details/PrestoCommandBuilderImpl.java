package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.api.PrestoCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import org.codehaus.jackson.node.ObjectNode;

class PrestoCommandBuilderImpl extends CommandBuilderImplBase implements PrestoCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public PrestoCommandBuilder script_location(String script_location)
    {
        node.put("script_location", script_location);
        return this;
    }

    @Override
    public PrestoCommandBuilder query(String query)
    {
        node.put("query", query);
        return this;
    }

    @Override
    public PrestoCommandBuilder clusterLabel(String clusterLabel)
    {
        node.put("label", clusterLabel);
        return this;
    }

    @Override
    public PrestoCommandBuilder name(String queryName) {
        node.put("name", queryName);
        return this;
    }

    @Override
    public PrestoCommandBuilder tags(String[] queryTags) {
        node.putPOJO("tags", queryTags);
        return this;
    }

    @Override
    protected ObjectNode getEntity()
    {
        return node;
    }

    PrestoCommandBuilderImpl(QdsClient client)
    {
        super(client);
        node.put("command_type", "PrestoCommand");
    }
}
