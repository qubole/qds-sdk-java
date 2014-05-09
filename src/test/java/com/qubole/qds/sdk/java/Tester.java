package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
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
            Future<List<String>> invoke = client.dbTapApi().listTables(2573).invoke();
            List<String> value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
