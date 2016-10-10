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
package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.DependencyInfo;
import com.qubole.qds.sdk.java.entities.ScheduleCommand;
import java.util.List;
import java.util.Map;

public interface CreateScheduleCommandBuilder
{
    public CreateScheduleCommandBuilder command_type(String command_type);

    public CreateScheduleCommandBuilder command(ScheduleCommand command);

    public CreateScheduleCommandBuilder macros(List<Map<String, String>> macros);

    public CreateScheduleCommandBuilder start_time(String start_time);

    public CreateScheduleCommandBuilder end_time(String end_time);

    public CreateScheduleCommandBuilder frequency(int frequency);

    public CreateScheduleCommandBuilder name(String name);

    public CreateScheduleCommandBuilder clusterLabel(String clusterLabel);

    public CreateScheduleCommandBuilder time_unit(String time_unit);

    public CreateScheduleCommandBuilder time_zone(String time_zone);

    public CreateScheduleCommandBuilder time_out(String time_out);

    public CreateScheduleCommandBuilder concurrency(int concurrency);

    public CreateScheduleCommandBuilder execution_order(String execution_order);

    public CreateScheduleCommandBuilder dependency_info(DependencyInfo dependency_info);
}
