package com.qubole.qds.sdk.java.api;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

/**
 * Terminating method for commands
 */
public interface RawInvokableBuilder
{
    /**
     * Invoke the API and return the raw result
     *
     * @return result
     */
    public Future<Response> invoke();
}
