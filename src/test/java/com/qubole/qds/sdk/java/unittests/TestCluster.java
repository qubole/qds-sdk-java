package com.qubole.qds.sdk.java.unittests;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.google.common.base.Joiner;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.Command;

public class TestCluster
{
    QdsConfiguration configuration;
    QdsClient qdsClient;
    ObjectMapper mapper;

    @BeforeClass
    public void setup()
    {
        mapper = new ObjectMapper();
        configuration = new DefaultQdsConfiguration("https://api.qubole.com/api","apiToken");
        qdsClient = QdsClientFactory.newClient(configuration);
    }

    @Test
    public void testClusterAddNode() throws Exception
    {
        String randomclusterId="123";
        InvokeArguments<Command> invokeargs = qdsClient.cluster().add_nodes(randomclusterId, 4).getArgumentsInvocation();
        JSONObject params=new JSONObject();
        params.put("node_count", 4);
        assertRequestDetails(invokeargs, "POST", "clusters/"+randomclusterId+"/nodes", params, null, Command.class);
    }
    
    @Test
    public void testClusterRemoveNode() throws Exception
    {
        String randomclusterId="123";
        String dnsOfNode="ec2-123-123-123-123.qubole.com";
        InvokeArguments<Command> invokeargs = qdsClient.cluster().remove_node(randomclusterId, dnsOfNode).getArgumentsInvocation();
        Map<Object, Object> params=new HashMap<Object, Object>();
        params.put("private_dns", dnsOfNode);
        assertRequestDetails(invokeargs, "DELETE", "clusters/"+randomclusterId+"/nodes", null, params, Command.class);
    }
    
    @Test
    public void testClusterReplaceNode() throws Exception
    {
        String randomclusterId="123";
        String dnsOfNode="ec2-123-123-123-123.qubole.com";
        InvokeArguments<Command> invokeargs = qdsClient.cluster().replace_node(randomclusterId, dnsOfNode).getArgumentsInvocation();
        JSONObject params=new JSONObject();
        params.put("private_dns", dnsOfNode);
        params.put("command", "replace");
        assertRequestDetails(invokeargs, "PUT", "clusters/"+randomclusterId+"/nodes", params, null, Command.class);
    }

    public void assertRequestDetails(InvokeArguments<?> invokeargs, String expectedRequestType, String expectedEndpoint, JSONObject expectedRequestData, Map<Object, Object> expectedQueryParams, Class<?> expectedResponseClassType) throws Exception
    {
        Assert.assertEquals(invokeargs.getEntity().getMethod().name(), expectedRequestType, "Incorrect request type. Expected : "+expectedRequestType+" , got from request : "+invokeargs.getEntity().getMethod().name());
        Assert.assertEquals(Joiner.on("/").join(invokeargs.getAdditionalPaths()), expectedEndpoint, "Incorrect endpoint. Expected : "+expectedEndpoint+" , got from request : "+Joiner.on("/").join(invokeargs.getAdditionalPaths()));
        Assert.assertTrue(expectedResponseClassType.isInstance(invokeargs.getResponseType().newInstance()), "Expected rsponse type was : " + expectedResponseClassType.getSimpleName() + " , but it is of type : " + invokeargs.getResponseType().getSimpleName());

        if (expectedRequestData != null)
        {
            Assert.assertNotNull(invokeargs.getEntity().getEntity(), "Request data is null. Expected was : " + expectedRequestData);
            Assert.assertTrue(mapper.readTree(mapper.writeValueAsString(invokeargs.getEntity().getEntity())).equals(mapper.readTree(expectedRequestData.toString())), "Incorrect request data. Expected was : " + expectedRequestData + " , got from request : " + mapper.writeValueAsString(invokeargs.getEntity().getEntity()));
        }
        else
        {
            Assert.assertNull(invokeargs.getEntity().getEntity(), "Request data expected was null. But it is not null.");
        }
        
        if (expectedQueryParams != null)
        {
            Assert.assertNotNull(invokeargs.getEntity().getQueryParams(), "Query params expected was not null. But it is null");
            Assert.assertTrue(invokeargs.getEntity().getQueryParams().equals(expectedQueryParams));
        }
        else
        {
            Assert.assertNull(invokeargs.getEntity().getQueryParams(), "Query params expected was null. But it is not null");
        }
    }
}
