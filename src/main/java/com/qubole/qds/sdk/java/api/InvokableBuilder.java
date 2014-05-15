package com.qubole.qds.sdk.java.api;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;
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
     * Invoke the API and return the result as a raw client response
     *
     * @return result
     */
    public Future<Response> invokeRaw();

    /**
     * Make the API call using the specified notification callback
     *
     * @param callback the callback to use
     * @return this
     */
    public InvokableBuilder<T> withCallback(InvocationCallback<T> callback);
}
