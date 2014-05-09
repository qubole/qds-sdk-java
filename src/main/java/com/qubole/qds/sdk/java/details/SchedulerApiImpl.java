package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.client.QdsClient;

class SchedulerApiImpl implements SchedulerApi
{
    private final QdsClient client;

    SchedulerApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
