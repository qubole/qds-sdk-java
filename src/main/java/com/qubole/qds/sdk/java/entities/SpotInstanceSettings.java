package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotInstanceSettings
{
    private String maximum_bid_price_percentage;
    private int timeout_for_request;
    private int maximum_spot_instance_percentage;

    public SpotInstanceSettings()
    {
    }

    public SpotInstanceSettings(String maximum_bid_price_percentage, int timeout_for_request, int maximum_spot_instance_percentage)
    {
        this.maximum_bid_price_percentage = maximum_bid_price_percentage;
        this.timeout_for_request = timeout_for_request;
        this.maximum_spot_instance_percentage = maximum_spot_instance_percentage;
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

    public int getMaximum_spot_instance_percentage()
    {
        return maximum_spot_instance_percentage;
    }

    public void setMaximum_spot_instance_percentage(int maximum_spot_instance_percentage)
    {
        this.maximum_spot_instance_percentage = maximum_spot_instance_percentage;
    }
}
