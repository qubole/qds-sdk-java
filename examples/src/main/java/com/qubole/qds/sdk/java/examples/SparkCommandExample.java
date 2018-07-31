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

import com.qubole.qds.sdk.java.api.SparkCommandBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;

import java.lang.Exception;
import java.lang.String;
import java.lang.System;

public class SparkCommandExample {
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try {
            submitScalaProgram(client);
            submitSQLQuery(client);
            submitSparkSubmitCommandLine(client);
            submitPythonProgramWithArguments(client);
        } finally {
            client.close();
        }
    }

    /**
     * An Example of submitting Spark Command as a Scala program.
     * Similarly, we can submit Spark Command as a SQL query, R program
     * and Java program.
     */
    private static void submitScalaProgram(QdsClient client) throws Exception {
        String sampleProgram = "println(\"hello world\")";

        SparkCommandBuilder sparkBuilder = client.command().spark();

        // Give a name to the command. (Optional)
        sparkBuilder.name("spark-scala-test");

        //Setting the program here
        sparkBuilder.program(sampleProgram);

        //setting the language here
        sparkBuilder.language("scala");

        CommandResponse commandResponse = sparkBuilder.invoke().get();
        ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
        ResultValue resultValue = resultLatch.awaitResult();
        System.out.println(resultValue.getResults());

        String s = client.command().logs("" + commandResponse.getId()).invoke().get();
        System.err.println(s);
    }

    /**
     * An example of submitting Spark Command as a SQL query.
     */
    private static void submitSQLQuery(QdsClient client) throws Exception {
        String sampleSqlQuery =
            "select * from default_qubole_airline_origin_destination limit 100";

        SparkCommandBuilder sparkBuilder = client.command().spark();

        // Give a name to the command. (Optional)
        sparkBuilder.name("spark-sql-test");

        // Setting the sql query
        sparkBuilder.sql(sampleSqlQuery);

        CommandResponse commandResponse = sparkBuilder.invoke().get();
        ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
        ResultValue resultValue = resultLatch.awaitResult();
        System.out.println(resultValue.getResults());

        String s = client.command().logs("" + commandResponse.getId()).invoke().get();
        System.err.println(s);
    }

    /**
     * Example of submitting spark submit command line.
     */
    private static void submitSparkSubmitCommandLine(QdsClient client) throws Exception {
        String sampleSparkSubmitCommand = "/usr/lib/spark/bin/spark-submit "
            + "--class org.apache.spark.examples.SparkPi "
            + "--master yarn-client /usr/lib/spark/spark-examples-*";

        SparkCommandBuilder sparkBuilder = client.command().spark();

        // Give a name to the command. (Optional)
        sparkBuilder.name("spark-submit-test");

        // Setting the command line
        sparkBuilder.cmdLine(sampleSparkSubmitCommand);

        // Setting language to command_line
        sparkBuilder.language("command_line");

        CommandResponse commandResponse = sparkBuilder.invoke().get();
        ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
        ResultValue resultValue = resultLatch.awaitResult();
        System.out.println(resultValue.getResults());

        String s = client.command().logs("" + commandResponse.getId()).invoke().get();
        System.err.println(s);
    }

    /**
     * Example of submitting python program with arguments to spark submit
     * and user program
     */
    private static void submitPythonProgramWithArguments(QdsClient client) throws Exception {
        String samplePythonProgram =
            "import org.apache.spark._\n" +
            "object testprogram {\n" +
            "  def main(args: Array[String]) {\n" +
            "      var sc = new SparkContext(new SparkConf())\n" +
            "      var fileToRead = args(0)//passed as args in user program\n" +
            "      var fileToWrite = args(1)\n" +
            "      var output = sc.textFile(fileToRead).saveAsTextFile(fileToWrite)\n" +
            "      println(output)\n" +
            "  }\n" +
            "}";

        SparkCommandBuilder sparkBuilder = client.command().spark();

        // Give a name to the command. (Optional)
        sparkBuilder.name("spark-python-test");

        // Setting the python program
        sparkBuilder.program(samplePythonProgram);

        // Setting language to command_line
        sparkBuilder.language("python");

        // Setting the spark submit arguments
        sparkBuilder.arguments("--num-executors 2 --max-executors 10 --executor-memory 5G --executor-cores 2");

        // Setting the arguments to the User Program
        sparkBuilder.arguments("s3://bucket/path/to/source s3://bucket/path/to/destination");

        CommandResponse commandResponse = sparkBuilder.invoke().get();
        ResultLatch resultLatch = new ResultLatch(client, commandResponse.getId());
        ResultValue resultValue = resultLatch.awaitResult();
        System.out.println(resultValue.getResults());

        String s = client.command().logs("" + commandResponse.getId()).invoke().get();
        System.err.println(s);
    }
}
