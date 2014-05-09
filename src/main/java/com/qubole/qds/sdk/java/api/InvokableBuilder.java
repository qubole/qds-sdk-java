package com.qubole.qds.sdk.java.api;

import javax.ws.rs.client.InvocationCallback;
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
     * Make the API call using the specified notification callback
     *
     * @param callback the callback to use
     * @return this
     */
    public InvokableBuilder<T> withCallback(InvocationCallback<T> callback);
}
