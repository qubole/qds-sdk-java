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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class App
{
    private int id;
    private String name;
    private String config;
    private String kind;
    private long qbol_user_id;
    private String created_at;
    private String status;
    private String note_id;
    private String interpreter_id;
    private String cluster_label;

    public App()
    {
    }

    public App(int id, String name, String config, String kind, long qbol_user_id, String created_at, String status, String note_id, String interpreter_id, String cluster_label)
    {
        this.id = id;
        this.name = name;
        this.config = config;
        this.kind = kind;
        this.qbol_user_id = qbol_user_id;
        this.created_at = created_at;
        this.status = status;
        this.note_id = note_id;
        this.interpreter_id = interpreter_id;
        this.cluster_label = cluster_label;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getConfig()
    {
        return config;
    }

    public void setConfig(String config)
    {
        this.config = config;
    }

    public String getKind()
    {
        return kind;
    }

    public void setKind(String kind)
    {
        this.kind = kind;
    }

    public long getQbol_user_id()
    {
        return qbol_user_id;
    }

    public void setQbol_user_id(long qbol_user_id)
    {
        this.qbol_user_id = qbol_user_id;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getNote_id()
    {
        return note_id;
    }

    public void setNote_id(String note_id)
    {
        this.note_id = note_id;
    }

    public String getInterpreter_id()
    {
        return interpreter_id;
    }

    public void setInterpreter_id(String interpreter_id)
    {
        this.interpreter_id = interpreter_id;
    }

    public String getCluster_label()
    {
        return cluster_label;
    }

    public void setCluster_label(String cluster_label)
    {
        this.cluster_label = cluster_label;
    }
}
