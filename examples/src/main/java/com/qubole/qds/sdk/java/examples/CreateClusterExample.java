package com.qubole.qds.sdk.java.examples;

import java.util.*;
import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;

public class CreateClusterExample {
	public static void main(String args[]) throws Exception {
		String endpoint = System.getProperty("API_ENDPOINT", DefaultQdsConfiguration.API_ENDPOINT);
		QdsConfiguration configuration = new DefaultQdsConfiguration(endpoint, System.getProperty("API_KEY"));
		QdsClient client = QdsClientFactory.newClient(configuration);
		
		List<String> clusterList = new ArrayList<String>();
		clusterList.add("hadoop3");
		
		try {
			System.out.println("Creating New Cluster");
			client.cluster().create(client.cluster().clusterConfig().label(clusterList).ec2_settings().compute_access_key("ACCESS_KEY").ec2_settings().compute_secret_key("SECRET_KEY")).invoke().get();
		}
		
		finally {
			client.close();
		}
	}
}
