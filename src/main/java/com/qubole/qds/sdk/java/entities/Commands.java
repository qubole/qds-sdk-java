package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commands
{
    private List<Command> commands;
    private PagingInfo paging_info;

    public Commands()
    {
    }

    public Commands(List<Command> commands, PagingInfo paging_info)
    {
        this.commands = commands;
        this.paging_info = paging_info;
    }

    public List<Command> getCommands()
    {
        return commands;
    }

    public void setCommands(List<Command> commands)
    {
        this.commands = commands;
    }

    public PagingInfo getPaging_info()
    {
        return paging_info;
    }

    public void setPaging_info(PagingInfo paging_info)
    {
        this.paging_info = paging_info;
    }
}
