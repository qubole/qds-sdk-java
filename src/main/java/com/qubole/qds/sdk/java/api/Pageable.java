package com.qubole.qds.sdk.java.api;

/**
 * For commands that can be paged
 */
public interface Pageable<T>
{
    /**
     * Limit the result to the given page
     *
     * @param page page number
     * @param perPage results per page
     * @return this
     */
    public T forPage(int page, int perPage);
}
