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

import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

import javax.ws.rs.client.InvocationCallback;
import java.util.concurrent.CountDownLatch;

public class AsyncExample {
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));

        final QdsClient client = QdsClientFactory.newClient(configuration);
        final CountDownLatch doneSignal = new CountDownLatch(1);
        InvocationCallback<CommandResponse> callback = new InvocationCallback<CommandResponse>() {
            @Override
            public void completed(CommandResponse cr) {
                System.out.println("Callback Called." +
                        " Command successfully submitted - it returned with command id: " + cr.getId());

                try {
                    ResultLatch resultLatch = new ResultLatch(client, cr.getId());
                    ResultValue resultValue = resultLatch.awaitResult();
                    System.out.println(resultValue.getResults());

                    String s = client.command().logs("" + cr.getId()).invoke().get();
                    System.err.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    client.close();
                    doneSignal.countDown();
                }
            }

            @Override
            public void failed(Throwable throwable) {
                System.out.println("Something bad happened.");
                throwable.printStackTrace();
            }
        };
        client.command().hive().query("show tables").name("qds-sdk-java-callback-test").withCallback(callback).invoke();
        System.out.println("Message to show that command submission doesn't block.");
        doneSignal.await(); // Wait for the callback thread to complete.
    }
}
