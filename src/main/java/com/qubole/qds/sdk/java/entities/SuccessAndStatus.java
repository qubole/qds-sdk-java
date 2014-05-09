package com.qubole.qds.sdk.java.entities;

public class SuccessAndStatus
{
    private boolean succeeded;
    private String status;

    public SuccessAndStatus()
    {
    }

    public SuccessAndStatus(boolean succeeded, String status)
    {
        this.succeeded = succeeded;
        this.status = status;
    }

    public boolean isSucceeded()
    {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded)
    {
        this.succeeded = succeeded;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
