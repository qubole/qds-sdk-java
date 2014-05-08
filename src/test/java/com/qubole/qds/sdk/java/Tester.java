package com.qubole.qds.sdk.java;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.TableProperties;
import com.qubole.qds.sdk.java.entities.TablePropertiesResponse;
import java.util.Map;
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
/*
            Map<String, String> columns = Maps.newHashMap();
            columns.put("month", "%Y");
            Future<Status> statusFuture = client.hiveMetadata().storeTableProperties("default_qubole_memetracker")
                .interval("1")
                .interval_unit("days")
                .columns(columns)
                .invoke();
            System.out.println(statusFuture.get());
*/

/*
            Future<TablePropertiesResponse> invoke = client.hiveMetadata().getTableProperties("default_qubole_memetracker").invoke();
            TablePropertiesResponse value = invoke.get();
            System.out.println(value);
*/

            Future<Status> statusFuture = client.hiveMetadata().deleteTableProperties("default_qubole_memetracker").invoke();
            System.out.println(statusFuture.get());
        }
        finally
        {
            client.close();
        }
    }
}