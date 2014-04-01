package com.qubole.qds.sdk.java.client;

import javax.ws.rs.client.Client;

public interface QdsConfiguration
{
    public Client newClient();

    public String getApiToken();

    public String getApiEndpoint();

    public String getApiVersion();
}
