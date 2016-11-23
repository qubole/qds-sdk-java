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
package com.qubole.qds.sdk.java.unittests;

import com.amazonaws.util.json.JSONArray;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;

import java.util.Arrays;
import java.util.Collections;

public class TestCommands extends AbstractTest
{
    @Test
    public void testHiveQueryCommand() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hive().query("show tables;").name("myName").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HiveCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("query", "show tables;");
        expectedRequestData.put("name", "myName");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testHiveS3Command() throws Exception
    {

        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hive().tags(new String[]{"tag1","tag2"}).scriptLocation("s3://testhive/hivecommand").clusterLabel("nondefault").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HiveCommand");
        expectedRequestData.put("label", "nondefault");
        expectedRequestData.put("script_location", "s3://testhive/hivecommand");
        expectedRequestData.put("tags", Arrays.asList("tag1","tag2") );
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData,  null, CommandResponse.class);
    }
    
    @Test
    public void testHadoopCommandJAR() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.JAR).sub_command_args("s3n://testfiles/input.jar -mapper wc -numReduceTasks 0 -input s3n://testfiles/input -output s3://testhadoop/results").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HadoopCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("sub_command", "jar");
        expectedRequestData.put("sub_command_args", "s3n://testfiles/input.jar -mapper wc -numReduceTasks 0 -input s3n://testfiles/input -output s3://testhadoop/results");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData,  null, CommandResponse.class);
    }
    
    @Test
    public void testHadoopCommandS3DistCP() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.S3DISTCP).sub_command_args("--src s3://testhadoop/source --dest /testhadoop/destination").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HadoopCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("sub_command", "s3distcp");
        expectedRequestData.put("sub_command_args", "--src s3://testhadoop/source --dest /testhadoop/destination");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testHadoopCommandStreaming() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hadoop().name("SpecialName").sub_command(HadoopCommandBuilder.SubCommandType.STREAMING).sub_command_args("-files s3n://testhadoop/mapper.py,s3n://testhadoop/reducer.py -mapper mapper.py -reducer reducer.py numReduceTasks 1 -input s3n://testfiles/input -output /testhadoop/results").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HadoopCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("sub_command", "streaming");
        expectedRequestData.put("name", "SpecialName");
        expectedRequestData.put("sub_command_args", "-files s3n://testhadoop/mapper.py,s3n://testhadoop/reducer.py -mapper mapper.py -reducer reducer.py numReduceTasks 1 -input s3n://testfiles/input -output /testhadoop/results");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testPigCommandLatinStatement() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().pig().latin_statements("A=LOAD 's3://testpig/pig.log';dump A").clusterLabel("default").getArgumentsInvocation(); 
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "PigCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("latin_statements", "A=LOAD 's3://testpig/pig.log';dump A");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testPigCommandPigScript() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().pig().script_location("s3://testpig/script").clusterLabel("default").getArgumentsInvocation();   
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "PigCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("script_location", "s3://testpig/script");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }

    @Test
    public void testDbSimpleImportCommand() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().dbImportSimple().hive_table("test").hive_serde("orc").dbtap_id("1").db_table("test").db_parallelism("1").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "DbImportCommand");
        expectedRequestData.put("mode", 1);
        expectedRequestData.put("hive_table", "test");
        expectedRequestData.put("hive_serde", "orc");
        expectedRequestData.put("dbtap_id", "1");
        expectedRequestData.put("db_table", "test");
        expectedRequestData.put("db_parallelism", "1");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
}
