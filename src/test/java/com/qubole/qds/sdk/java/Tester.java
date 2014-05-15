package com.qubole.qds.sdk.java;

import com.google.common.io.ByteStreams;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            Future<Response> invoke = client.cluster().list().raw().invoke();
            Response value = invoke.get();
            InputStream inputStream = value.readEntity(InputStream.class);
            String rawJson = new String(ByteStreams.toByteArray(inputStream));
            System.out.println(rawJson);
        }
        finally
        {
            client.close();
        }
    }
}
