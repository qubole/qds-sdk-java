package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            ClusterConfigBuilder configBuilder = client.clusterConfig().enable_ganglia_monitoring(false);
            Future<ClusterItem> invoke = client.cluster().edit("5678", configBuilder).invoke();
            ClusterItem value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
