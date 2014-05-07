package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.Cluster;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.Ec2Settings;
import java.util.Arrays;
import java.util.List;
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
            Cluster newConfig = new Cluster();
            newConfig.setEc2_settings(new Ec2Settings());
            newConfig.getEc2_settings().setAws_region("us-east-1");
            newConfig.setEnable_ganglia_monitoring(false);
            List<String> mask = Arrays.asList("enable_ganglia_monitoring", "ec2_settings.aws_region");
            Future<ClusterItem> invoke = client.cluster().edit("5678", newConfig).withMask(mask).invoke();
            ClusterItem value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
