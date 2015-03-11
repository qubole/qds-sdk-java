package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface CompositeCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public CompositeCommandBuilder name(String commandName);

    public CompositeCommandBuilder tags(String[] queryTags);

    public CompositeCommandBuilder clusterLabel(String clusterLabel);

    public CompositeCommandBuilder addWorkflowSubCommand(BaseCommand command);
}
