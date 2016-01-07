package com.qubole.qds.sdk.java.mocktests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.google.common.collect.ImmutableMap;
import com.qubole.qds.sdk.java.api.CommandApi;
import com.qubole.qds.sdk.java.api.HadoopCommandBuilder;
import com.qubole.qds.sdk.java.api.HiveCommandBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.PigCommandBuilder;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.ResultValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@SuppressWarnings({ "unchecked", "rawtypes" })
@RunWith(PowerMockRunner.class)
@PrepareForTest({ResultLatch.class, QdsClientFactory.class})
public class TestCommands
{
    // Define all mock classes
    static DefaultQdsConfiguration configurationMocked = mock(DefaultQdsConfiguration.class);
    static QdsClient qdsClientMocked = mock(QdsClient.class);
    static CommandApi commandApi = mock(CommandApi.class);
    static Future future = mock(Future.class);
    static ResultLatch resultLatch = mock(ResultLatch.class);
    static ResultValue resultValue = mock(ResultValue.class);
    static InvokableBuilder invokableBuilder = mock(InvokableBuilder.class);
    static HiveCommandBuilder hiveCommandBuilder = mock(HiveCommandBuilder.class, new SelfReturningAnswer());
    static HadoopCommandBuilder hadoopCommandBuilder = mock(HadoopCommandBuilder.class, new SelfReturningAnswer());
    static PigCommandBuilder pigCommandBuilder = mock(PigCommandBuilder.class, new SelfReturningAnswer());
    
    static DefaultQdsConfiguration configuration;
    static QdsClient qdsClient;
    
    // These sample Logs are returned for any command run 
    String LOGS = "Command completed successfully";
    
    @BeforeClass
    public static void setup() throws Exception
    {   
        // Setting up the QdsClient class with mocked classes which will be used across the test suite.
        PowerMockito.whenNew(DefaultQdsConfiguration.class).withArguments(Mockito.any(String.class), Mockito.any(String.class)).thenReturn(configurationMocked);
        PowerMockito.mockStatic(QdsClientFactory.class);
        BDDMockito.given(QdsClientFactory.newClient(Mockito.any(QdsConfiguration.class))).willReturn(qdsClientMocked);
        
        configuration = new DefaultQdsConfiguration("http://api.qubole.net/api","xxYYzz@pwqxxYYzz@pwqxxYYzz@pwqxxYYzz@pwq");
        qdsClient = QdsClientFactory.newClient(configuration);
        
        // Setting up mocked responses for function calls with different mocked classes
        when(qdsClient.command()).thenReturn(commandApi);
        when(commandApi.hive()).thenReturn(hiveCommandBuilder);
        when(commandApi.hadoop()).thenReturn(hadoopCommandBuilder);
        when(commandApi.pig()).thenReturn(pigCommandBuilder);
        when(commandApi.logs(Mockito.anyString())).thenReturn(invokableBuilder);
        when(invokableBuilder.invoke()).thenReturn(future);
        when(hiveCommandBuilder.invoke()).thenReturn(future);
        when(hadoopCommandBuilder.invoke()).thenReturn(future);
        when(pigCommandBuilder.invoke()).thenReturn(future);
    }
    
    /* testHiveCommandQuery()
     * Create a mocked response that will be returned on running a query.
     * Then compare the actual and expected responses.
     * Finally the mocked results and logs are verified.
     */
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
    
    /**
     * @param sample command id for which results are to be verified
     * @param expected result value to compare against
     */
    public void checkResults(String commandID, ResultValue expectedResult) throws Exception
    {   
        // Creates a new result latch and mocks the awaitResult function to return the expectedResult
        when(resultLatch.awaitResult(Mockito.anyLong(), Mockito.any(TimeUnit.class))).thenReturn(expectedResult);
        PowerMockito.whenNew(ResultLatch.class).withArguments(Mockito.any(QdsClient.class), Mockito.any(String.class)).thenReturn(resultLatch);
        ResultLatch latch=new ResultLatch(qdsClient, commandID);
        ResultValue actualResult = latch.awaitResult(10, TimeUnit.SECONDS);
        if (expectedResult.getResults()!=null)
            Assert.assertTrue(expectedResult.getResults().equals(actualResult.getResults()));
        if (expectedResult.getResult_location()!=null)
            Assert.assertTrue(expectedResult.getResult_location().equals(actualResult.getResult_location()));
    }
    
    /**
     * @param commandID command id for which logs are to be verified
     */
    public void checkLogs(String commandID) throws Exception
    {
        // Mocks the return logs function from qdsclient and returns the sample LOGS defined at class level
        when(future.get()).thenReturn(LOGS);
        String logsFetched = qdsClient.command().logs(commandID).invoke().get();
        Assert.assertTrue(logsFetched.equalsIgnoreCase(LOGS));
    }
    
    /**
     * @param type type of command eg PigCommand, HiveCommand
     */
    public CommandResponse createResponse(String type)
    {
        // Creates a sample response with specific fields for a command type
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
    
    /**
     * @param expectedResponse expected reponse object
     * @param actualResponse actual reponse against which will be validated against expectedResponse
     */
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
    
    /* SelfReturningAnswer
     * This is used for builder objects to return the calling mocked class to construct an object
     */
    public static class SelfReturningAnswer implements Answer<Object>
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
                return Mockito.RETURNS_DEFAULTS.answer(invocation);
            }
        }
    }
}
