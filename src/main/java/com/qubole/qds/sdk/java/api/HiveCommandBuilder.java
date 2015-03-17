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

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface HiveCommandBuilder extends InvokableBuilder<CommandResponse>
{
    public HiveCommandBuilder query(String query);

    public HiveCommandBuilder scriptLocation(String scriptLocation);

    public HiveCommandBuilder commandType(String commandType);

    public HiveCommandBuilder sampleSize(int sampleSize);

    public HiveCommandBuilder approxModeProgress(double approxModeProgress);

    public HiveCommandBuilder approxModeMaxRt(int approxModeMaxRt);

    public HiveCommandBuilder approxModeMinRt(int approxModeMinRt);

    public HiveCommandBuilder approxAggregations(boolean approxAggregations);

    public HiveCommandBuilder macro(String name, String value);

    public HiveCommandBuilder clusterLabel(String clusterLabel);

    public HiveCommandBuilder name(String queryName);

    public HiveCommandBuilder tags(String[] queryTags);

    public BaseCommand build();
}
