package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterEc2ConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterFairSchedulerConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterHadoopConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterPrestoConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterSecurityConfigBuilder;
import com.qubole.qds.sdk.java.api.ClusterSpotInstanceConfigBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;
import java.util.List;

class ClusterConfigBuilderImpl implements ClusterConfigBuilder
{
    private static final ObjectMapper mapper = new ObjectMapper();

    private final ObjectNode node = mapper.createObjectNode();
    private final ObjectNode presto_settings = mapper.createObjectNode();
    private final ObjectNode security_settings = mapper.createObjectNode();
    private final ObjectNode hadoop_settings = mapper.createObjectNode();
    private final ObjectNode fairscheduler_settings = mapper.createObjectNode();
    private final ObjectNode spot_instance_settings = mapper.createObjectNode();
    private final ObjectNode ec2_settings = mapper.createObjectNode();

    public ObjectNode getNode()
    {
        ObjectNode clusterNode = mapper.createObjectNode();
        clusterNode.put("cluster", node);
        return clusterNode;
    }

    @Override
    public String toString()
    {
        try
        {
            return mapper.writer().writeValueAsString(getNode());
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }

    @Override
    public ClusterConfigBuilder state(String state)
    {
        node.put("state", state);
        return this;
    }

    @Override
    public ClusterPrestoConfigBuilder presto_settings()
    {
        if ( !node.has("presto_settings") )
        {
            node.put("presto_settings", presto_settings);
        }

        return new ClusterPrestoConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder is_presto_enabled(boolean is_presto_enabled)
            {
                presto_settings.put("is_presto_enabled", is_presto_enabled);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_config(String custom_config)
            {
                presto_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }

    @Override
    public ClusterConfigBuilder disallow_cluster_termination(boolean disallow_cluster_termination)
    {
        node.put("disallow_cluster_termination", disallow_cluster_termination);
        return this;
    }

    @Override
    public ClusterSecurityConfigBuilder security_settings()
    {
        if ( !node.has("security_settings") )
        {
            node.put("security_settings", security_settings);
        }

        return new ClusterSecurityConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder encrypted_ephemerals(boolean encrypted_ephemerals)
            {
                security_settings.put("encrypted_ephemerals", encrypted_ephemerals);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder customer_ssh_key(String customer_ssh_key)
            {
                security_settings.put("customer_ssh_key", customer_ssh_key);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }

    @Override
    public ClusterConfigBuilder enable_ganglia_monitoring(boolean enable_ganglia_monitoring)
    {
        node.put("enable_ganglia_monitoring", enable_ganglia_monitoring);
        return this;
    }

    @Override
    public ClusterHadoopConfigBuilder hadoop_settings()
    {
        if ( !node.has("hadoop_settings") )
        {
            node.put("hadoop_settings", hadoop_settings);
        }

        return new ClusterHadoopConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder master_instance_type(String master_instance_type)
            {
                hadoop_settings.put("master_instance_type", master_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterFairSchedulerConfigBuilder fairscheduler_settings()
            {
                if ( !hadoop_settings.has("fairscheduler_settings") )
                {
                    hadoop_settings.put("fairscheduler_settings", fairscheduler_settings);
                }
                return new ClusterFairSchedulerConfigBuilder()
                {
                    @Override
                    public ClusterConfigBuilder default_pool(String default_pool)
                    {
                        fairscheduler_settings.put("default_pool", default_pool);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }

            @Override
            public ClusterConfigBuilder max_nodes(int max_nodes)
            {
                hadoop_settings.put("max_nodes", max_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_instance_type(String slave_instance_type)
            {
                hadoop_settings.put("slave_instance_type", slave_instance_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder slave_request_type(String slave_request_type)
            {
                hadoop_settings.put("slave_request_type", slave_request_type);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder initial_nodes(int initial_nodes)
            {
                hadoop_settings.put("initial_nodes", initial_nodes);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder custom_config(String custom_config)
            {
                hadoop_settings.put("custom_config", custom_config);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterSpotInstanceConfigBuilder spot_instance_settings()
            {
                if ( !hadoop_settings.has("spot_instance_settings") )
                {
                    hadoop_settings.put("spot_instance_settings", spot_instance_settings);
                }
                return new ClusterSpotInstanceConfigBuilder()
                {
                    @Override
                    public ClusterConfigBuilder maximum_bid_price_percentage(String maximum_bid_price_percentage)
                    {
                        spot_instance_settings.put("maximum_bid_price_percentage", maximum_bid_price_percentage);
                        return ClusterConfigBuilderImpl.this;
                    }

                    @Override
                    public ClusterConfigBuilder timeout_for_request(int timeout_for_request)
                    {
                        spot_instance_settings.put("timeout_for_request", timeout_for_request);
                        return ClusterConfigBuilderImpl.this;
                    }
                };
            }
        };
    }

    @Override
    public ClusterConfigBuilder node_bootstrap_file(String node_bootstrap_file)
    {
        node.put("node_bootstrap_file", node_bootstrap_file);
        return this;
    }

    @Override
    public ClusterConfigBuilder label(List<String> label)
    {
        node.putPOJO("label", label);
        return this;
    }

    @Override
    public ClusterConfigBuilder id(int id)
    {
        node.put("id", id);
        return this;
    }

    @Override
    public ClusterEc2ConfigBuilder ec2_settings()
    {
        if ( !node.has("ec2_settings") )
        {
            node.put("ec2_settings", ec2_settings);
        }

        return new ClusterEc2ConfigBuilder()
        {
            @Override
            public ClusterConfigBuilder compute_secret_key(String compute_secret_key)
            {
                ec2_settings.put("compute_secret_key", compute_secret_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder compute_validated(boolean compute_validated)
            {
                ec2_settings.put("compute_validated", compute_validated);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder compute_access_key(String compute_access_key)
            {
                ec2_settings.put("compute_access_key", compute_access_key);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder aws_region(String aws_region)
            {
                ec2_settings.put("aws_region", aws_region);
                return ClusterConfigBuilderImpl.this;
            }

            @Override
            public ClusterConfigBuilder aws_preferred_availability_zone(String aws_preferred_availability_zone)
            {
                ec2_settings.put("aws_preferred_availability_zone", aws_preferred_availability_zone);
                return ClusterConfigBuilderImpl.this;
            }
        };
    }
}
