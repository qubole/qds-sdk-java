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

import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.qubole.qds.sdk.java.entities.Account;
import com.qubole.qds.sdk.java.entities.AccountCredentials;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Streamer for large results
 */
public class ResultStreamer implements Closeable
{
    // guarded by sync
    private volatile S3Client s3Client;
    private final QdsClient client;

    private static final String S3_PREFIX = "s3://";

    public interface S3Client
    {
        public void shutdown();

        public ObjectListing listObjects(ListObjectsRequest listObjectsRequest);

        public S3Object getObject(String bucket, String key);
    }

    /**
     * @param client qds client
     */
    public ResultStreamer(QdsClient client)
    {
        this.client = client;
    }

    /**
     * Return a stream over the given results. If the results are not inline, the
     * results will come from S3
     *
     * @param resultValue result
     * @return stream
     * @throws Exception errors
     */
    public Reader getResults(ResultValue resultValue) throws Exception
    {
        if ( resultValue.isInline() )
        {
            return new StringReader(resultValue.getResults());
        }

        return readFromS3(resultValue.getResult_location());
    }

    @Override
    public synchronized void close()
    {
        if ( s3Client != null )
        {
            s3Client.shutdown();
            s3Client = null;
        }
    }

    private synchronized void ensureClient() throws Exception
    {
        if ( s3Client != null )
        {
            return;
        }

        s3Client = newS3Client();
    }

    @VisibleForTesting
    protected Account getAccount() throws Exception
    {
        Future<Account> accountFuture = client.invokeRequest(null, null, Account.class, "account");
        return accountFuture.get();
    }
    
    @VisibleForTesting
    protected AccountCredentials getAccountCredentials() throws Exception
    {
        Future<AccountCredentials> accountFuture = client.invokeRequest(null, null, AccountCredentials.class, "accounts/get_creds");
        return accountFuture.get();
    }

    @VisibleForTesting
    protected S3Client newS3Client() throws Exception
    {
        AccountCredentials account = getAccountCredentials();
        BasicSessionCredentials basicSessionCredentials = new BasicSessionCredentials(account.getStorage_access_key(), account.getStorage_secret_key(), account.getSession_token());
        final AmazonS3Client client = new AmazonS3Client(basicSessionCredentials);
        return new S3Client()
        {
            @Override
            public void shutdown()
            {
                client.shutdown();
            }

            @Override
            public ObjectListing listObjects(ListObjectsRequest listObjectsRequest)
            {
                return client.listObjects(listObjectsRequest);
            }

            @Override
            public S3Object getObject(String bucket, String key)
            {
                return client.getObject(bucket, key);
            }
        };
    }

    private Reader readFromS3(final List<String> paths) throws Exception
    {
        ensureClient();
        return new PathReader(paths);
    }

    @SuppressWarnings("NullableProblems")
    private class PathReader extends Reader
    {
        private final Iterator<String> pathIterator;
        private Reader currentReader;

        public PathReader(List<String> paths)
        {
            this.pathIterator = paths.iterator();
            currentReader = null;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException
        {
            if ( currentReader == null )
            {
                loadNextReader();
            }

            if ( currentReader == null )
            {
                return -1;
            }

            int count = currentReader.read(cbuf, off, len);
            if ( count < 0 )
            {
                currentReader.close();
                currentReader = null;
            }

            return (count < 0) ? read(cbuf, off, len) : count;
        }

        private void loadNextReader()
        {
            if ( pathIterator.hasNext() )
            {
                String path = pathIterator.next();

                if ( path.startsWith(S3_PREFIX) )
                {
                    path = path.substring(S3_PREFIX.length());
                }

                int slashIndex = path.indexOf("/");
                if ( (slashIndex < 0) || (slashIndex == (path.length() - 1)) )
                {
                    // error? don't know what to do
                    loadNextReader();
                    return;
                }
                String bucket = path.substring(0, slashIndex);
                String key = path.substring(slashIndex + 1);

                if ( key.endsWith("/") )
                {
                    ObjectListing objectListing = s3Client.listObjects(new ListObjectsRequest().withBucketName(bucket).withPrefix(key));
                    List<String> paths = Lists.newArrayList();
                    for ( S3ObjectSummary summary : objectListing.getObjectSummaries() )
                    {
                        if ( !summary.getKey().equals(key) && (summary.getSize() > 0) )
                        {
                            paths.add(summary.getBucketName() + "/" + summary.getKey());
                        }
                    }
                    currentReader = new PathReader(paths);
                }
                else
                {
                    S3Object object = s3Client.getObject(bucket, key);
                    currentReader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
                }
            }
        }

        @Override
        public void close() throws IOException
        {
            // NOP
        }
    }
}

