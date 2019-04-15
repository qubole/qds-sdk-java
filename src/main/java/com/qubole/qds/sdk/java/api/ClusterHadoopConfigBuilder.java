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


public interface ClusterHadoopConfigBuilder
{

    public ClusterFairSchedulerConfigBuilder fairscheduler_settings();
    public ClusterConfigBuilder use_spark(boolean use_spark);
    public ClusterConfigBuilder use_hbase(boolean use_hbase);
    public ClusterConfigBuilder use_hadoop2(boolean use_hadoop2);
    public ClusterConfigBuilder custom_config(String custom_config);
    public ClusterConfigBuilder use_qubole_placement_policy(boolean use_qubole_placement_policy);
}
