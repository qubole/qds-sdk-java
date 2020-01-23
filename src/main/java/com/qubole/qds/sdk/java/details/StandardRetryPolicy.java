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

import com.qubole.qds.sdk.java.client.retry.RetryPolicy;
import org.glassfish.jersey.client.ClientResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.util.logging.Logger;

public class StandardRetryPolicy implements RetryPolicy
{
    private static final Logger LOG = Logger.getLogger(StandardRetryPolicy.class.getName());

    private final int maxRetries;

    private static final int DEFAULT_MAX_RETRIES = 5;

    public StandardRetryPolicy()
    {
        this(DEFAULT_MAX_RETRIES);
    }

    public StandardRetryPolicy(int maxRetries)
    {
        if (maxRetries > 5) {
            this.maxRetries = 5;
        }
        else{
            this.maxRetries = maxRetries;
        }
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean shouldBeRetried(URI uri, int retryCount, ClientResponse response, Throwable exception, Mode mode)
    {
        if (retryCount >= maxRetries)
        {
            LOG.warning(String.format("Retries exceeded. retryCount: %d - maxRetries: %d", retryCount, maxRetries));
            return false;
        }

        if ((response != null) && (mode == Mode.RETRY_ALL))
        {
            if (response.getStatusInfo().getFamily() == Response.Status.Family.SERVER_ERROR)
            {
                LOG.info(String.format("Retrying request due to Status %d. retryCount: %d - request: %s", response.getStatus(), retryCount, uri));
                return true;
            }
        }
        if (response != null)
        {
            int responseStatus = response.getStatus();
            if (responseStatus == 429 || responseStatus == 502 || responseStatus == 503 || responseStatus == 504)
            {
                LOG.info(String.format("Retrying request due to status %d, retryCount: %d - request: %s",responseStatus, retryCount, uri));
                return true;
            }
        
        }
        return shouldBeRetried(uri, exception, mode);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    private boolean shouldBeRetried(URI uri, Throwable exception, Mode mode)
    {
        if (exception == null)
        {
            return false;
        }

        if (mode == Mode.RETRY_ALL)
        {
            if (exception instanceof IOException)
            {
                LOG.info(String.format("Retrying request due to exception %s. request: %s", exception.getClass().getSimpleName(), uri));
                return true;
            }
        }
        else
        {
            if (exception instanceof ConnectException)
            {
                LOG.info(String.format("Retrying request due to exception %s. request: %s", exception.getClass().getSimpleName(), uri));
                return true;
            }
        }

        return shouldBeRetried(uri, exception.getCause(), mode);
    }
}
