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
package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.CommandResponse;

public interface SparkCommandBuilder extends InvokableBuilder<CommandResponse>
{
    /**
     * Set the Scala, Python, SQL or R code snippet for the SparkCommand.
     * If you have a complete spark-submit command line please use {@link SparkCommandBuilder#sql(String)} method.
     */
    public SparkCommandBuilder program(String program);

    /**
     * For power users, this function provides ability to provide the
     * spark-submit command line directly.
     * Spark-submit command line is explained in detail <a href="http://spark.apache.org/docs/1.2.0/submitting-applications.html">here</a>.
     *
     * Please refer <a href="http://docs.qubole.com/en/latest/rest-api/command_api/submit-a-spark-command.html#example-to-use-command-line-parameter">this</a> for an example.
     */
    public SparkCommandBuilder cmdLine(String cmdLine);

    /**
     * Specify the language of the program, Scala, SQL, Command, R, or Python.
     * Required only when a {@link SparkCommandBuilder#program(String)} is used.
     */
    public SparkCommandBuilder language(String language);

    /**
     * Specify SQL query to be executed by command.
     *
     * Please refer <a href="http://docs.qubole.com/en/latest/rest-api/command_api/submit-a-spark-command.html#example-to-submit-spark-command-in-sql">this</a> for an example.
     */
    public SparkCommandBuilder sql(String sql);

    /**
     * Specify cluster label corresponding to the cluster to be
     * used to run this command.
     */
    public SparkCommandBuilder clusterLabel(String clusterLabel);

    /**
     * Specify a name to the command. It can be useful in filtering
     * command from command history.
     */
    public SparkCommandBuilder name(String commandName);

    /**
     * Specify the arguments that the user program takes in.
     *
     * Please refer <a href="http://docs.qubole.com/en/latest/rest-api/command_api/submit-a-spark-command.html#example-to-add-arguments-to-user-program">this</a> for an example.
     */
    public SparkCommandBuilder userProgramArguments(String userProgramArguments);

    /**
     * Specify the spark specific command line options which are passed on to spark-submit.
     */
    public SparkCommandBuilder arguments(String arguments);

    /**
     * Specify a list of tags for the command so that it is easily identifiable and searchable
     * from the commands list in the Commands History.
     */
    public SparkCommandBuilder tags(String[] queryTags);
}
