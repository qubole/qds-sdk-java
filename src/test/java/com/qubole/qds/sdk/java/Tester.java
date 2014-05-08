package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
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
            Future<CommandResponse> invoke = client.command().hadoop()
                .sub_command(HadoopCommandBuilder.SubCommandType.JAR).sub_command_args("s3://paid-qubole/HadoopAPIExamples/jars/hadoop-0.20.1-dev-streaming.jar -mapper wc -numReduceTasks 0 -input s3://paid-qubole/HadoopAPITests/data/3.tsv -output s3://paid-qubole/HadoopAPITests/data/3_wc")
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
