/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.examples;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.NameAndType;
import com.qubole.qds.sdk.java.entities.Schema;
import com.qubole.qds.sdk.java.entities.SchemaListDescribed;
import com.qubole.qds.sdk.java.entities.SchemaOrdinal;

import java.util.List;
import java.util.Map;

public class HiveMetadataExample {
    public static void main(String[] args) throws Exception {
        String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
        QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));

        QdsClient client = QdsClientFactory.newClient(configuration);
        try {
            //Get the list of schemas available.
            List<String> schema_names =  client.hiveMetadata().getSchemaNames().invoke().get();
            System.out.println("Following schemas are available:");
            for (String schema_name : schema_names) {
                System.out.println(schema_name);
            }
            System.out.println();

            // Get the list of tables available.
            List<Schema> listOfTables = client.hiveMetadata().schema().invoke().get();
            System.out.println("Following tables are available:");
            for (Schema s : listOfTables) {
                System.out.println(s.getTable_name());
            }
            System.out.println();

            // Get the list of tables available along with column information.
            List<Schema> listOfTablesDescribed = client.hiveMetadata().schema().described().invoke().get();
            for (Schema s : listOfTablesDescribed) {
                System.out.println("Description of table " + s.getTable_name() + ":");
                List<NameAndType> columns = s.getColumns();
                for (NameAndType nt : columns) {
                    System.out.format("%-40s %s%n", nt.getName(), nt.getType());
                }
                System.out.println();
            }

            // Get the list of tables available in non-default schema
            List<Schema> listOfTablesCustom = client.hiveMetadata().schema().schemaName("tpcds_orc_500").invoke().get();
            System.out.println("Following tables are available in tpcds_orc_500:");
            for (Schema s : listOfTablesCustom) {
                System.out.println(s.getTable_name());
            }
            System.out.println();

            // Get information about a particular table.
            List<NameAndType> tableDefinition = client.hiveMetadata().table("default_qubole_memetracker").invoke().get();
            System.out.println("Table default_qubole_memetracker:");
            for (NameAndType nt : tableDefinition) {
                System.out.format("%-40s %s%n", nt.getName(), nt.getType());
            }
            System.out.println();

            //Get information about all the schemas.
            SchemaListDescribed schemaList = client.hiveMetadata().getSchemaListDescribed().invoke().get();
            Map<String, List<SchemaOrdinal>> schemas = schemaList.getSchemas();

            int current_page = 2;
            int per_page = schemaList.getPaging_info().getPer_page();

            while (schemaList.getPaging_info().getNext_page() != null) {
                schemaList = client.hiveMetadata().getSchemaListDescribed().forPage(current_page++, per_page).invoke().get();
                schemas.putAll(schemaList.getSchemas());
            }

            System.out.println("Detailed list of all the schemas available:");
            for (String schemaName : schemas.keySet()) {
                System.out.println("Description of schema " + schemaName + ":");
                List<SchemaOrdinal> listofTables = schemas.get(schemaName);
                for(SchemaOrdinal table : listofTables) {
                    System.out.println("\t\tDescription of table " + table.getTable_name() + ":");
                    for (NameTypePosition column : table.getColumns()) {
                        System.out.format("\t\t\t\t%-40s %s%n", column.getName(), column.getType());
                    }
                }
            }

        } finally {
            client.close();
        }
    }
}
