package com.qubole.qds.sdk.java.api;

public interface Pageable<T>
{
    public T forPage(int page, int perPage);
}
