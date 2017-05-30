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

/**
 * This class is base command for various commands, it has basic information only and primary purpose
 * is to use it in composite command
 */
public interface BaseCommand
{
    public enum COMMAND_TYPE
    {
        NONE,
        HIVE,
        HADOOP,
        PRESTO,
        DB_QUERY,
        DB_EXPORT,
        DB_IMPORT,
        PIG,
        SHELL,
        COMPOSITE,
        SPARK,
        NOTEBOOk
    };

    public COMMAND_TYPE getCommandType();

    public String getJSONString();
}
