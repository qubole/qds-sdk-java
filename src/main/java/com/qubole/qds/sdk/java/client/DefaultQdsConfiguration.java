package com.qubole.qds.sdk.java.client;

import com.google.common.base.Preconditions;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.concurrent.TimeUnit;

/**
 * Standard/default implementation of {@link QdsConfiguration}
 */
public class DefaultQdsConfiguration implements QdsConfiguration
{
    private final Type type;
    private final String apiToken;
    private final ClientConfig jerseyConfiguration;

    private static final String API_ENDPOINT = "https://api.qubole.com/api/";
    private static final String STAGING_API_ENDPOINT = "https://colonelhathi.qubole.com/api/";
    private static final String API_VERSION = "v1.2";

    private static final int DEFAULT_CONNECTION_TIMEOUT = (int)TimeUnit.SECONDS.toMillis(10);
    private static final int DEFAULT_READ_TIMEOUT = (int)TimeUnit.SECONDS.toMillis(10);

    /**
     * see {@link DefaultQdsConfiguration#DefaultQdsConfiguration(Type, String)}
     * and {@link DefaultQdsConfiguration#DefaultQdsConfiguration(Type, String, ClientConfig)}
     */
    public enum Type
    {
        /**
         * Endpoint for the staging site
         */
        STAGING()
        {
            @Override
            public String getEndpoint()
            {
                return STAGING_API_ENDPOINT;
            }
        },

        /**
         * Endpoing for the production site
         */
        PRODUCTION()
        {
            @Override
            public String getEndpoint()
            {
                return API_ENDPOINT;
            }
        }
        ;

        public abstract String getEndpoint();
    }

    /**
     * @param apiToken your API token
     */
    public DefaultQdsConfiguration(String apiToken)
    {
        this(Type.PRODUCTION, apiToken, null);
    }

    /**
     * @param type endpoint type
     * @param apiToken your API token
     */
    public DefaultQdsConfiguration(Type type, String apiToken)
    {
        this(type, apiToken, null);
    }

    /**
     * @param type endpoint type
     * @param apiToken your API token
     * @param jerseyConfiguration jersey client configuration or null for default
     */
    public DefaultQdsConfiguration(Type type, String apiToken, ClientConfig jerseyConfiguration)
    {
        this.type = Preconditions.checkNotNull(type, "type cannot be null");
        this.apiToken = Preconditions.checkNotNull(apiToken, "apiToken cannot be null");

        if ( jerseyConfiguration == null )
        {
            jerseyConfiguration = new ClientConfig();
            jerseyConfiguration.property(ClientProperties.CONNECT_TIMEOUT, DEFAULT_CONNECTION_TIMEOUT);
            jerseyConfiguration.property(ClientProperties.READ_TIMEOUT, DEFAULT_READ_TIMEOUT);
        }
        this.jerseyConfiguration = jerseyConfiguration;
    }

    @Override
    public Client newClient()
    {
        return ClientBuilder
            .newClient(jerseyConfiguration)
            .register(JacksonFeature.class);
    }

    @Override
    public String getApiToken()
    {
        return apiToken;
    }

    @Override
    public String getApiEndpoint()
    {
        return type.getEndpoint();
    }

    @Override
    public String getApiVersion()
    {
        return API_VERSION;
    }
}
