package com.qubole.qds.sdk.java.details;

public class ForPage
{
    private final int page;
    private final int perPage;

    public ForPage(int page, int perPage)
    {
        this.page = page;
        this.perPage = perPage;
    }

    public int getPage()
    {
        return page;
    }

    public int getPerPage()
    {
        return perPage;
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        ForPage forPage = (ForPage)o;

        if ( page != forPage.page )
        {
            return false;
        }
        //noinspection RedundantIfStatement
        if ( perPage != forPage.perPage )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = page;
        result = 31 * result + perPage;
        return result;
    }
}
