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
    public String note_id;
    public String account_id;
    public String created_at;
    public String deleted_at;
    public String file_name;
    public String id;
    public String link_id;
    public String link_type;
    public String parent_folder_id;
    public String published_notebook_id;
    public String qbol_user_id;
    public String read_only;
    public String source;
    public String space_subscriber_id;
    public String updated_at;

    public Notebook()
    {
    }

    public Notebook(String account_id, String cluster_id, String created_at, String deleted_at, String file_name, String id,
        String link_id, String link_type, String location, String name, String note_id, String note_type, String parent_folder_id,
        String published_notebook_id, String qbol_user_id, String read_only, String source, String space_subscriber_id,
        String updated_at)
    {
        this.account_id = account_id;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
        this.file_name = file_name;
        this.link_id = link_id;
        this.link_type = link_type;
        this.note_id = note_id;
        this.note_type = note_type;
        this.parent_folder_id = parent_folder_id;
        this.published_notebook_id = published_notebook_id;
        this.qbol_user_id = qbol_user_id;
        this.read_only = read_only;
        this.source = source;
        this.space_subscriber_id = space_subscriber_id;
        this.updated_at = updated_at;
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

    public String getUpdatedAt()
    {
        return this.updated_at;
    }

    public void setUpdatedAt(String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getSpaceSubcriberId()
    {
        return this.space_subscriber_id;
    }

    public void setSpaceSubcriberId(String space_subscriber_id)
    {
        this.space_subscriber_id = space_subscriber_id;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getReadOnly()
    {
        return this.read_only;
    }

    public void setReadOnly(String read_only)
    {
        this.read_only = read_only;
    }

    public String getQbolUserId()
    {
        return this.qbol_user_id;
    }

    public void setQbolUserId(String qbol_user_id)
    {
        this.qbol_user_id = qbol_user_id;
    }

    public String getPublishedNotebookId()
    {
        return this.published_notebook_id;
    }

    public void setPublishedNotebookId(String published_notebook_id)
    {
        this.published_notebook_id = published_notebook_id;
    }

    public String getParentFolderId()
    {
        return this.parent_folder_id;
    }

    public void setParentFolderId(String  parent_folder_id)
    {
        this.parent_folder_id = parent_folder_id;
    }

    public String getNoteType()
    {
        return this.note_type;
    }

    public void setNoteType(String note_type)
    {
        this.note_type = note_type;
    }

    public String getLinkType()
    {
        return this.link_type;
    }

    public void setLinkType(String link_type)
    {
        this.link_type = link_type;
    }

    public String getLinkId()
    {
        return this.link_id;
    }

    public void setLinkId(String link_id)
    {
        this.link_id = link_id;
    }

    public String getFileName()
    {
        return this.file_name;
    }

    public void setFileName(String file_name)
    {
        this.file_name = file_name;
    }

    public String getDeletedAt()
    {
        return this.deleted_at;
    }

    public void setDeletedAt(String deleted_at)
    {
        this.deleted_at = deleted_at;
    }

    public String getCreatedAt()
    {
        return this.created_at;
    }

    public void setCreatedAt(String created_at)
    {
        this.created_at = created_at;
    }

    public String getAccountId()
    {
        return this.account_id;
    }

    public void setAcocountId(String account_id)
    {
        this.account_id = account_id;
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

    public String getClusterId()
    {
        return this.cluster_id;
    }

    public void setClusterId(String cluster_id)
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

    public String getNoteId()
    {
        return this.note_id;
    }

    public void setNoteId(String note_id)
    {
        this.note_id = note_id;
    }

}
