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
public class Snapshot 
{
    private String backup_type;
    private String s3_location;

    public Snapshot()
    {
    }

    public Snapshot(String backup_type, String s3_location)
    {
        this.backup_type = backup_type;
        this.s3_location = s3_location;
    }
    
    public String getBackup_type()
    {
        return backup_type;
    }

    public void setBackup_type(String backup_type)
    {
        this.backup_type = backup_type;
    }
    
    public String getS3_location()
    {
        return s3_location;
    }

    public void setS3_location(String s3_location)
    {
        this.s3_location = s3_location;
    }
}
