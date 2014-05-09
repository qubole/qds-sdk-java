package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Schema;
import java.util.List;

public interface SchemaCommandBuilder extends InvokableBuilder<List<Schema>>
{
    public SchemaCommandBuilder filter(String filter);

    public SchemaCommandBuilder described();
}
