package com.qubole.qds.sdk.java;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.client.QdsClientFactory;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Tester
{
    public static void mainX(String[] args) throws IOException
    {
        String foo = "[{\"cluster\":{\"enable_ganglia_monitoring\":true,\"state\":\"DOWN\",\"security_settings\":{\"encrypted_ephemerals\":false,\"customer_ssh_key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAwj4M69RDT8BcbjBVKiiYtbulNZ+Q5Ee/2U9J9fj4IxhhRzQ7AtvZnzmE8CaJZ5yUnDK4alsx65hqk44WaSQkDgR4In3WbX/Wa8wKEapjpeqIbpVHfVNHCWaz0HGKBglpLG7Xprff234kyzvtttvDQZMGe+EIcriCXG5+m7r7o83yke0fefuDq4ZmUczXh/qvOoogvtUdi4aZwW1X8dUlHaXOBSJk77GP6D95v5ps4XhevywaEnemo9AQMCSnoMAxyv3llLBHNF2yLZbQa+vZKHgop9T93j084YyyIIJB+uViPlrakVYZfeZvsqHYoqcY34wWrRM1VTQZEHKxU+NWHw== snarayanan@localhost.localdomain\"},\"node_bootstrap_file\":\"node_bootstrap.sh\",\"hadoop_settings\":{\"slave_instance_type\":\"c1.xlarge\",\"slave_request_type\":\"spot\",\"initial_nodes\":1,\"spot_instance_settings\":{\"maximum_bid_price_percentage\":\"100.0\",\"timeout_for_request\":10},\"master_instance_type\":\"m1.large\",\"fairscheduler_settings\":{\"default_pool\":null},\"max_nodes\":2,\"custom_config\":null},\"ec2_settings\":{\"compute_secret_key\":\"fnj5oICptPkuw4iQjfeCUcltzn0RkAhZH60MaCZl\",\"compute_access_key\":\"AKIAJ4HY7NQ7OKGUIMIQ\",\"compute_validated\":true,\"aws_region\":\"us-east-1\",\"aws_preferred_availability_zone\":\"Any\"},\"presto_settings\":{\"is_presto_enabled\":false,\"custom_config\":null},\"disallow_cluster_termination\":false,\"label\":[\"default\"],\"id\":2}},{\"cluster\":{\"enable_ganglia_monitoring\":false,\"state\":\"DOWN\",\"security_settings\":{\"encrypted_ephemerals\":true},\"node_bootstrap_file\":\"sd\",\"hadoop_settings\":{\"slave_instance_type\":\"m1.small\",\"slave_request_type\":\"ondemand\",\"initial_nodes\":2,\"master_instance_type\":\"m1.xlarge\",\"fairscheduler_settings\":{\"default_pool\":null},\"max_nodes\":10,\"custom_config\":\"<?xml version=\\\"1.0\\\"?>  \\n<allocations>  \\n  <pool name=\\\"sample_pool\\\">\\n    <minMaps>5</minMaps>\\n    <minReduces>5</minReduces>\\n    <maxMaps>25</maxMaps>\\n    <maxReduces>25</maxReduces>\\n    <minSharePreemptionTimeout>300</minSharePreemptionTimeout>\\n  </pool>\\n  <user name=\\\"sample_user\\\">\\n    <maxRunningJobs>6</maxRunningJobs>\\n  </user>\\n  <userMaxJobsDefault>3</userMaxJobsDefault>\\n  <fairSharePreemptionTimeout>600</fairSharePreemptionTimeout>\\n</allocations>\\n\"},\"ec2_settings\":{\"compute_secret_key\":\"fnj5oICptPkuw4iQjfeCUcltzn0RkAhZH60MaCZl\",\"compute_access_key\":\"AKIAJ4HY7NQ7OKGUIMIQ\",\"compute_validated\":true,\"aws_region\":\"us-east-1\",\"aws_preferred_availability_zone\":\"Any\"},\"presto_settings\":{\"is_presto_enabled\":false,\"custom_config\":null},\"disallow_cluster_termination\":false,\"label\":[\"clone\",\"rohit\"],\"id\":3258}},{\"cluster\":{\"enable_ganglia_monitoring\":true,\"state\":\"DOWN\",\"security_settings\":{\"encrypted_ephemerals\":false},\"node_bootstrap_file\":\"node_bootstrap.sh\",\"hadoop_settings\":{\"slave_instance_type\":\"c3.xlarge\",\"slave_request_type\":\"spot\",\"initial_nodes\":2,\"spot_instance_settings\":{\"maximum_bid_price_percentage\":\"200.0\",\"timeout_for_request\":30},\"master_instance_type\":\"m1.xlarge\",\"fairscheduler_settings\":{\"default_pool\":null},\"max_nodes\":2,\"custom_config\":null},\"ec2_settings\":{\"compute_secret_key\":\"fnj5oICptPkuw4iQjfeCUcltzn0RkAhZH60MaCZl\",\"compute_access_key\":\"AKIAJ4HY7NQ7OKGUIMIQ\",\"compute_validated\":true,\"aws_region\":\"us-east-1\",\"aws_preferred_availability_zone\":\"Any\"},\"presto_settings\":{\"is_presto_enabled\":true,\"custom_config\":null},\"disallow_cluster_termination\":false,\"label\":[\"presto\"],\"id\":4846}},{\"cluster\":{\"enable_ganglia_monitoring\":true,\"state\":\"DOWN\",\"security_settings\":{\"encrypted_ephemerals\":false},\"node_bootstrap_file\":\"node_bootstrap.sh\",\"hadoop_settings\":{\"slave_instance_type\":\"c1.xlarge\",\"slave_request_type\":\"spot\",\"initial_nodes\":1,\"spot_instance_settings\":{\"maximum_bid_price_percentage\":\"100.0\",\"timeout_for_request\":10},\"master_instance_type\":\"m1.large\",\"fairscheduler_settings\":{\"default_pool\":null},\"max_nodes\":2,\"custom_config\":null},\"ec2_settings\":{\"compute_secret_key\":\"fnj5oICptPkuw4iQjfeCUcltzn0RkAhZH60MaCZl\",\"compute_access_key\":\"AKIAJ4HY7NQ7OKGUIMIQ\",\"compute_validated\":true,\"aws_region\":\"us-east-1\",\"aws_preferred_availability_zone\":\"Any\"},\"presto_settings\":{\"is_presto_enabled\":false,\"custom_config\":null},\"disallow_cluster_termination\":false,\"label\":[\"hello\"],\"id\":5792}}]";

        TypeReference<List<ClusterItem>> type = new TypeReference<List<ClusterItem>>(){};
        ObjectMapper mapper = new ObjectMapper();
        List<ClusterItem> list = mapper.reader(type).readValue(foo);
        System.out.println(list);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        QdsConfiguration configuration = new DefaultQdsConfiguration(DefaultQdsConfiguration.Type.STAGING, System.getProperty("API_KEY"));
        QdsClient client = QdsClientFactory.newClient(configuration);
        try
        {
/*
            Future<HiveCommandResponse> hiveCommandResponseFuture = client.command().hive().query("show tables;").invoke();
            HiveCommandResponse hiveCommandResponse = hiveCommandResponseFuture.get();
            System.out.println(hiveCommandResponse);
*/

            Future<List<ClusterItem>> listFuture = client.cluster().list().invoke();
            List<ClusterItem> clusterItems = listFuture.get();
            System.out.println(clusterItems);
        }
        finally
        {
            client.close();
        }
    }
}
