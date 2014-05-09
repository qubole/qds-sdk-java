package com.qubole.qds.sdk.java.api;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/dbtaps-api-qds-api-reference/
 */
public interface DbTapsApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/create-a-dbtap/
     *
     * @return new builder
     */
    public DbTapCreateBuilder create();
}
