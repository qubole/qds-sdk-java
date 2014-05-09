package com.qubole.qds.sdk.java.entities;

public class Interval
{
    private String days;

    public Interval()
    {
    }

    public Interval(String days)
    {
        this.days = days;
    }

    public String getDays()
    {
        return days;
    }

    public void setDays(String days)
    {
        this.days = days;
    }
}
