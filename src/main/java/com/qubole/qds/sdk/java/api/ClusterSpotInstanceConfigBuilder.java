package com.qubole.qds.sdk.java.api;

public interface ClusterSpotInstanceConfigBuilder<T>
{
    public T maximum_bid_price_percentage(String maximum_bid_price_percentage);
    public T timeout_for_request(int timeout_for_request);
}
