package com.qubole.qds.sdk.java.examples;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;

public class EditClusterExample
{
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        String cluster_id = "11142";
        try
        {
            System.out.println("Changing Max Nodes");
            client.cluster().edit(cluster_id, client.cluster().clusterConfig().hadoop_settings().max_nodes(4)).invoke().get();
        }
        finally
        {
            client.close();
        }
    }
}
