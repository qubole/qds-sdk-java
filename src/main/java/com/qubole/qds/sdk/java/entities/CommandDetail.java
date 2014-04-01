package com.qubole.qds.sdk.java.entities;

public class CommandDetail
{
    private String parameters;
    private String inline;
    private String archives;
    private String script_location;
    private String files;
    private String latin_statements;
    private String approx_mode;
    private String loader_stable;

    public CommandDetail()
    {
    }

    public CommandDetail(String parameters, String inline, String archives, String script_location, String files, String latin_statements, String approx_mode, String loader_stable)
    {
        this.parameters = parameters;
        this.inline = inline;
        this.archives = archives;
        this.script_location = script_location;
        this.files = files;
        this.latin_statements = latin_statements;
        this.approx_mode = approx_mode;
        this.loader_stable = loader_stable;
    }

    public String getLoader_stable()
    {
        return loader_stable;
    }

    public void setLoader_stable(String loader_stable)
    {
        this.loader_stable = loader_stable;
    }

    public String getApprox_mode()
    {
        return approx_mode;
    }

    public void setApprox_mode(String approx_mode)
    {
        this.approx_mode = approx_mode;
    }

    public String getLatin_statements()
    {
        return latin_statements;
    }

    public void setLatin_statements(String latin_statements)
    {
        this.latin_statements = latin_statements;
    }

    public String getParameters()
    {
        return parameters;
    }

    public void setParameters(String parameters)
    {
        this.parameters = parameters;
    }

    public String getInline()
    {
        return inline;
    }

    public void setInline(String inline)
    {
        this.inline = inline;
    }

    public String getArchives()
    {
        return archives;
    }

    public void setArchives(String archives)
    {
        this.archives = archives;
    }

    public String getScript_location()
    {
        return script_location;
    }

    public void setScript_location(String script_location)
    {
        this.script_location = script_location;
    }

    public String getFiles()
    {
        return files;
    }

    public void setFiles(String files)
    {
        this.files = files;
    }
}
