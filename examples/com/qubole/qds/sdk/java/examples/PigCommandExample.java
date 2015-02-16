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

import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

public class PigCommandExample {
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));

        QdsClient client = QdsClientFactory.newClient(configuration);
        try {
            PigCommandBuilder pigBuilder = client.command().pig();

            // Give a name to the command. (Optional)
            pigBuilder.name("pig-test");

            // Run this command on a non-default cluster.
            // This cluster label must exist otherwise the API call will fail.
            pigBuilder.clusterLabel("custom_label");

            //Using script location. You can give pig latin statements as well.
            pigBuilder.script_location("s3://paid-qubole/PigAPIDemo/scripts/script1-hadoop-s3-small.pig");

            CommandResponse commandResponse = pigBuilder.invoke().get();
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
