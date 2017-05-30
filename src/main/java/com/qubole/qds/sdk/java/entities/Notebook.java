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

public class Notebook
{
    public String name;
    public String note_type;
    public String location;
    public String cluster_id;
    public String cloned_from_notebook;
    public String notebook_id;

    public Notebook()
    {
    }

    public Notebook(String name, String note_type, String location, String cluster_id)
    {
        this.name = name;
        this.note_type = note_type;
        this.location = location;
        this.cluster_id = cluster_id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNotetype()
    {
        return this.note_type;
    }

    public void setNotetype(String note_type)
    {
        this.note_type = note_type;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getClusterid()
    {
        return this.cluster_id;
    }

    public void setClusterid(String cluster_id)
    {
        this.cluster_id = cluster_id;
    }

    public String getClonedFromNotebook()
    {
        return this.cloned_from_notebook;
    }

    public void setClonedFromNotebook(String cloned_from_notebook)
    {
        this.cloned_from_notebook = cloned_from_notebook;
    }

    public String getNotebookId()
    {
        return this.notebook_id;
    }

    public void setNotebookId(String notebook_id)
    {
        this.notebook_id = notebook_id;
    }

}
