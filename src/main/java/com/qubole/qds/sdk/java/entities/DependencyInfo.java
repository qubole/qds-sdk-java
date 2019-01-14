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
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DependencyInfo
{
    private List<HiveTable> hive_tables;
    private List<String> files;

    public DependencyInfo()
    {
    }

    public DependencyInfo(List<HiveTable> hive_tables, List<String> files)
    {
        this.hive_tables = hive_tables;
        this.files = files;
    }

    public List<HiveTable> getHive_tables()
    {
        return hive_tables;
    }

    public void setHive_tables(List<HiveTable> hive_tables)
    {
        this.hive_tables = hive_tables;
    }

    public List<String> getFiles()
    {
        return files;
    }

    public void setFiles(List<String> files)
    {
        this.files = files;
    }
}
