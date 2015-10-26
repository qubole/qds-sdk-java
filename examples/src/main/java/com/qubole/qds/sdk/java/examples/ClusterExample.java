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
package com.qubole.qds.sdk.java.examples;

import java.util.ArrayList;
import java.util.List;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterItem;

public class ClusterExample
{
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);

        String cluster_label = "example";
        List<String> cluster_list = new ArrayList<String>();
        cluster_list.add(cluster_label);

        String cluster_label_clone = "example_clone";
        List<String> cluster_list_clone = new ArrayList<String>();
        cluster_list_clone.add(cluster_label_clone);

        try {
            System.out.println("Creating new cluster...");
            ClusterItem clusterItem = client.cluster().create(client.cluster().clusterConfig()
                    .label(cluster_list)
                    .ec2_settings().compute_access_key("ACCESS_KEY")
                    .ec2_settings().compute_secret_key("SECRET_ACCESS_KEY")).invoke().get();
            System.out.println("Cluster created with id " + clusterItem.getCluster().getId());
            System.out.println("The maximum nodes in the cluster are: " +
                    clusterItem.getCluster().getHadoop_settings().getMax_nodes());
            System.out.println();

            System.out.println("Editing cluster (changing max nodes)...");
            clusterItem = client.cluster().edit(
                    cluster_label,
                    client.cluster().clusterConfig().hadoop_settings().max_nodes(5)).invoke().get();
            System.out.println("The maximum nodes now are: " +
                    clusterItem.getCluster().getHadoop_settings().getMax_nodes());
            System.out.println();

            System.out.println("Cloning cluster...");
            ClusterItem clonedClusterItem = client.cluster().clone(cluster_label, client.cluster().clusterConfig()
                    .label(cluster_list_clone)
                    .enable_ganglia_monitoring(true)).invoke().get();
            System.out.println("Cloned cluster id is: " +
                    clonedClusterItem.getCluster().getId());
            System.out.println();

            System.out.println("Deleting clusters...");
            client.cluster().delete(cluster_label).invoke().get();
            client.cluster().delete(String.valueOf(clonedClusterItem
                .getCluster().getId())).invoke().get();
            System.out.println("Clusters Deleted");
        }
        finally
        {
            client.close();
        }
    }
}
