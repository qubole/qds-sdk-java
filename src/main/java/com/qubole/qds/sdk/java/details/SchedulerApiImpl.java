package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.SchedulesResponse;

class SchedulerApiImpl implements SchedulerApi
{
    private final QdsClient client;

    @Override
    public PageableInvokableBuilder<SchedulesResponse> list()
    {
        return new GenericPageableInvokableBuilderImpl<SchedulesResponse>(client, null, SchedulesResponse.class, "scheduler");
    }

    SchedulerApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
