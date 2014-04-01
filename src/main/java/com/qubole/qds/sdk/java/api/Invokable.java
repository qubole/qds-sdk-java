package com.qubole.qds.sdk.java.api;

import java.util.concurrent.Future;

public interface Invokable<T>
{
    public Future<T> invoke();
}
