package com.qubole.qds.sdk.java.mocktests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;
import static org.mockito.Mockito.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TestCommands
{
    QdsClient qdsClient = mock(QdsClient.class);
    CommandApi commandApi = mock(CommandApi.class);
    Future future = mock(Future.class);
    ResultLatch resultLatch = mock(ResultLatch.class);
    ResultValue resultValue = mock(ResultValue.class);
    InvokableBuilder invokableBuilder = mock(InvokableBuilder.class);
    HiveCommandBuilder hiveCommandBuilder = mock(HiveCommandBuilder.class, new SelfReturningAnswer());
    HadoopCommandBuilder hadoopCommandBuilder = mock(HadoopCommandBuilder.class, new SelfReturningAnswer());
    PigCommandBuilder pigCommandBuilder = mock(PigCommandBuilder.class, new SelfReturningAnswer());
    
    String LOGS = "Sample logs of the command run";
    
    @BeforeClass
    public void setup() throws Exception
    {   
        when(qdsClient.command()).thenReturn(commandApi);
        when(commandApi.hive()).thenReturn(hiveCommandBuilder);
        when(commandApi.hadoop()).thenReturn(hadoopCommandBuilder);
        when(commandApi.pig()).thenReturn(pigCommandBuilder);
        when(commandApi.logs(anyString())).thenReturn(invokableBuilder);
        when(invokableBuilder.invoke()).thenReturn(future);
        when(hiveCommandBuilder.invoke()).thenReturn(future);
        when(hadoopCommandBuilder.invoke()).thenReturn(future);
        when(pigCommandBuilder.invoke()).thenReturn(future);
    }
    
    @Test
    public void testHiveCommandQuery() throws Exception
    {
        CommandResponse expectedResponse = createResponse("HiveCommand");
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().hive().query("show tables;").clusterLabel("default").invoke().get();
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "table1\ntable2", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testHiveCommandS3Path() throws Exception
    {
        CommandResponse expectedResponse = createResponse("HiveCommand");
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().hive().scriptLocation("s3://testhive/hivecommand").clusterLabel("default").invoke().get();
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "table1\ntable2", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testHadoopCommandJAR() throws Exception
    {
        CommandResponse expectedResponse = createResponse("HadoopCommand"); 
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.JAR).sub_command_args("s3n://testfiles/input.jar -mapper wc -numReduceTasks 0 -input s3n://testfiles/input -output s3://testhadoop/results").clusterLabel("default").invoke().get();
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "123\n234", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testHadoopCommandS3DistCP() throws Exception
    {
        CommandResponse expectedResponse = createResponse("HadoopCommand"); 
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.S3DISTCP).sub_command_args("--src s3://testhadoop/source --dest /testhadoop/destination").clusterLabel("default").invoke().get();
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "123\n234", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testHadoopCommandStreaming() throws Exception
    {
        CommandResponse expectedResponse = createResponse("HadoopCommand"); 
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().hadoop().sub_command(HadoopCommandBuilder.SubCommandType.STREAMING).sub_command_args("-files s3n://testhadoop/mapper.py,s3n://testhadoop/reducer.py -mapper mapper.py -reducer reducer.py numReduceTasks 1 -input s3n://testfiles/input -output /testhadoop/results").clusterLabel("default").invoke().get();
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "123\n234", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testPigCommandLatinStatement() throws Exception
    {
        CommandResponse expectedResponse = createResponse("PigCommand"); 
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().pig().latin_statements("A=LOAD \"s3://testpig/pig.log\";dump A").clusterLabel("default").invoke().get(); 
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "abc\n456", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    @Test
    public void testPigCommandPigScript() throws Exception
    {
        CommandResponse expectedResponse = createResponse("PigCommand"); 
        when(future.get()).thenReturn(expectedResponse);
        CommandResponse actualResponse = qdsClient.command().pig().script_location("s3://testpig/script").clusterLabel("default").invoke().get();   
        compareCommandResponse(expectedResponse, actualResponse);
        
        ResultValue expectedResult = new ResultValue(true, "abc\n456", null);
        checkResults(String.valueOf(actualResponse.getId()), expectedResult);
        checkLogs(String.valueOf(actualResponse.getId()));
    }
    
    public void checkResults(String commandID, ResultValue expectedResult) throws Exception
    {
        when(resultLatch.awaitResult(anyLong(), any(TimeUnit.class))).thenReturn(expectedResult);
        ResultValue actualResult = resultLatch.awaitResult(10, TimeUnit.SECONDS);
        if (expectedResult.getResults()!=null)
            Assert.assertTrue(expectedResult.getResults().equals(actualResult.getResults()));
        if (expectedResult.getResult_location()!=null)
            Assert.assertTrue(expectedResult.getResult_location().equals(actualResult.getResult_location()));
    }
    
    public void checkLogs(String commandID) throws Exception
    {
        when(future.get()).thenReturn(LOGS);
        String logsFetched = qdsClient.command().logs(commandID).invoke().get();
        Assert.assertTrue(logsFetched.equalsIgnoreCase(LOGS));
    }
    
    public CommandResponse createResponse(String type)
    {
        CommandResponse expectedResponse=new CommandResponse();
        expectedResponse.setCommand_type(type);
        expectedResponse.setId(12345);
        expectedResponse.setLabel("default");
        expectedResponse.setStatus("waiting");
        expectedResponse.setProgress(0);
        expectedResponse.setMeta_data(ImmutableMap.of("results_resource", "commands/12345/results", "logs_resource", "commands/12345/logs"));
        expectedResponse.setCreated_at(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime()));
        return expectedResponse;
    }
    
    public void compareCommandResponse(CommandResponse expectedResponse, CommandResponse actualResponse)
    {
        if (actualResponse.getCommand_type()!=null) 
            Assert.assertTrue(actualResponse.getCommand_type().equals(expectedResponse.getCommand_type()));
        if (actualResponse.getCreated_at()!=null) 
            Assert.assertTrue(actualResponse.getCreated_at().equals(expectedResponse.getCreated_at()));
        if (actualResponse.getEnd_time()!=null) 
            Assert.assertTrue(actualResponse.getEnd_time().equals(expectedResponse.getEnd_time()));
        if (actualResponse.getLabel()!=null) 
            Assert.assertTrue(actualResponse.getLabel().equals(expectedResponse.getLabel()));
        if (actualResponse.getNominal_time()!=null) 
            Assert.assertTrue(actualResponse.getNominal_time().equals(expectedResponse.getNominal_time()));
        if (actualResponse.getPath()!=null) 
            Assert.assertTrue(actualResponse.getPath().equals(expectedResponse.getPath()));
        if (actualResponse.getPool()!=null) 
            Assert.assertTrue(actualResponse.getPool().equals(expectedResponse.getPool()));
        if (actualResponse.getQlog()!=null) 
            Assert.assertTrue(actualResponse.getQlog().equals(expectedResponse.getQlog()));
        if (actualResponse.getSequence_id()!=null) 
            Assert.assertTrue(actualResponse.getSequence_id().equals(expectedResponse.getSequence_id()));
        if (actualResponse.getStart_time()!=null) 
            Assert.assertTrue(actualResponse.getStart_time().equals(expectedResponse.getStart_time()));
        if (actualResponse.getStatus()!=null) 
            Assert.assertTrue(actualResponse.getStatus().equals(expectedResponse.getStatus()));
        if (actualResponse.getSubmit_time()!=null) 
            Assert.assertTrue(actualResponse.getSubmit_time().equals(expectedResponse.getSubmit_time()));
        if (actualResponse.getTemplate()!=null) 
            Assert.assertTrue(actualResponse.getTemplate().equals(expectedResponse.getTemplate()));
        if (actualResponse.getMeta_data()!=null)
            Assert.assertTrue(actualResponse.getMeta_data().equals(expectedResponse.getMeta_data()));
        if (actualResponse.getResolved_macros()!=null)
            Assert.assertTrue(actualResponse.getResolved_macros().equals(expectedResponse.getResolved_macros()));
        Assert.assertTrue(actualResponse.getTimeout()==expectedResponse.getTimeout());
        Assert.assertTrue(actualResponse.getUser_id()==expectedResponse.getUser_id());
        Assert.assertTrue(actualResponse.getNum_result_dir()==expectedResponse.getNum_result_dir());
        Assert.assertTrue(actualResponse.getId()==expectedResponse.getId());
        Assert.assertTrue(actualResponse.getPid()==expectedResponse.getPid());
        Assert.assertTrue(actualResponse.getProgress()==expectedResponse.getProgress());
        Assert.assertTrue(actualResponse.getQbol_session_id()==expectedResponse.getQbol_session_id());
        Assert.assertTrue(actualResponse.getCommand()==expectedResponse.getCommand());
    }
    
    public class SelfReturningAnswer implements Answer<Object>
    {
        public Object answer(InvocationOnMock invocation) throws Throwable 
        {
            Object mock = invocation.getMock();
            if (invocation.getMethod().getReturnType().isInstance(mock))
            {
                return mock;
            }
            else
            {
                return RETURNS_DEFAULTS.answer(invocation);
            }
        }
    }
}
