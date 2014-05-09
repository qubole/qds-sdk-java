package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.DbTapResponse;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            Future<DbTapResponse> invoke = client.dbTapsApi().create().db_host("localhost").db_name("doc_example").db_user("doc_writer").db_passwd("hey").db_type("mysql").db_location("us-east-1").invoke();
            DbTapResponse value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
