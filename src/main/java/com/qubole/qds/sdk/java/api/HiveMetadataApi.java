package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.NameAndType;
import java.util.List;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/hive-metadata-api/
 */
public interface HiveMetadataApi
{
    public InvokableBuilder<List<NameAndType>> table(String tableName);
}
