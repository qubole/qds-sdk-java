package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.*;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

/**
 * Created by Dinesh on 24-12-2014.
 */
public class TestHadoopCommand
{
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint,
                System.getProperty("API_KEY"));

        QdsClient client = QdsClientFactory.newClient(configuration);
        try {
            HadoopCommandBuilder hcBuilder = client.command().hadoop();
            hcBuilder.name("hadoop-test");

            String tags[] = new String[2];
            tags[0] = "test";
            tags[1] = "tags-test";
            hcBuilder.tags(tags);

            hcBuilder.sub_command(HadoopCommandBuilder.SubCommandType.JAR);
            hcBuilder.sub_command_args("s3://paid-qubole/HadoopAPIExamples/jars/hadoop-0.20.1-dev-streaming.jar -files " +
                    "s3n://paid-qubole/HadoopAPIExamples/WordCountPython/mapper.py," +
                    "s3n://paid-qubole/HadoopAPIExamples/WordCountPython/reducer.py " +
                    "-mapper mapper.py -reducer reducer.py -numReduceTasks 1 -input s3n://paid-qubole/default-datasets/gutenberg " +
                    "-output output.txt");

            CommandResponse commandResponse = hcBuilder.invoke().get();
            ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
            ResultValue resultValue = resultLatch.awaitResult();
            System.out.println(resultValue);

            String s = client.command().logs("" + commandResponse.getId()).invoke().get();
            System.out.println(s);
        } finally {
            client.close();
        }
    }

}