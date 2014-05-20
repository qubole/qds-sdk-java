package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.ResultValue;

public interface ResultsCommandBuilder extends InvokableBuilder<ResultValue>
{
    public InvokableBuilder<ResultValue> inline(Boolean value);
}
