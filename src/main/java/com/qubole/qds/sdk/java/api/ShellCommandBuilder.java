package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

import java.util.List;

public interface ShellCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public ShellCommandBuilder inline(String inline);

    public ShellCommandBuilder scriptLocation(String scriptLocation);

    public ShellCommandBuilder files(List<String> fileList);

    public ShellCommandBuilder archives(List<String> archiveList);

    public ShellCommandBuilder clusterLabel(String clusterLabel);

    public ShellCommandBuilder name(String commandName);

    public ShellCommandBuilder tags(String[] tags);
}