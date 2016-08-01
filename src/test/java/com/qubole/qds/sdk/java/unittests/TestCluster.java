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
package com.qubole.qds.sdk.java.unittests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.Command;

public class TestCluster extends AbstractTest
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
}
