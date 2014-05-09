package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.SchedulesResponse;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/scheduler-api/
 */
public interface SchedulerApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/list-schedules/
     *
     * @return builder
     */
    public PageableInvokableBuilder<SchedulesResponse> list();
}
