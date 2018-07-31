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

import javax.ws.rs.client.InvocationCallback;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import java.util.concurrent.Future;

/**
 * Terminating method for commands
 */
public interface InvokableBuilder<T>
{
    /**
     * Invoke the API and return the result
     *
     * @return result
     */
    public Future<T> invoke();

    /**
     * Get the invoke arguments for the API call
     *
     * @return result
     */
    public InvokeArguments<T> getArgumentsInvocation();

    /**
     * Cause invoke() to return the result as a raw client response
     *
     * @return result
     */
    public RawInvokableBuilder raw();

    /**
     * Make the API call using the specified notification callback
     *
     * @param callback the callback to use
     * @return this
     */
    public InvokableBuilder<T> withCallback(InvocationCallback<T> callback);
}
