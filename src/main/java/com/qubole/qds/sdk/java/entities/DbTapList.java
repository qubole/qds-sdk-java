package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
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
