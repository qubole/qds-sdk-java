package com.qubole.qds.sdk.java.entities;

public class SpotInstanceSettings
{
    private String maximum_bid_price_percentage;
    private int timeout_for_request;

    public SpotInstanceSettings()
    {
    }

    public SpotInstanceSettings(String maximum_bid_price_percentage, int timeout_for_request)
    {
        this.maximum_bid_price_percentage = maximum_bid_price_percentage;
        this.timeout_for_request = timeout_for_request;
    }

    public String getMaximum_bid_price_percentage()
    {
        return maximum_bid_price_percentage;
    }

    public void setMaximum_bid_price_percentage(String maximum_bid_price_percentage)
    {
        this.maximum_bid_price_percentage = maximum_bid_price_percentage;
    }

    public int getTimeout_for_request()
    {
        return timeout_for_request;
    }

    public void setTimeout_for_request(int timeout_for_request)
    {
        this.timeout_for_request = timeout_for_request;
    }
}
