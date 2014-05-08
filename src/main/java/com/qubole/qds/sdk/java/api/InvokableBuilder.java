package com.qubole.qds.sdk.java.api;

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
}
