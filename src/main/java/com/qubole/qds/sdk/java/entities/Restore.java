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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restore 
{
    private String backup_id;
    private String s3_location;
    private boolean automatic;
    private boolean overwrite;
    private List<String> tables;

    public Restore()
    {
    }

    public Restore(String backup_id, String s3_location, boolean automatic, boolean overwrite, List<String> tables)
    {
        this.backup_id = backup_id;
        this.s3_location = s3_location;
        this.automatic = automatic;
        this.overwrite = overwrite;
        this.tables = tables;
    }
    
    public String getBackup_id()
    {
        return backup_id;
    }

    public void setBackup_id(String backup_id)
    {
        this.backup_id = backup_id;
    }
    
    public String getS3_location()
    {
        return s3_location;
    }

    public void setS3_location(String s3_location)
    {
        this.s3_location = s3_location;
    }
    
    public boolean getAutomatic()
    {
        return automatic;
    }

    public void setAutomatic(boolean automatic)
    {
        this.automatic = automatic;
    }
    
    public boolean getOverwrite()
    {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite)
    {
        this.overwrite = overwrite;
    }
    
    public List<String> getTables()
    {
        return tables;
    }

    public void setTables(List<String> tables)
    {
        this.tables = tables;
    }
}
