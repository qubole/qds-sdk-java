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
package com.qubole.qds.sdk.java.client;

import com.qubole.qds.sdk.java.api.AppApi;
import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.DbTapApi;
import com.qubole.qds.sdk.java.api.HiveMetadataApi;
import com.qubole.qds.sdk.java.api.ReportApi;
import com.qubole.qds.sdk.java.api.SchedulerApi;
import com.qubole.qds.sdk.java.details.RequestDetails;
import com.qubole.qds.sdk.java.details.ForPage;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;

import java.io.Closeable;
import java.util.concurrent.Future;

/**
 * client interface
 */
public interface QdsClient extends Closeable
{
    /**
     * Return cluster api factory
     *
     * @return cluster api factory
     */
    public ClusterApi cluster();

    /**
     * Return command api factory
     *
     * @return command api factory
     */
    public CommandApi command();

    /**
     * Return hive metadata api factory
     *
     * @return hive metadata factory
     */
    public HiveMetadataApi hiveMetadata();

    /**
     * Return DbTaps api factory
     *
     * @return DbTaps factory
     */
    public DbTapApi dbTaps();

    /**
     * Return report api factory
     *
     * @return report factory
     */
    public ReportApi report();

    /**
     * Return scheduler api factory
     *
     * @return scheduler factory
     */
    public SchedulerApi scheduler();
    
    /**
     * Return apps api factory
     *
     * @return apps api factory
     */
    public AppApi app();

    /**
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param requestDetails request entity or null
     * @param responseType type of the response
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, Class<T> responseType, String... additionalPaths);

    /**
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param requestDetails request entity or null
     * @param responseType type of the response
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, GenericType<T> responseType, String... additionalPaths);

    /**
     * Low-level request invoker. Not normally used directly. Use the api factories instead.
     *
     * @param forPage paging info or null
     * @param requestDetails request entity or null
     * @param callback response callback
     * @param additionalPaths additional path components
     * @return async result
     */
    public <T> Future<T> invokeRequest(ForPage forPage, RequestDetails requestDetails, InvocationCallback<T> callback, String... additionalPaths);

    @Override
    public void close();
}
