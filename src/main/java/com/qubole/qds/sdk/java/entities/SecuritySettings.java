package com.qubole.qds.sdk.java.entities;

public class SecuritySettings
{
    private boolean encrypted_ephemerals;
    private String customer_ssh_key;

    public SecuritySettings()
    {
    }

    public SecuritySettings(boolean encrypted_ephemerals, String customer_ssh_key)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
        this.customer_ssh_key = customer_ssh_key;
    }

    public boolean isEncrypted_ephemerals()
    {
        return encrypted_ephemerals;
    }

    public void setEncrypted_ephemerals(boolean encrypted_ephemerals)
    {
        this.encrypted_ephemerals = encrypted_ephemerals;
    }

    public String getCustomer_ssh_key()
    {
        return customer_ssh_key;
    }

    public void setCustomer_ssh_key(String customer_ssh_key)
    {
        this.customer_ssh_key = customer_ssh_key;
    }
}
