package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.DependencyInfo;
import com.qubole.qds.sdk.java.entities.Schedule;
import com.qubole.qds.sdk.java.entities.ScheduleCommand;
import java.util.List;
import java.util.Map;

public interface CreateScheduleCommandBuilder extends InvokableBuilder<Schedule>
{
    public CreateScheduleCommandBuilder command_type(String command_type);

    public CreateScheduleCommandBuilder command(ScheduleCommand command);

    public CreateScheduleCommandBuilder macros(List<Map<String, String>> macros);

    public CreateScheduleCommandBuilder start_time(String start_time);

    public CreateScheduleCommandBuilder end_time(String end_time);

    public CreateScheduleCommandBuilder frequency(Map<String, String> frequency);

    public CreateScheduleCommandBuilder time_zone(String time_zone);

    public CreateScheduleCommandBuilder time_out(String time_out);

    public CreateScheduleCommandBuilder concurrency(int concurrency);

    public CreateScheduleCommandBuilder execution_order(String execution_order);

    public CreateScheduleCommandBuilder dependency_info(DependencyInfo dependency_info);
}
