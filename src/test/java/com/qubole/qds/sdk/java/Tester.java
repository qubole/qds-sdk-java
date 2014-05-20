package com.qubole.qds.sdk.java;

import com.google.common.io.CharStreams;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.client.ResultStreamer;
import com.qubole.qds.sdk.java.entities.ResultValue;
import java.io.Reader;
import java.util.Arrays;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            ResultStreamer resultStreamer = new ResultStreamer(client);
            ResultValue resultValue = new ResultValue();
            resultValue.setInline(false);
            resultValue.setResult_location(Arrays.asList("s3://dev.canopydata.com/logs/production/tmp/2014-05-20/1/1804089", "s3://dev.canopydata.com/logs/production/tmp/2014-05-20/1/1804089.dir/"));
            Reader results = resultStreamer.getResults(resultValue);
            for(;;)
            {
                int b = results.read();
                if ( b < 0 )
                {
                    break;
                }
                System.out.print((char)(b & 0xffff));
            }
/*
            Future<ResultValue> invoke = client.command().results("222070").inline(false).invoke();
            ResultValue value = invoke.get();
            System.out.println(value);
*/
        }
        finally
        {
            client.close();
        }
    }
}
