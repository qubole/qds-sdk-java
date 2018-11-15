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

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.List;
import java.util.Map;

public class SchemaOrdinal {

  private String table_name;
  private List<NameTypePosition> columns;

  public SchemaOrdinal()
  {
  }

  public SchemaOrdinal(String table_name)
  {
    this.table_name = table_name;
  }

  public SchemaOrdinal(String table_name, List<NameTypePosition> columns)
  {
    this.table_name = table_name;
    this.columns = columns;
  }

  public List<NameTypePosition> getColumns()
  {
    return columns;
  }

  public void setColumns(List<NameTypePosition> columns)
  {
    this.columns = columns;
  }

  public String getTable_name()
  {
    return table_name;
  }

  public void setTable_name(String table_name)
  {
    this.table_name = table_name;
  }

  @JsonAnySetter
  public void defaultSetter(String table_name, Map<String, List<NameTypePosition>> columns)
  {
    this.table_name = table_name;
    this.columns = columns.get("columns");
  }
}
