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

public interface ClusterPrestoConfigBuilderV13
{
    public ClusterConfigBuilderV13 enable_presto(boolean enable_presto);

    public ClusterConfigBuilderV13 custom_config(String custom_config);
    
    public ClusterConfigBuilderV13 jvm_config(String jvm_config);
}
