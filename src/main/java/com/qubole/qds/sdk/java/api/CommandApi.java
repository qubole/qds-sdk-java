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

import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.Commands;

import javax.ws.rs.core.Response;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/command-api/
 */
public interface CommandApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/view-command-history/
     *
     * @return new builder
     */
    public PageableInvokableBuilder<Commands> history();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-hive-command/
     *
     * @return new builder
     */
    public HiveCommandBuilder hive();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-hadoop-jar-command/
     *
     * @return new builder
     */
    public HadoopCommandBuilder hadoop();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-pig-command/
     *
     * @return new builder
     */
    public PigCommandBuilder pig();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-presto-command-2/
     *
     * @return new builder
     */
    public PrestoCommandBuilder presto();

    /**
     * Corresponds to http://docs.qubole.com/en/latest/quick-start-guide/running-spark-app.html
     *
     * @return new builder
     */
    public SparkCommandBuilder spark();

    /**
     * @return new builder
     */
    public ShellCommandBuilder shell();

    /**
     * @param query the query to be run
     * @param dbTapId the db_tap id where the query will be run
     * @return new builder
     */
    public InvokableBuilder<CommandResponse> dbTapQuery(String query, int dbTapId);

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-import-command/ - simple mode
     *
     * @return new builder
     */
    public DbSimpleImportCommandBuilder dbImportSimple();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-export-command/ - simple mode
     *
     * @return new builder
     */
    public DbSimpleExportCommandBuilder dbExportSimple();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-import-command/ - advanced mode
     *
     * @return new builder
     */
    public DbAdvancedImportCommandBuilder dbImportAdvanced();

    /**
     * Corresponds to http://www.qubole.com/docs/submit-a-db-export-command/ - advanced mode
     *
     * @return new builder
     */
    public DbAdvancedExportCommandBuilder dbExportAdvanced();

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/command_api/submit-a-composite-command.html
     *
     * @return new builder
     */
    public CompositeCommandBuilder composite();

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-status/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<Command> status(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-results/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public ResultsCommandBuilder results(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/view-command-logs/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<String> logs(String queryId);

    /**
     * Corresponds to http://www.qubole.com/docs/cancel-a-command/
     *
     * @param queryId the query id of the command
     * @return new builder
     */
    public InvokableBuilder<Response> cancel(String queryId);
}
