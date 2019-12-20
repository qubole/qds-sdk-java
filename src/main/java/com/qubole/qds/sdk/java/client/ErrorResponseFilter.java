package com.qubole.qds.sdk.java.client;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ErrorResponseFilter implements ClientResponseFilter {

    private static final Logger LOG = Logger.getLogger(ErrorResponseFilter.class.getName());

    @Override
    public void filter(final ClientRequestContext requestContext,
                       final ClientResponseContext responseContext) {
        try {
            // For non-200 response, log the custom error message.
            if (responseContext.getStatus() != Response.Status.OK.getStatusCode()) {
                if (responseContext.hasEntity()) {
                    String error = CharStreams.toString(
                        new InputStreamReader(responseContext.getEntityStream(), Charsets.UTF_8));
                    //Add trace_id support
                    String traceId = responseContext.getHeaderString("X-Qubole-Trace-Id");
                    if (traceId != null && !traceId.isEmpty()){
                        String displayMessage = "Request ID is '" + traceId + "' .Please share it with Qubole Support team for any assistance";
                        LOG.severe(displayMessage);
                        System.err.println(displayMessage);
                    }
                    LOG.severe(error);
                    System.err.println(error);
                }
            }
        } catch (Exception e) {
            // Silently pass. We don't want anything to fail because of this filter.
            LOG.warning("Error while checking response code: " + e.getMessage());
        }
    }
}
