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
package com.qubole.qds.sdk.java.api;

public interface ClusterEc2ConfigBuilderV13
{
    public ClusterConfigBuilderV13 compute_secret_key(String compute_secret_key);
    
    public ClusterConfigBuilderV13 compute_validated(boolean compute_validated);
    
    public ClusterConfigBuilderV13 compute_access_key(String compute_access_key);
    
    public ClusterConfigBuilderV13 aws_region(String aws_region);
    
    public ClusterConfigBuilderV13 aws_preferred_availability_zone(String aws_preferred_availability_zone);
    
    public ClusterConfigBuilderV13 subnet_id(String subnet_id);
    
    public ClusterConfigBuilderV13 vpc_id(String vpc_id);
}
