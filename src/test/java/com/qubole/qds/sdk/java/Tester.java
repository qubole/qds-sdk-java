package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import javax.ws.rs.client.InvocationCallback;
import java.util.List;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            InvocationCallback<List<ClusterItem>> callback = new InvocationCallback<List<ClusterItem>>()
            {
                @Override
                public void completed(List<ClusterItem> clusterItems)
                {
                    System.out.println("hey");
                }

                @Override
                public void failed(Throwable throwable)
                {
                    System.out.println("yo");
                }
            };
            Future<List<ClusterItem>> invoke = client.cluster().list().withCallback(callback).invoke();
            List<ClusterItem> value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
