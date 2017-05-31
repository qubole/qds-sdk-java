import java.util.HashMap;
import java.util.Map;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.NotebookResult;

public class NotebookExample
{
    public String note_id;
    public static void main(String[] args) throws Exception
    {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient qdsClient = QdsClientFactory.newClient(configuration);
        try
        {
            testExecuteCreateCloneNotebook(qdsClient);
            testExecuteBindNotebook(qdsClient);
            testExecuteNotebookRun(qdsClient);
            testExecuteDeleteNotebook(qdsClient);
        }
        finally {
        qdsClient.close();
        }
    }
    private static void testExecuteCreateCloneNotebook(QdsClient qdsClient) throws Exception
    {
        //Creating a notebook
        String name = "note32";
        String location = "Common";
        String noteType = "spark";
        String clusterId = "1234";
        NotebookResult notebookResult = qdsClient.notebook().create(name, location, noteType, clusterId).invoke().get();
        System.out.println("Notebook created with name: "+notebookResult.getNotebook().getName());
        //Cloning a notebook
        name = "clonednote1";
        String clonedFromNotebook = notebookResult.getNotebook().getNoteId();
        NotebookResult cloneNotebookResult = qdsClient.notebook().clone(name, location, clusterId, clonedFromNotebook).invoke().get();
        System.out.println("Notebook created with name: "+cloneNotebookResult.getNotebook().getName());
    }

    public static void testExecuteBindNotebook(QdsClient qdsClient) throws Exception
    {
        String clusterId = "1234";
        String notebookId = "2345";
        NotebookResult notebookResult = qdsClient.notebook().bindNotebookToCluster(clusterId, notebookId).invoke().get();
        System.out.println("Result of binding notebook to cluster : "+notebookResult.getSuccess());
    }

    public static void testExecuteDeleteNotebook(QdsClient qdsClient) throws Exception
    {
        System.out.println("Test : 6");
        String notebookId = "2345";
        NotebookResult notebookResult = qdsClient.notebook().delete(notebookId).invoke().get();
        System.out.println("Reesult of Deleting notebook: "+notebookResult.getSuccess());
    }

    public static void testExecuteNotebookRun(QdsClient qdsClient) throws Exception
    {
        //Executing the notebook
        String commandType = "SparkCommand";
        String language = "notebook";
        String label = "spark_1_6_1";
        String name = "notebook_run";
        String[] tags = {"1"};
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put("key", "val");
        String notebookId = "890";
        CommandResponse cmdResponse = qdsClient.command().notebook().command_type(commandType).language(language).notebook_id(notebookId).label(label).name(name).tags(tags).arguments(arguments).invoke().get();
        System.out.println("Command ID: "+cmdResponse.getId());
    }
}
