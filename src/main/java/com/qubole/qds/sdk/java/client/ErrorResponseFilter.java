package com.qubole.qds.sdk.java.client;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;
import java.io.InputStreamReader;

public class ErrorResponseFilter implements ClientResponseFilter {

    @Override
    public void filter(final ClientRequestContext requestContext,
                       final ClientResponseContext responseContext) {
        try {
            // For non-200 response, log the custom error message.
            if (responseContext.getStatus() != Response.Status.OK.getStatusCode()) {
                if (responseContext.hasEntity()) {
                    System.err.println(CharStreams.toString(
                            new InputStreamReader(responseContext.getEntityStream(), Charsets.UTF_8)));
                }
            }
        } catch (Exception e) {
            // Silently pass. We don't want anything to fail because of this filter.
        }
    }

}
