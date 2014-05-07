package com.qubole.qds.sdk.java.details;

import com.google.common.collect.ImmutableList;
import com.qubole.qds.sdk.java.api.ClusterEditBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.Cluster;
import com.qubole.qds.sdk.java.entities.ClusterItem;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

public class ClusterEditBuilderImpl implements ClusterEditBuilder
{
    private static final ObjectMapper mapper = new ObjectMapper();

    private final QdsClient client;
    private final String labelOrId;
    private final Cluster newConfig;
    private final List<String> mask;

    @Override
    public Future<ClusterItem> invoke()
    {
        ObjectNode clusterNode = mapper.valueToTree(newConfig);

        if ( mask != null )
        {
            clusterNode = applyMask(clusterNode);
        }

        ObjectNode node = mapper.createObjectNode();
        node.put("cluster", clusterNode);
        try
        {
            ClientEntity entity = new ClientEntity(mapper.writer().writeValueAsString(node), ClientEntity.Method.PUT);
            return client.invokeRequest(null, entity, ClusterItem.class, "clusters", labelOrId);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }

    ClusterEditBuilderImpl(QdsClient client, String labelOrId, Cluster newConfig, List<String> mask)
    {
        this.client = client;
        this.labelOrId = labelOrId;
        this.newConfig = newConfig;
        this.mask = (mask != null) ? ImmutableList.copyOf(mask) : null;
    }

    private ObjectNode applyMask(ObjectNode node)
    {
        ObjectNode maskedNode = mapper.createObjectNode();
        for ( String pathSpec : mask )
        {
            JsonNode source = node;
            ObjectNode target = maskedNode;
            for ( String part : pathSpec.split("\\.") )
            {
                JsonNode sourceValue = source.get(part);
                if ( sourceValue == null )
                {
                    throw new IllegalArgumentException(String.format("Invalid mask (%s) at item (%s) with part (%s)", mask, pathSpec, part));
                }

                if ( sourceValue.isObject() )
                {
                    source = sourceValue;
                    ObjectNode existingTarget = (ObjectNode)maskedNode.get(part);
                    if ( existingTarget == null )
                    {
                        target = mapper.createObjectNode();
                        maskedNode.put(part, target);
                    }
                }
                else
                {
                    target.put(part, sourceValue);
                }
            }
        }
        return maskedNode;
    }
}
