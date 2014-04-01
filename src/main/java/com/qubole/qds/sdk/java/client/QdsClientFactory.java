package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.details.QdsClientImpl;

/**
 * Factory for allocating qds clients
 */
public class QdsClientFactory
{
    /**
     * Return a new QDS client using the given configuration
     *
     * @param configuration configuration
     * @return new client
     */
    public static QdsClient newClient(QdsConfiguration configuration)
    {
        return new QdsClientImpl(configuration);
    }

    private QdsClientFactory()
    {
    }
}
