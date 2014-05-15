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
        Assert.assertNull(details.getEntity());
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
        Assert.assertNull(details.getEntity());
        Assert.assertEquals(details.getAdditionalPaths(), new String[]{"commands"});
        Assert.assertEquals(details.getResponseType(), Commands.class);
        Assert.assertEquals(details.getForPage(), new ForPage(10, 20));
    }
}
