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

import com.qubole.qds.sdk.java.api.BaseCommand;
import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.CompositeCommandBuilder;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

public class CompositeCommandExample {
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));

        QdsClient client = QdsClientFactory.newClient(configuration);
        try {

            // build a hive and hadoop command
            HiveCommandBuilder hiveBuilder = client.command().hive().query("show tables;");
            HadoopCommandBuilder hcBuilder = client.command().hadoop();

            hcBuilder.sub_command(HadoopCommandBuilder.SubCommandType.JAR);
            hcBuilder.sub_command_args("s3://paid-qubole/HadoopAPIExamples/jars/hadoop-0.20.1-dev-streaming.jar -files " +
                    "s3n://paid-qubole/HadoopAPIExamples/WordCountPython/mapper.py," +
                    "s3n://paid-qubole/HadoopAPIExamples/WordCountPython/reducer.py " +
                    "-mapper mapper.py -reducer reducer.py -numReduceTasks 1 -input s3n://paid-qubole/default-datasets/gutenberg " +
                    "-output output11.txt");

            // build sub command objects
            BaseCommand subCommand1 = hiveBuilder.build();
            BaseCommand subCommand2 = hcBuilder.build();

            // create composite command builder
            CompositeCommandBuilder wfBuilder = client.command().composite();

            // add the two sub commands to this composite command
            // and invoke it
            CommandResponse commandResponse =
                        wfBuilder.addSubCommand(subCommand1).addSubCommand(subCommand2).invoke().get();

            // for individual commands we can get the array of sub command objects
            Command[] subCommands = commandResponse.getCommand().getsub_commands();

            // wait for composite command to finish
            ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
            ResultValue resultValue = resultLatch.awaitResult();
            String s = client.command().logs("" + commandResponse.getId()).invoke().get();
            System.out.println(s);
        } finally {
            client.close();
        }
    }
}