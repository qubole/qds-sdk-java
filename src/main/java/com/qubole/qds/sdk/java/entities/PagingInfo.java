package com.qubole.qds.sdk.java.entities;

public class PagingInfo
{
    private Integer previous_page;
    private int per_page;
    private Integer next_page;

    public PagingInfo()
    {
    }

    public PagingInfo(Integer previous_page, int per_page, Integer next_page)
    {
        this.previous_page = previous_page;
        this.per_page = per_page;
        this.next_page = next_page;
    }

    public Integer getPrevious_page()
    {
        return previous_page;
    }

    public void setPrevious_page(Integer previous_page)
    {
        this.previous_page = previous_page;
    }

    public int getPer_page()
    {
        return per_page;
    }

    public void setPer_page(int per_page)
    {
        this.per_page = per_page;
    }

    public Integer getNext_page()
    {
        return next_page;
    }

    public void setNext_page(Integer next_page)
    {
        this.next_page = next_page;
    }
}
