package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import java.util.Arrays;
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
            ClusterConfigBuilder configBuilder = client.clusterConfig()
                .label(Arrays.asList("pig_workflow", "us_west"))
                .ec2_settings().compute_access_key("foo")
                .ec2_settings().compute_secret_key("bar")
                .ec2_settings().aws_region("us-east-1")
                ;
            Future<ClusterItem> invoke = client.cluster().create(configBuilder)
                .invoke();
            ClusterItem value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
