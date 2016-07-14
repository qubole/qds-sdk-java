package com.qubole.qds.sdk.java.unittests;

import java.util.Arrays;
import java.util.List;
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
import com.qubole.qds.sdk.java.entities.ClusterItem;

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
    public void testClusterClone() throws Exception
    {
        String randomclusterId="123";
        List<String> label=Arrays.asList("newLabel");
        InvokeArguments<ClusterItem> invokeargs = qdsClient.cluster().clone(randomclusterId, qdsClient.cluster().clusterConfig().label(label).disallow_cluster_termination(true).enable_ganglia_monitoring(true)).getArgumentsInvocation();
        JSONObject clusterParams=new JSONObject();
        clusterParams.put("label", label);
        clusterParams.put("disallow_cluster_termination", true);
        clusterParams.put("enable_ganglia_monitoring", true);
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("cluster", clusterParams);
        assertRequestDetails(invokeargs, "POST", "clusters/"+randomclusterId+"/clone", expectedRequestData, null, ClusterItem.class);
    }

    public void assertRequestDetails(InvokeArguments<?> invokeargs, String expectedRequestType, String expectedEndpoint, JSONObject expectedRequestData, Map<Object, Object> expectedQueryParams, Class<?> expectedResponseClassType) throws Exception
    {
        Assert.assertEquals(invokeargs.getEntity().getMethod().name(), expectedRequestType, "Incorrect request type. Expected : "+expectedRequestType+" , got from request : "+invokeargs.getEntity().getMethod().name());
        Assert.assertEquals(Joiner.on("/").join(invokeargs.getAdditionalPaths()), expectedEndpoint, "Incorrect endpoint. Expected : "+expectedEndpoint+" , got from request : "+Joiner.on("/").join(invokeargs.getAdditionalPaths()));
        Assert.assertTrue(expectedResponseClassType.isInstance(invokeargs.getResponseType().newInstance()), "Expected rsponse type was : " + expectedResponseClassType.getSimpleName() + " , but it is of type : " + invokeargs.getResponseType().getSimpleName());

        if (expectedRequestData != null)
        {
            Assert.assertNotNull(invokeargs.getEntity().getEntity(), "Request data is null. Expected was : " + expectedRequestData);
            Assert.assertTrue(mapper.readTree(invokeargs.getEntity().getEntity().toString()).equals(mapper.readTree(expectedRequestData.toString())), "Incorrect request data. Expected was : " + expectedRequestData + " , got from request : " + invokeargs.getEntity().getEntity().toString());
        }
        else
        {
            Assert.assertNull(invokeargs.getEntity().getEntity(), "Request data expected was null. But it is : " + invokeargs.getEntity().getEntity().toString());
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
