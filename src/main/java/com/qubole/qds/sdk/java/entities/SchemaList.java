package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by dev on 10/21/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchemaList {
  private PagingInfo paging_info;
  private LinkedHashMap<String, ArrayList<Schema>> schemas;

  public SchemaList()
  {
  }

  public SchemaList(LinkedHashMap<String, ArrayList<Schema>> schemas)
  {
    this.schemas = schemas;
  }

  public SchemaList(PagingInfo paging_info, LinkedHashMap<String, ArrayList<Schema>> schemas)
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

  public LinkedHashMap<String, ArrayList<Schema>> getSchemaList()
  {
    return schemas;
  }

  public void setSchemaList(LinkedHashMap<String, ArrayList<Schema>> schemas)
  {
    this.schemas = schemas;
  }
}
