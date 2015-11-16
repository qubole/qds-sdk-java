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
package com.qubole.qds.sdk.java.details;

import java.io.IOException;
import org.codehaus.jackson.node.ObjectNode;
import com.qubole.qds.sdk.java.api.ClusterSnapshotBuilder;

public class ClusterSnapshotBuilderImpl implements ClusterSnapshotBuilder
{
    private final ObjectNode node = QdsClientImpl.getMapper().createObjectNode();

    @Override
    public ClusterSnapshotBuilder s3_location(String s3_location) 
    {
        node.put("s3_location", s3_location);
        return this;
    }

    @Override
    public ClusterSnapshotBuilder type(SnapshotType type) 
    {
        node.put("type", type.name().toLowerCase());
        return this;
    }
    
    @Override
    public String toString()
    {
        try
        {
            return QdsClientImpl.getMapper().writer().writeValueAsString(node);
        }
        catch ( IOException e )
        {
            throw new RuntimeException("Could not serialize: " + node, e);
        }
    }
}
