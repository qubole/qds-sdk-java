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
import java.util.List;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.ClusterItem;

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
}
