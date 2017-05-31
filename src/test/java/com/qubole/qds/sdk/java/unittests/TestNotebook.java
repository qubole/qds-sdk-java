package com.qubole.qds.sdk.java.unittests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.amazonaws.util.json.JSONObject;
import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.CommandResponse;
import com.qubole.qds.sdk.java.entities.Notebook;
import com.qubole.qds.sdk.java.entities.NotebookResult;

public class TestNotebook extends AbstractTest
{
    @Test
    public void testCreateNotebook() throws Exception
    {
        String name = "note1";
        String location = "Users/test@example.com";
        String note_type = "spark";
        String cluster_id = "123";
        InvokeArguments<NotebookResult> invokeargs = qdsClient.notebook().create(name, location, note_type, cluster_id).getArgumentsInvocation();
        JSONObject expectedRequestData = new JSONObject();
        expectedRequestData.put("name", name);
        expectedRequestData.put("location", location);
        expectedRequestData.put("note_type", note_type);
        expectedRequestData.put("cluster_id", cluster_id);
        assertRequestDetails(invokeargs, "POST", "notebooks", expectedRequestData, null, NotebookResult.class);
    }
    
    @Test
    public void testCloneNotebook() throws Exception
    {
        String name = "note1";
        String location = "Users/test@example.com";
        String cluster_id = "123";
        String cloned_from_notebook = "234";
        InvokeArguments<NotebookResult> invokeargs = qdsClient.notebook().clone(name, location, cluster_id, cloned_from_notebook).getArgumentsInvocation();
        JSONObject expectedRequestData = new JSONObject();
        expectedRequestData.put("name", name);
        expectedRequestData.put("location", location);
        expectedRequestData.put("cluster_id", cluster_id);
        assertRequestDetails(invokeargs, "PUT", "notebooks/"+cloned_from_notebook+"/clone", expectedRequestData, null, NotebookResult.class);
    }
    
    @Test
    public void testBindNotebookToCluster() throws Exception
    {
        String cluster_id = "123";
        String notebook_id = "234";
        InvokeArguments<NotebookResult> invokeargs = qdsClient.notebook().bindNotebookToCluster(cluster_id, notebook_id).getArgumentsInvocation();
        JSONObject expectedRequestData = new JSONObject();
        expectedRequestData.put("cluster_id", cluster_id);
        assertRequestDetails(invokeargs, "PUT", "notebooks/"+notebook_id, expectedRequestData, null, NotebookResult.class);
    }
    
    @Test
    public void testDeleteNotebook() throws Exception
    {
        String notebook_id = "234";
        InvokeArguments<NotebookResult> invokeargs = qdsClient.notebook().delete(notebook_id).getArgumentsInvocation();
        assertRequestDetails(invokeargs, "DELETE", "notebooks/"+notebook_id, null, null, NotebookResult.class);
    }

    @Test
    public void testNotebookRun() throws Exception
    {
        String command_type = "SparkCommand";
        String language = "notebook";
        String label = "label";
        String name = "note";
        String[] tags = {"1", "2"};
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put("key", "val");
        String notebook_id = "234";
        InvokeArguments<CommandResponse> invokeargs = qdsClient.command().notebook().command_type(command_type).language(language).notebook_id(notebook_id).label(label).name(name).tags(tags).arguments(arguments).getArgumentsInvocation();
        JSONObject expectedRequestData = new JSONObject();
        expectedRequestData.put("command_type", command_type);
        expectedRequestData.put("label", label);
        expectedRequestData.put("language", language);
        expectedRequestData.put("name", name);
        expectedRequestData.put("tags", tags);
        expectedRequestData.put("arguments", arguments);
        expectedRequestData.put("note_id", notebook_id);
        assertRequestDetails(invokeargs, "POST", "commands", expectedRequestData, null, CommandResponse.class);
    }
}
