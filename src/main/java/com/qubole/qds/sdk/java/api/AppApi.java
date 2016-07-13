/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
