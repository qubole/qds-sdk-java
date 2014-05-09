package com.qubole.qds.sdk.java.api;


import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Commands;
import com.qubole.qds.sdk.java.entities.Schedule;
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
     * @param scheduleId schedule id
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> suspend(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/suspendresume-or-kill-a-schedule/ - kill
     *
     * @param scheduleId schedule id
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> kill(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/suspendresume-or-kill-a-schedule/ - resume
     *
     * @param scheduleId schedule id
     * @return builder
     */
    public InvokableBuilder<SuccessAndStatus> resume(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-a-schedule/
     *
     * @param scheduleId schedule id
     * @return builder
     */
    public InvokableBuilder<Schedule> view(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/list-schedule-instances/
     *
     * @param scheduleId schedule id
     * @return builder
     */
    public PageableInvokableBuilder<Commands> listInstances(int scheduleId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-a-scheduled-command/
     *
     * @param scheduleId schedule id
     * @param instanceId instance id
     * @return builder
     */
    public InvokableBuilder<Command> viewCommand(int scheduleId, int instanceId);

    /**
     * Corresponds to http://www.qubole.com/docs/get-logs-of-scheduled-instances/
     *
     * @param scheduleId schedule id
     * @param instanceId instance id
     * @return builder
     */
    public InvokableBuilder<String> instanceLogs(int scheduleId, int instanceId);

    /**
     * Corresponds to http://www.qubole.com/docs/get-results-of-a-scheduled-instance/
     *
     * @param scheduleId schedule id
     * @param instanceId instance id
     * @return builder
     */
    public InvokableBuilder<String> instanceResults(int scheduleId, int instanceId);
}
