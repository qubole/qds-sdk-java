package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface PrestoCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public PrestoCommandBuilder script_location(String script_location);

    public PrestoCommandBuilder query(String query);

    public PrestoCommandBuilder clusterLabel(String clusterLabel);

    public PrestoCommandBuilder name(String queryName);

    public PrestoCommandBuilder tags(String[] queryTags);
}
