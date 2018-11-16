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
public class SchedulesResponse
{
    private PagingInfo paging_info;
    private List<Schedule> schedules;

    public SchedulesResponse()
    {
    }

    public SchedulesResponse(PagingInfo paging_info, List<Schedule> schedules)
    {
        this.paging_info = paging_info;
        this.schedules = schedules;
    }

    public PagingInfo getPaging_info()
    {
        return paging_info;
    }

    public void setPaging_info(PagingInfo paging_info)
    {
        this.paging_info = paging_info;
    }

    public List<Schedule> getSchedules()
    {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules)
    {
        this.schedules = schedules;
    }
}
