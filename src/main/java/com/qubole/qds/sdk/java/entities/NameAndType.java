package com.qubole.qds.sdk.java.entities;

public class NameAndType
{
    private String name;
    private String type;

    public NameAndType()
    {
    }

    public NameAndType(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
