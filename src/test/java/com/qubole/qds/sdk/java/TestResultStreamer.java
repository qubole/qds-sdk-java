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
package com.qubole.qds.sdk.java;

import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.CharStreams;
import com.qubole.qds.sdk.java.client.ResultStreamer;
import com.qubole.qds.sdk.java.details.MockClient;
import com.qubole.qds.sdk.java.entities.Account;
import com.qubole.qds.sdk.java.entities.ResultValue;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestResultStreamer
{
    @Test
    public void testInline() throws Exception
    {
        final String VALUE = "this is a test";

        ResultStreamer streamer = getResultStreamer(null, null);
        ResultValue resultValue = new ResultValue(true, VALUE, null);
        Reader results = streamer.getResults(resultValue);
        String s = CharStreams.toString(results);
        results.close();

        Assert.assertEquals(s, VALUE);
    }

    @Test
    public void testSingleFile() throws Exception
    {
        final String VALUE = "this is a test";

        Map<String, S3Object> objects = Maps.newHashMap();
        objects.put("my-bucket/my-key", makeS3Object(VALUE));
        ResultStreamer streamer = getResultStreamer(null, objects);
        ResultValue resultValue = new ResultValue(false, null, Arrays.asList("my-bucket/my-key"));
        Reader results = streamer.getResults(resultValue);
        String s = CharStreams.toString(results);
        results.close();

        Assert.assertEquals(s, VALUE);
    }

    private S3Object makeS3Object(final String VALUE)
    {
        return new S3Object()
        {
            @Override
            public S3ObjectInputStream getObjectContent()
            {
                return new S3ObjectInputStream(new ByteArrayInputStream(VALUE.getBytes()), null);
            }
        };
    }

    @Test
    public void testMultipleFiles() throws Exception
    {
        final String VALUE1 = "this is a test";
        final String VALUE2 = "a is a and not something else";
        final String VALUE3 = "who is john galt?";

        ObjectListing objectListing = new ObjectListing()
        {
            @Override
            public List<S3ObjectSummary> getObjectSummaries()
            {
                return makeSummaries(new BucketAndKey("my-bucket", "my-key-1"), new BucketAndKey("my-bucket", "my-key-2"), new BucketAndKey("my-bucket", "my-key-3"));
            }
        };

        Map<String, S3Object> objects = Maps.newHashMap();
        objects.put("my-bucket/my-key-1", makeS3Object(VALUE1));
        objects.put("my-bucket/my-key-2", makeS3Object(VALUE2));
        objects.put("my-bucket/my-key-3", makeS3Object(VALUE3));
        ResultStreamer streamer = getResultStreamer(objectListing, objects);
        ResultValue resultValue = new ResultValue(false, null, Arrays.asList("s3://my-bucket/foo/"));
        Reader results = streamer.getResults(resultValue);
        String s = CharStreams.toString(results);
        results.close();

        Assert.assertEquals(s, VALUE1 + VALUE2 + VALUE3);
    }

    private static class BucketAndKey
    {
        private final String bucket;
        private final String key;

        private BucketAndKey(String bucket, String key)
        {
            this.bucket = bucket;
            this.key = key;
        }
    }

    private List<S3ObjectSummary> makeSummaries(BucketAndKey... values)
    {
        return Lists.transform
        (
            Arrays.asList(values),
            new Function<BucketAndKey, S3ObjectSummary>()
            {
                @Override
                public S3ObjectSummary apply(BucketAndKey input)
                {
                    S3ObjectSummary summary = new S3ObjectSummary();
                    summary.setBucketName(input.bucket);
                    summary.setKey(input.key);
                    summary.setSize(1); // needs to be non-zero
                    return summary;
                }
            }
        );
    }

    private ResultStreamer getResultStreamer(final ObjectListing objectListing, final Map<String, S3Object> objects)
    {
        return new ResultStreamer(new MockClient())
        {
            @Override
            protected Account getAccount() throws Exception
            {
                return new Account();
            }

            @Override
            protected S3Client newS3Client()
            {
                return new TestS3Client(objectListing, objects);
            }
        };
    }

    private static class TestS3Client implements ResultStreamer.S3Client
    {
        private final ObjectListing objectListing;
        private final Map<String, S3Object> objects;

        private TestS3Client(ObjectListing objectListing, Map<String, S3Object> objects)
        {
            this.objectListing = objectListing;
            this.objects = ImmutableMap.copyOf(objects);
        }

        @Override
        public void shutdown()
        {
            // NOP
        }

        @Override
        public ObjectListing listObjects(ListObjectsRequest listObjectsRequest)
        {
            return objectListing;
        }

        @Override
        public S3Object getObject(String bucket, String key)
        {
            return objects.get(bucket + "/" + key);
        }
    }
}
