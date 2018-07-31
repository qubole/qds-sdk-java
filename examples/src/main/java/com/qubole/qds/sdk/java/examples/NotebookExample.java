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
        String clusterId = System.getProperty("CLUSTER_ID");
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
        QdsClient qdsClient = QdsClientFactory.newClient(configuration);
        try
        {
            
            String notebookdId = testExecuteCreateCloneNotebook(qdsClient, clusterId);
            testExecuteBindNotebook(qdsClient, clusterId, notebookdId);
            String clonedNotebookId = testExecuteCloneNotebook(qdsClient, clusterId, notebookdId);
            testExecuteNotebookRun(qdsClient, notebookdId);  //The execution of the notebook will fail as it is empty notebook
            testExecuteDeleteNotebook(qdsClient, notebookdId);
            testExecuteDeleteNotebook(qdsClient, clonedNotebookId);
        }
        finally {
        qdsClient.close();
        }
    }

    private static String testExecuteCreateCloneNotebook(QdsClient qdsClient, String clusterId) throws Exception
    {
        String name = "note_java_test";
        String location = "Common";
        String noteType = "spark";
        NotebookResult notebookResult = qdsClient.notebook().create(name, location, noteType, clusterId).invoke().get();
        System.out.println("Notebook created with name: "+notebookResult.getNotebook().getName());
        return notebookResult.getId();
    }

    private static String testExecuteCloneNotebook(QdsClient qdsClient, String clusterId, String notebookId) throws Exception
    {
        String name = "cloned_note_java_test";
        String location = "Common";
        NotebookResult clonedNotebookResult = qdsClient.notebook().clone(name, location, clusterId, notebookId).invoke().get();
        System.out.println("Notebook created with name: "+clonedNotebookResult.getNotebook().getName());
        return clonedNotebookResult.getId();
    }
    
    public static void testExecuteBindNotebook(QdsClient qdsClient, String clusterId, String notebookId) throws Exception
    {
        System.out.println("Cluster Id: "+ clusterId);
        System.out.println("Notebook Id: "+ notebookId);
        NotebookResult notebookResult = qdsClient.notebook().bindNotebookToCluster(clusterId, notebookId).invoke().get();
        System.out.println("Result of binding notebook to cluster : "+notebookResult.getSuccess());
    }

    public static void testExecuteDeleteNotebook(QdsClient qdsClient, String notebookId) throws Exception
    {
        NotebookResult notebookResult = qdsClient.notebook().delete(notebookId).invoke().get();
        System.out.println("Result of Deleting notebook: "+notebookResult.getSuccess());
    }

    public static void testExecuteNotebookRun(QdsClient qdsClient, String notebookId) throws Exception
    {
        //Executing the notebook
        String commandType = "SparkCommand";
        String language = "notebook";
        String label = "spark_1_6_1";
        String name = "notebook_run";
        String[] tags = {"1"};
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put("key", "val");
        CommandResponse cmdResponse = qdsClient.command().notebook().command_type(commandType).language(language).notebook_id(notebookId).label(label).name(name).tags(tags).arguments(arguments).invoke().get();
        System.out.println("Command ID  : "+cmdResponse.getId());
    }
}
