package com.qubole.qds.sdk.java.client;

import javax.ws.rs.client.Client;

/**
 * Initialization values, etc.
 */
public interface QdsConfiguration
{
    /**
     * Return a new Jersey client
     *
     * @return client
     */
    public Client newClient();

    /**
     * Return the API token
     *
     * @return API token
     */
    public String getApiToken();

    /**
     * Return the main endpoint, e.g. "https://api.qubole.com/api"
     *
     * @return endpoint
     */
    public String getApiEndpoint();

    /**
     * Return the API version, e.g. "v1.2"
     *
     * @return version
     */
    public String getApiVersion();
}
