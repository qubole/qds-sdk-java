package com.qubole.qds.sdk.java;

import com.google.common.collect.Maps;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.Schedule;
import com.qubole.qds.sdk.java.entities.ScheduleCommand;
import java.util.Map;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
            ScheduleCommand command = new ScheduleCommand();
            command.setQuery("select (*) from foo");
            Map<String, String> frequency = Maps.newHashMap();
            frequency.put("days", "1");
            Future<Schedule> invoke = client.scheduler().create()
                .command(command)
                .command_type("HiveCommand")
                .start_time("2014-07-01T02:00Z")
                .end_time("2014-07-02T02:00Z")
                .frequency(frequency)
                .time_out("10")
                .invoke();
            Schedule value = invoke.get();
            System.out.println(value);
        }
        finally
        {
            client.close();
        }
    }
}
