package com.qubole.qds.sdk.java.details;

import java.util.HashMap;
import java.util.Map;

import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.api.NotebookAPI;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Notebook;

public class NotebookApiImpl implements NotebookAPI
{
    private final QdsClient client;

    @Override
    public InvokableBuilder<Notebook> create(String name, String location, String note_type, String cluster_id)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (note_type != null) {
            params.put("note_type", note_type);
        }
        if (cluster_id != null) {
            params.put("cluster_id", cluster_id);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.POST, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<Notebook>(client, requestDetails, Notebook.class, "notebooks");
    }

    @Override
    public InvokableBuilder<Notebook> configure(String name, String location, String cluster_id, String notebook_id)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (cluster_id != null) {
            params.put("cluster_id", cluster_id);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<Notebook>(client, requestDetails, Notebook.class, "notebooks", notebook_id);
    }

    @Override
    public InvokableBuilder<Notebook> clone(String name, String location, String cluster_id, String cloned_from_notebook)
    {
        Map<String, String> params = new HashMap();
        if (name != null) {
            params.put("name", name);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (cluster_id != null) {
            params.put("cluster_id", cluster_id);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<Notebook>(client, requestDetails, Notebook.class, "notebooks", cloned_from_notebook, "clone");
    }

    @Override
    public InvokableBuilder<Notebook> bind_notebook_to_cluster(String cluster_id, String notebook_id)
    {
        Map<String, String> params = new HashMap();
        if (cluster_id != null) {
            params.put("cluster_id", cluster_id);
        }
        RequestDetails requestDetails = new RequestDetails(params, RequestDetails.Method.PUT, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<Notebook>(client, requestDetails, Notebook.class, "notebooks", notebook_id);
    }

    @Override
    public InvokableBuilder<Notebook> delete(String notebook_id)
    {
        RequestDetails requestDetails = new RequestDetails(null, RequestDetails.Method.DELETE, null);
        requestDetails.allowToBeRetried();
        return new GenericInvokableBuilderImpl<Notebook>(client, requestDetails, Notebook.class, "notebooks", notebook_id);
    }

    NotebookApiImpl(QdsClient client)
    {
        this.client = client;
    }

}
