package com.qubole.qds.sdk.java.api;

import java.util.Map;

public interface AppBuilder 
{
    public AppBuilder name(String name);
    
    public AppBuilder config(Map<String,String> config);
    
    public AppBuilder kind(String kind);
}
