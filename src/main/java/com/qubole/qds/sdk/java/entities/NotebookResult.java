package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class NotebookResult
{
    private Notebook notebook;
    public String success;
    public String message;
    public String partialSuccess;
    public String id;

    public NotebookResult()
    {
    }

    public NotebookResult(String success, String id, Notebook notebook, String message, String partialSuccess)
    {
        this.notebook = notebook;
        this.success = success;
        this.message = message;
        this.partialSuccess = partialSuccess;
        this.id = id;
    }

    public String getSuccess()
    {
        return this.success;
    }

    public void setSuccess(String success)
    {
        this.success = success;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPartialSuccess()
    {
        return this.partialSuccess;
    }

    public void setPartialSuccess(String partialSuccess)
    {
        this.partialSuccess     = partialSuccess;
    }

    public Notebook getNotebook()
    {
        return this.notebook;
    }

    public void setNotebook(Notebook notebook)
    {
        this.notebook = notebook;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
