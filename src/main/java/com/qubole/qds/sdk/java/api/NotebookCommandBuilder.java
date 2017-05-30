package com.qubole.qds.sdk.java.api;

import java.util.Map;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface NotebookCommandBuilder extends InvokableBuilder<CommandResponse>
{
    /**
    * Set to SparkCommand
    */
    public NotebookCommandBuilder command_type(String command_type);

    /**
    * notebook_id id of notebook
    */
    public NotebookCommandBuilder notebook_id(String notebook_id);

    /**
    * language language is always notebook
    */
    public NotebookCommandBuilder language(String language);

    /**
    * label label of the cluster which is associated with notebook
    */
     public NotebookCommandBuilder label(String label);

    /**
    * name Add a name to the command that is useful while filtering commands from the command history
    */
    public NotebookCommandBuilder name(String name);

    /**
    * tags tags to command, so it is easily identifiable
    */
    public NotebookCommandBuilder tags(String[] tags);

    /**
     * arguments arguments passed to command
     */
     public NotebookCommandBuilder arguments(Map<String, String> arguments);

}
