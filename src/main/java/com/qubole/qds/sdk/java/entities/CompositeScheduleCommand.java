package com.qubole.qds.sdk.java.entities;

import java.util.List;

public class CompositeScheduleCommand {

    private List<ScheduleCommand> sub_commands;

    private CompositeScheduleCommand(List<ScheduleCommand> sub_commands){
        this.sub_commands = sub_commands;
    }

    public static CompositeScheduleCommand getCompositeScheduleCommand(List<ScheduleCommand> sub_commands)
    {
        return new CompositeScheduleCommand(sub_commands);
    }

    public List<ScheduleCommand> getSub_commands() {
        return sub_commands;
    }

    public void setSub_commands(List<ScheduleCommand> subcommands) {
        this.sub_commands = subcommands;
    }
}
