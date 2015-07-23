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
import java.util.concurrent.Future;

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
        
        List<String> cluster_list = new ArrayList<String>();
        cluster_list.add("hadoop3");
        String cluster_label = "hadoop3";
        
        try
        {
            System.out.println("Creating New Cluster");
            Future<ClusterItem> cluster_item1 = client.cluster().create(client.cluster().clusterConfig().label(cluster_list).ec2_settings().compute_access_key("ACCESS_KEY").ec2_settings().compute_secret_key("SECRET_ACCESS_KEY")).invoke();
            while (!(cluster_item1.isDone()))
            {
            }
            System.out.println("Cluster Created");
            
            Future<ClusterItem> cluster_item2 = client.cluster().information(cluster_label).invoke();
            System.out.println("Cluster ID: " + cluster_item2.get().getCluster().getId());
            System.out.println("Cluster Label: " + cluster_item2.get().getCluster().getLabel());
            System.out.println("Max Nodes: " + cluster_item2.get().getCluster().getHadoop_settings().getMax_nodes() + "\n");
            
            System.out.println("Editing Cluster (Changing Max Nodes)");
            Future<ClusterItem> cluster_item3 = client.cluster().edit(cluster_label, client.cluster().clusterConfig().hadoop_settings().max_nodes(4)).invoke();
            while (!(cluster_item3.isDone()))
            {
            }
            System.out.println("Cluster Edited");
            
            Future<ClusterItem> cluster_item4 = client.cluster().information(cluster_label).invoke();
            System.out.println("Cluster ID: " + cluster_item4.get().getCluster().getId());
            System.out.println("Cluster Label: " + cluster_item4.get().getCluster().getLabel());
            System.out.println("Max Nodes: " + cluster_item4.get().getCluster().getHadoop_settings().getMax_nodes() + "\n");
            
            System.out.println("Deleting Cluster");
            Future<ClusterItem> cluster_item5 = client.cluster().delete(cluster_label).invoke();
            while (!(cluster_item5.isDone()))
            {
            }
            System.out.println("Cluster Deleted");            
        }
        finally
        {
            client.close();
        }
    }
}
