package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.Cluster;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.HadoopSettings;
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
            HadoopSettings hadoop_settings = new HadoopSettings();
            hadoop_settings.setCustom_config("mapred.hustler.nodes.lease.period=300001\n" + "qubole.excluded-hosts.allow-removal=false");
            newConfig.setHadoop_settings(hadoop_settings);
            List<String> mask = Arrays.asList("hadoop_settings.custom_config");
            Future<ClusterItem> invoke = client.cluster().edit("5678", newConfig, mask).invoke();
            ClusterItem value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
