package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.NameAndType;
import com.qubole.qds.sdk.java.entities.Status;
import com.qubole.qds.sdk.java.entities.TableProperties;
import com.qubole.qds.sdk.java.entities.TablePropertiesResponse;
import java.util.List;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/hive-metadata-api/
 */
public interface HiveMetadataApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/table/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<List<NameAndType>> table(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/store-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public StoreTablePropertiesBuilder storeTableProperties(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/get-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<TablePropertiesResponse> getTableProperties(String tableName);

    /**
     * Corresponds to http://www.qubole.com/docs/delete-table-properties/
     *
     * @param tableName the table name
     * @return builder
     */
    public InvokableBuilder<Status> deleteTableProperties(String tableName);
}
