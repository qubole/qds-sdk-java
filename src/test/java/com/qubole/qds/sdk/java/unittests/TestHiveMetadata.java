package com.qubole.qds.sdk.java.unittests;

import com.qubole.qds.sdk.java.details.InvokeArguments;
import com.qubole.qds.sdk.java.entities.TablePartitionsAndLocation;
import org.testng.annotations.Test;

import java.util.List;

public class TestHiveMetadata extends AbstractTest {

    @Test
    public void testViewPartitionsAndLocation() throws Exception {
        String schema_name = "default";
        String table_name = "table";
        InvokeArguments<List<TablePartitionsAndLocation>> invokeargs = qdsClient.hiveMetadata().viewTablePartitionsAndLocation(String.join(".", schema_name, table_name)).getArgumentsInvocation();
        assertRequestDetails(invokeargs, "GET", "hive/" + schema_name + "/" + table_name + "/partitions", null, null, null, List.class);
    }
}
