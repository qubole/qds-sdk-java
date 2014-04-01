package com.qubole.qds.sdk.java.entities;

public class DataNode
{
    private int running;
    private int pending;

    public DataNode()
    {
    }

    public DataNode(int running, int pending)
    {
        this.running = running;
        this.pending = pending;
    }

    public int getRunning()
    {
        return running;
    }

    public void setRunning(int running)
    {
        this.running = running;
    }

    public int getPending()
    {
        return pending;
    }

    public void setPending(int pending)
    {
        this.pending = pending;
    }
}
