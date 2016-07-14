package com.qubole.qds.sdk.java.unittests;

import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazonaws.util.json.JSONObject;
import com.google.common.base.Joiner;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;

public class TestCommands
{
    QdsConfiguration configuration;
    QdsClient qdsClient;
    ObjectMapper mapper;
    
    @BeforeClass
    public void setup()
    {
        mapper = new ObjectMapper();
        configuration = new DefaultQdsConfiguration("https://api.qubole.com/api","apiToken");
        qdsClient = QdsClientFactory.newClient(configuration);
    }
    
    @Test
    public void testHiveQueryCommand() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hive().query("show tables;").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HiveCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("query", "show tables;");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testHiveS3Command() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hive().scriptLocation("s3://testhive/hivecommand").clusterLabel("nondefault").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HiveCommand");
        expectedRequestData.put("label", "nondefault");
        expectedRequestData.put("script_location", "s3://testhive/hivecommand");
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
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.STREAMING).sub_command_args("-files s3n://testhadoop/mapper.py,s3n://testhadoop/reducer.py -mapper mapper.py -reducer reducer.py numReduceTasks 1 -input s3n://testfiles/input -output /testhadoop/results").clusterLabel("default").getArgumentsInvocation();
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "HadoopCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("sub_command", "streaming");
        expectedRequestData.put("sub_command_args", "-files s3n://testhadoop/mapper.py,s3n://testhadoop/reducer.py -mapper mapper.py -reducer reducer.py numReduceTasks 1 -input s3n://testfiles/input -output /testhadoop/results");
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
    
    @Test
    public void testPigCommandLatinStatement() throws Exception
    {
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().pig().latin_statements("A=LOAD \"s3://testpig/pig.log\";dump A").clusterLabel("default").getArgumentsInvocation(); 
        JSONObject expectedRequestData=new JSONObject();
        expectedRequestData.put("command_type", "PigCommand");
        expectedRequestData.put("label", "default");
        expectedRequestData.put("latin_statements", "A=LOAD \"s3://testpig/pig.log\";dump A");
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
    
    public void assertRequestDetails(InvokeArguments<?> invokeargs, String expectedRequestType, String expectedEndpoint, JSONObject expectedRequestData, Map<Object, Object> expectedQueryParams, Class<?> expectedResponseClassType) throws Exception
    {
        Assert.assertEquals(invokeargs.getEntity().getMethod().name(), expectedRequestType, "Incorrect request type. Expected : "+expectedRequestType+" , got from request : "+invokeargs.getEntity().getMethod().name());
        Assert.assertEquals(Joiner.on("/").join(invokeargs.getAdditionalPaths()), expectedEndpoint, "Incorrect endpoint. Expected : "+expectedEndpoint+" , got from request : "+Joiner.on("/").join(invokeargs.getAdditionalPaths()));
        Assert.assertTrue(expectedResponseClassType.isInstance(invokeargs.getResponseType().newInstance()), "Expected rsponse type was : " + expectedResponseClassType.getSimpleName() + " , but it is of type : " + invokeargs.getResponseType().getSimpleName());

        if (expectedRequestData != null)
        {
            Assert.assertNotNull(invokeargs.getEntity().getEntity(), "Request data is null. Expected was : " + expectedRequestData);
            Assert.assertTrue(mapper.readTree(invokeargs.getEntity().getEntity().toString()).equals(mapper.readTree(expectedRequestData.toString())), "Incorrect request data. Expected was : " + expectedRequestData + " , got from request : " + invokeargs.getEntity().getEntity().toString());
        }
        else
        {
            Assert.assertNull(invokeargs.getEntity().getEntity(), "Request data expected was null. But it is : " + invokeargs.getEntity().getEntity().toString());
        }
        
        if (expectedQueryParams != null)
        {
            Assert.assertNotNull(invokeargs.getEntity().getQueryParams(), "Query params expected was not null. But it is null");
            Assert.assertTrue(invokeargs.getEntity().getQueryParams().equals(expectedQueryParams));
        }
        else
        {
            Assert.assertNull(invokeargs.getEntity().getQueryParams(), "Query params expected was null. But it is not null");
        }
    }
}