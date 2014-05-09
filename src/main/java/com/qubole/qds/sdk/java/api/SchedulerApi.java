package com.qubole.qds.sdk.java.api;


import com.qubole.qds.sdk.java.entities.SchedulesResponse;
import com.qubole.qds.sdk.java.entities.SuccessAndStatus;

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

    /**
     * Corresponds to http://www.qubole.com/docs/suspendresume-or-kill-a-schedule/ - suspend
     *
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> suspend(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/suspendresume-or-kill-a-schedule/ - kill
     *
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> kill(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/suspendresume-or-kill-a-schedule/ - resume
     *
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> resume(int scheduleId);
}
