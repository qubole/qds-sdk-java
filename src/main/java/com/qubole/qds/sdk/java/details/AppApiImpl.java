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
package com.qubole.qds.sdk.java.details;

import java.util.List;
import javax.ws.rs.core.GenericType;
import com.qubole.qds.sdk.java.api.AppApi;
import com.qubole.qds.sdk.java.api.AppBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.App;
import com.qubole.qds.sdk.java.entities.AppItem;
import com.qubole.qds.sdk.java.entities.Message;

public class AppApiImpl implements AppApi
{
    private final QdsClient client;

    AppApiImpl(QdsClient client)
    {
        this.client = client;
    }

    @Override
    public InvokableBuilder<App> show(int app_id)
    {
        return new GenericInvokableBuilderImpl<App>(client, RequestDetails.retry(), App.class, "apps", String.valueOf(app_id));
    }

    @Override
    public InvokableBuilder<List<App>> index()
    {
        GenericType<List<App>> type = new GenericType<List<App>>(){};
        return new GenericInvokableBuilderImpl<List<App>>(client, RequestDetails.retry(), type, "apps");
    }

    @Override
    public InvokableBuilder<AppItem> create(AppBuilder app)
    {
        RequestDetails entity = new RequestDetails(app.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<AppItem>(client, entity, AppItem.class, "apps");
    }

    @Override
    public InvokableBuilder<Message> delete(int app_id)
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.DELETE);
        return new GenericInvokableBuilderImpl<Message>(client, entity, Message.class, "apps", String.valueOf(app_id));
    }

    @Override
    public InvokableBuilder<App> stop(int app_id)
    {
        RequestDetails entity = new RequestDetails(null, RequestDetails.Method.PUT);
        return new GenericInvokableBuilderImpl<App>(client, entity, App.class, "app", String.valueOf(app_id), "stop");
    }

    @Override
    public AppBuilder appConfig()
    {
        return new AppBuilderImpl();
    }
}
