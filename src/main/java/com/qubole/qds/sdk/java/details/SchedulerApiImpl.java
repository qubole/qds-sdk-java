/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CreateScheduleCommandBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PageableInvokableBuilder;
import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Commands;
import com.qubole.qds.sdk.java.entities.Schedule;
import com.qubole.qds.sdk.java.entities.SchedulesResponse;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.SuccessAndStatus;

class SchedulerApiImpl implements SchedulerApi
{
    private final QdsClient client;

    @Override
    public PageableInvokableBuilder<SchedulesResponse> list()
    {
        return new GenericPageableInvokableBuilderImpl<SchedulesResponse>(client, RequestDetails.retry(), SchedulesResponse.class, "scheduler");
    }

    @Override
    public InvokableBuilder<SuccessAndStatus> suspend(int scheduleId)
    {
        return suspendKillResume(scheduleId, "suspend");
    }

    @Override
    public InvokableBuilder<SuccessAndStatus> kill(int scheduleId)
    {
        return suspendKillResume(scheduleId, "kill");
    }

    @Override
    public InvokableBuilder<SuccessAndStatus> resume(int scheduleId)
    {
        return suspendKillResume(scheduleId, "resume");
    }

    @Override
    public InvokableBuilder<Schedule> view(int scheduleId)
    {
        return new GenericInvokableBuilderImpl<Schedule>(client, RequestDetails.retry(), Schedule.class, "scheduler", Integer.toString(scheduleId));
    }

    @Override
    public PageableInvokableBuilder<Commands> listInstances(int scheduleId)
    {
        return new GenericPageableInvokableBuilderImpl<Commands>(client, RequestDetails.retry(), Commands.class, "scheduler", Integer.toString(scheduleId), "instances");
    }

    @Override
    public InvokableBuilder<Command> viewCommand(int scheduleId, int instanceId)
    {
        return new GenericInvokableBuilderImpl<Command>(client, RequestDetails.retry(), Command.class, "scheduler", Integer.toString(scheduleId), "instances", Integer.toString(instanceId));
    }

    @Override
    public InvokableBuilder<String> instanceLogs(int scheduleId, int instanceId)
    {
        return new GenericInvokableBuilderImpl<String>(client, RequestDetails.retry(), String.class, "scheduler", Integer.toString(scheduleId), "instances", Integer.toString(instanceId), "logs");
    }

    @Override
    public InvokableBuilder<String> instanceResults(int scheduleId, int instanceId)
    {
        return new GenericInvokableBuilderImpl<String>(client, RequestDetails.retry(), String.class, "scheduler", Integer.toString(scheduleId), "instances", Integer.toString(instanceId), "results");
    }
    
    @Override
    public InvokableBuilder<Schedule> edit(String scheduleId, CreateScheduleCommandBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<Schedule>(client, entity, Schedule.class, "scheduler", scheduleId);
    }
    
    @Override
    public InvokableBuilder<Schedule> create(CreateScheduleCommandBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<Schedule>(client, entity, Schedule.class, "scheduler");
    }
    
    private InvokableBuilder<SuccessAndStatus> suspendKillResume(int scheduleId, String status)
    {
        RequestDetails entity = new RequestDetails(new Status(status), RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<SuccessAndStatus>(client, entity, SuccessAndStatus.class, "scheduler", Integer.toString(scheduleId));
    }
    
    @Override
    public CreateScheduleCommandBuilder scheduleBuilder()
    {
        return new CreateScheduleCommandBuilderImpl();
    }
    
    SchedulerApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
