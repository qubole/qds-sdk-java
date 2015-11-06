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

import java.util.List;

public class SchemaNamesResponse {

  private List<String> schemas;
  private String default_schema;
  private String status;

  public SchemaNamesResponse() {

  }
  public SchemaNamesResponse(List<String> schemas, String default_schema, String status) {
    this.schemas = schemas;
    this.default_schema = default_schema;
    this.status = status;
  }

  public List<String> getSchemas() {
    return schemas;
  }

  public String getDefault_schema() {
    return default_schema;
  }

  public String getStatus() {
    return status;
  }

  public void setSchemas(List<String> schemas) {
    this.schemas = schemas;
  }

  public void setDefault_schema(String default_schema) {
    this.default_schema = default_schema;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
