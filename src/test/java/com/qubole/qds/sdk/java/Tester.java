package com.qubole.qds.sdk.java;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
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
            Map<String, Object> parameters = Maps.newHashMap();
            parameters.put("one", "a");
            parameters.put("two", 2);
            Future<CommandResponse> invoke = client.command().pig()
                .latin_statements("hey")
                .parameters(parameters)
                .script_location("yo")
                .invoke();
            CommandResponse value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
