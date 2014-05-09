package com.qubole.qds.sdk.java.entities;

import java.util.List;

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
