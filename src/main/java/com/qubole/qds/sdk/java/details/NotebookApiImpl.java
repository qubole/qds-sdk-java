package com.qubole.qds.sdk.java.details;

import java.util.HashMap;
import java.util.Map;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.NotebookAPI;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.NotebookResult;

public class NotebookApiImpl implements NotebookAPI
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<NotebookResult> create(String name, String location, String noteType, String clusterId)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (noteType != null) {
            params.put("note_type", noteType);
        }
        if (clusterId != null) {
            params.put("cluster_id", clusterId);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.POST, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<NotebookResult>(client, requestDetails, NotebookResult.class, "notebooks");
    }

    @Override
    public InvokableBuilder<NotebookResult> configure(String name, String location, String clusterId, String notebookId)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (clusterId != null) {
            params.put("cluster_id", clusterId);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<NotebookResult>(client, requestDetails, NotebookResult.class, "notebooks", notebookId);
    }

    @Override
    public InvokableBuilder<NotebookResult> clone(String name, String location, String clusterId, String clonedFromNotebook)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (clusterId != null) {
            params.put("cluster_id", clusterId);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<NotebookResult>(client, requestDetails, NotebookResult.class, "notebooks", clonedFromNotebook, "clone");
    }

    @Override
    public InvokableBuilder<NotebookResult> bindNotebookToCluster(String clusterId, String notebookId)
    {
        Map<String, String> params = new HashMap();
        if (clusterId != null) {
            params.put("cluster_id", clusterId);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<NotebookResult>(client, requestDetails, NotebookResult.class, "notebooks", notebookId);
    }

    @Override
    public InvokableBuilder<NotebookResult> delete(String notebookId)
    {
        RequestDetails requestDetails = new RequestDetails(null, RequestDetails.Method.DELETE, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<NotebookResult>(client, requestDetails, NotebookResult.class, "notebooks", notebookId);
    }

    NotebookApiImpl(QdsClient client)
    {
        this.client = client;
    }

}
