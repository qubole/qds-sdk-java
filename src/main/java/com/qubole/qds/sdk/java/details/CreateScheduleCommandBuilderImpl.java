package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.CreateScheduleCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.DependencyInfo;
import com.qubole.qds.sdk.java.entities.Schedule;
import com.qubole.qds.sdk.java.entities.ScheduleCommand;
import org.codehaus.jackson.node.ObjectNode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

class CreateScheduleCommandBuilderImpl implements CreateScheduleCommandBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();
    private final QdsClient client;

    @Override
    public CreateScheduleCommandBuilder command_type(String command_type)
    {
        node.put("command_type", command_type);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder command(ScheduleCommand command)
    {
        node.putPOJO("command", command);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder macros(List<Map<String, String>> macros)
    {
        node.putPOJO("macros", macros);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder start_time(String start_time)
    {
        node.put("start_time", start_time);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder end_time(String end_time)
    {
        node.put("end_time", end_time);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder frequency(Map<String, String> frequency)
    {
        node.putPOJO("frequency", frequency);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder time_zone(String time_zone)
    {
        node.put("time_zone", time_zone);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder time_out(String time_out)
    {
        node.put("time_out", time_out);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder concurrency(int concurrency)
    {
        node.put("concurrency", concurrency);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder execution_order(String execution_order)
    {
        node.put("execution_order", execution_order);
        return this;
    }

    @Override
    public CreateScheduleCommandBuilder dependency_info(DependencyInfo dependency_info)
    {
        node.putPOJO("dependency_info", dependency_info);
        return this;
    }

    @Override
    public Future<Schedule> invoke()
    {
        ClientEntity entity = CommandBuilderImplBase.makeJsonEntity(node, ClientEntity.Method.POST);
        return client.invokeRequest(null, entity, Schedule.class, "scheduler");
    }

    CreateScheduleCommandBuilderImpl(QdsClient client)
    {
        this.client = client;
    }
}
