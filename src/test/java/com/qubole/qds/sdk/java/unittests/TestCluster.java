package com.qubole.qds.sdk.java.unittests;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.ClusterItem;

public class TestCluster extends CommonSetup
{
    @Test
    public void testClusterClone() throws Exception
    {
        String randomclusterId = "123";
        List<String> label = Arrays.asList("newLabel");
        InvokeArguments<ClusterItem> invokeargs = qdsClient.cluster().clone(randomclusterId, qdsClient.cluster().clusterConfig().label(label).disallow_cluster_termination(true).enable_ganglia_monitoring(true)).getArgumentsInvocation();
        JSONObject clusterParams = new JSONObject();
        clusterParams.put("label", label);
        clusterParams.put("disallow_cluster_termination", true);
        clusterParams.put("enable_ganglia_monitoring", true);
        JSONObject expectedRequestData = new JSONObject();
        expectedRequestData.put("cluster", clusterParams);
        assertRequestDetails(invokeargs, "POST", "clusters/"+randomclusterId+"/clone", expectedRequestData, null, ClusterItem.class);
    }
}
