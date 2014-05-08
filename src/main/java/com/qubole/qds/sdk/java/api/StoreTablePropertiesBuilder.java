package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Status;
import java.util.Map;

public interface StoreTablePropertiesBuilder extends InvokableBuilder<Status>
{
    public StoreTablePropertiesBuilder interval(String interval);

    public StoreTablePropertiesBuilder interval_unit(String interval_unit);

    public StoreTablePropertiesBuilder columns(Map<String, String> columns);
}
