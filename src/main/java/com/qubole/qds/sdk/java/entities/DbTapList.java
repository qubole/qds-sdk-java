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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DbTapList
{
    private PagingInfo paging_info;
    private List<DbTap> db_taps;

    public DbTapList()
    {
    }

    public DbTapList(List<DbTap> db_taps)
    {
        this.db_taps = db_taps;
    }

    public DbTapList(PagingInfo paging_info, List<DbTap> db_taps)
    {
        this.paging_info = paging_info;
        this.db_taps = db_taps;
    }

    public PagingInfo getPaging_info()
    {
        return paging_info;
    }

    public void setPaging_info(PagingInfo paging_info)
    {
        this.paging_info = paging_info;
    }

    public List<DbTap> getDb_taps()
    {
        return db_taps;
    }

    public void setDb_taps(List<DbTap> db_taps)
    {
        this.db_taps = db_taps;
    }
}
