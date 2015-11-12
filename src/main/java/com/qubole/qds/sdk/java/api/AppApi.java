package com.qubole.qds.sdk.java.api;

import java.util.List;

import com.qubole.qds.sdk.java.entities.App;
import com.qubole.qds.sdk.java.entities.AppItem;
import com.qubole.qds.sdk.java.entities.Message;

public interface AppApi 
{
    
    /**
     * Shows an app by issuing a GET request to the /apps/ID endpoint
     * 
     * @param app_id the id of app
     * @return new builder
     */
    public InvokableBuilder<App> show(int app_id);
    
    /**
     * Shows a list of all available apps by issuing a GET request to the /apps endpoint
     *
     * @return new builder
     */
    public InvokableBuilder<List<App>> index();
    
    /**
     * Create a new App by issuing a POST request to the /apps endpoint
     *
     * @param app config values
     * @return new builder
     */
    public InvokableBuilder<AppItem> create(AppBuilder app);
    
    /**
     * Delete an app by issuing a DELETE request at /apps/ID endpoint
     * 
     * @return new builder
     */
    public InvokableBuilder<Message> delete(int app_id);
    
    /**
     * Stop an app by issuing a PUT request at /apps/ID/stop endpoint
     * 
     * @return new builder
     */
    public InvokableBuilder<App> stop(int app_id);
    
    /**
     * Return a new app builder.
     *
     * @return builder
     */
    public AppBuilder appConfig();
}
