package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.api.DbTapBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.DbTap;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            DbTapBuilder dbTapBuilder = client.dbTapApi().dbTap().db_port(100);
            Future<DbTap> invoke = client.dbTapApi().edit(2573, dbTapBuilder).invoke();
            DbTap value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
