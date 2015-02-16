/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.examples;

import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

public class HadoopCommandExample
{
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));

        QdsClient client = QdsClientFactory.newClient(configuration);
        try {
            HadoopCommandBuilder hcBuilder = client.command().hadoop();

            // Give a name to the command. (Optional)
            hcBuilder.name("hadoop-test");

            // Specify tags for this command. (Optional)
            String tags[] = new String[2];
            tags[0] = "tag1";
            tags[1] = "tag2";
            hcBuilder.tags(tags);

            // Run this command on a non-default cluster.
            // This cluster label must exist otherwise the API call will fail.
            hcBuilder.clusterLabel("custom_label");

            hcBuilder.sub_command(HadoopCommandBuilder.SubCommandType.JAR);
            hcBuilder.sub_command_args("s3n://paid-qubole/HadoopAPIExamples/jars/hadoop-0.20.1-dev-streaming.jar " +
                    "-files s3n://paid-qubole/HadoopAPIExamples/WordCountPython/mapper.py," +
                    "s3n://paid-qubole/HadoopAPIExamples/WordCountPython/reducer.py " +
                    "-mapper mapper.py -reducer reducer.py -numReduceTasks 1 " +
                    "-input s3n://paid-qubole/default-datasets/gutenberg " +
                    "-output output.txt");

            CommandResponse commandResponse = hcBuilder.invoke().get();
            ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
            ResultValue resultValue = resultLatch.awaitResult();
            System.out.println(resultValue.getResults());

            String s = client.command().logs("" + commandResponse.getId()).invoke().get();
            System.err.println(s);
        } finally {
            client.close();
        }
    }
}