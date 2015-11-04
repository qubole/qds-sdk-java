package com.qubole.qds.sdk.java.entities;

import java.util.List;

/**
 * Created by dev on 11/3/15.
 */
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
