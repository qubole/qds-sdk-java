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

import com.google.common.collect.Queues;
import com.qubole.qds.sdk.java.details.ForPage;
import com.qubole.qds.sdk.java.details.MockClient;
import com.qubole.qds.sdk.java.entities.Commands;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestRequestComposition
{
    @Test
    public void testCommandHistory() throws InterruptedException
    {
        BlockingQueue<MockClient.InvokeDetails> results = Queues.newArrayBlockingQueue(1);
        MockClient client = new MockClient(results);
        client.command().history().invoke();

        MockClient.InvokeDetails details = results.poll(1, TimeUnit.SECONDS);
        Assert.assertNotNull(details);
        Assert.assertEquals(details.getAdditionalPaths(), new String[]{"commands"});
        Assert.assertEquals(details.getResponseType(), Commands.class);
        Assert.assertNull(details.getForPage());
    }

    @Test
    public void testCommandHistoryWithPaging() throws InterruptedException
    {
        BlockingQueue<MockClient.InvokeDetails> results = Queues.newArrayBlockingQueue(1);
        MockClient client = new MockClient(results);
        client.command().history().forPage(10, 20).invoke();

        MockClient.InvokeDetails details = results.poll(1, TimeUnit.SECONDS);
        Assert.assertNotNull(details);
        Assert.assertEquals(details.getAdditionalPaths(), new String[]{"commands"});
        Assert.assertEquals(details.getResponseType(), Commands.class);
        Assert.assertEquals(details.getForPage(), new ForPage(10, 20));
    }
}
