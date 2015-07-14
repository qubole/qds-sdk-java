package com.qubole.qds.sdk.java.examples;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;

public class DeleteClusterExample
{
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        String cluster_label = "hadoop3";
        try
        {
            System.out.println("Deleting Cluster");
            client.cluster().delete(cluster_label).invoke();
        }
        finally
        {
            client.close();
        }
    }
}
