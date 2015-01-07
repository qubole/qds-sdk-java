package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;
import java.util.Map;

public interface PigCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public PigCommandBuilder script_location(String script_location);

    public PigCommandBuilder parameters(Map<String, Object> parameters);

    public PigCommandBuilder latin_statements(String latin_statements);

    public PigCommandBuilder clusterLabel(String clusterLabel);

    public PigCommandBuilder name(String commmandName);

    public PigCommandBuilder tags(String[] queryTags);
}
