package com.qubole.qds.sdk.java.entities;

public class SecuritySettings
{
    private boolean encrypted_ephemerals;

    public SecuritySettings()
    {
    }

    public SecuritySettings(boolean encrypted_ephemerals)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
    }

    public boolean isEncrypted_ephemerals()
    {
        return encrypted_ephemerals;
    }

    public void setEncrypted_ephemerals(boolean encrypted_ephemerals)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
    }
}
