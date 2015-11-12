package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppItem 
{
    private App app;
    
    AppItem()
    {    
    }
    
    AppItem(App app)
    {
        this.app = app;
    }
    
    public App getApp()
    {
        return app;
    }

    public void setApp(App app)
    {
        this.app = app;
    }
}
