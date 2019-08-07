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
package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleCommand {
    private boolean approx_mode;
    private String query;
    private String inline;
    private String command_type;
    private boolean approx_aggregations;
    private boolean sample;
    private String loader_stable;
    private String script_location;
    private String loader_table_name;
    private String md_cmd;

    public static class ScheduleCommandBuilder {
        private final String query;
        private String command_type = null;
        private boolean approx_mode = false;
        private boolean approx_aggregations = false;
        private boolean sample = false;
        private String loader_stable = null;
        private String script_location = null;
        private String loader_table_name = null;
        private String md_cmd = null;

        public ScheduleCommandBuilder(String query) {
            this.query = query;
        }

        public ScheduleCommandBuilder command_type(String command_type) {
            this.command_type = command_type;
            return this;
        }

        public ScheduleCommandBuilder approx_mode(boolean approx_mode) {
            this.approx_mode = approx_mode;
            return this;
        }

        public ScheduleCommandBuilder approx_aggregations(boolean approx_aggregations) {
            this.approx_aggregations = approx_aggregations;
            return this;
        }

        public ScheduleCommandBuilder sample(boolean sample) {
            this.sample = sample;
            return this;
        }

        public ScheduleCommandBuilder loader_stable(String loader_stable) {
            this.loader_stable = loader_stable;
            return this;
        }

        public ScheduleCommandBuilder script_location(String script_location) {
            this.script_location = script_location;
            return this;
        }

        public ScheduleCommandBuilder loader_table_name(String loader_table_name) {
            this.loader_table_name = loader_table_name;
            return this;
        }

        public ScheduleCommandBuilder md_cmd(String md_cmd) {
            this.md_cmd = md_cmd;
            return this;
        }

        public ScheduleCommand build() {
            return new ScheduleCommand(this);
        }
    }

    public ScheduleCommand(){}
    private ScheduleCommand(ScheduleCommandBuilder builder) {
        query = builder.query;
        command_type = builder.command_type;
        approx_mode = builder.approx_mode;
        approx_aggregations = builder.approx_aggregations;
        sample = builder.sample;
        loader_stable = builder.loader_stable;
        script_location = builder.script_location;
        loader_table_name = builder.loader_table_name;
        md_cmd = builder.md_cmd;

        if (command_type.equalsIgnoreCase("shellcommand"))
        {
            inline = query;
            query = null;
        }
    }


    public boolean isApprox_mode() {
        return approx_mode;
    }

    public String getCommand_type() {
        return command_type;
    }

    public String getQuery() {
        return query;
    }

    public String getInline()
    {
        return inline;
    }

    public boolean isApprox_aggregations() {
        return approx_aggregations;
    }

    public boolean isSample() {
        return sample;
    }

    public String getLoader_stable() {
        return loader_stable;
    }

    public String getScript_location() {
        return script_location;
    }

    public String getLoader_table_name() {
        return loader_table_name;
    }

    public String getMd_cmd() {
        return md_cmd;
    }
}
