package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.details.QdsClientImpl;

public class QdsClientFactory
{
    public static QdsClient newClient(QdsConfiguration configuration)
    {
        return new QdsClientImpl(configuration);
    }

    private QdsClientFactory()
    {
    }
}
