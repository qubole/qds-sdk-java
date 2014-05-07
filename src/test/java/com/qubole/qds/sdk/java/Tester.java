package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterState;
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
            Future<ClusterState> stateFuture = client.cluster().state("5792").invoke();
            ClusterState state = stateFuture.get();
            System.out.println(state);
        }
        finally
        {
            client.close();
        }
    }
}
