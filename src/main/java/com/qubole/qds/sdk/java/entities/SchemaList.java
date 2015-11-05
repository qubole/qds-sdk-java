package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * Created by dev on 10/21/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class SchemaList {
  private PagingInfo paging_info;
  private Map<String, List<Schema>> schemas;

  public SchemaList()
  {
  }

  public SchemaList(Map<String, List<Schema>> schemas)
  {
    this.schemas = schemas;
  }

  public SchemaList(PagingInfo paging_info, Map<String, List<Schema>> schemas)
  {
    this.paging_info = paging_info;
    this.schemas = schemas;
  }

  public PagingInfo getPaging_info()
  {
    return paging_info;
  }

  public void setPaging_info(PagingInfo paging_info)
  {
    this.paging_info = paging_info;
  }

  public Map<String, List<Schema>> getSchemas()
  {
    return schemas;
  }

  public void setSchemas(Map<String, List<Schema>> schemas)
  {
    this.schemas = schemas;
  }
}
