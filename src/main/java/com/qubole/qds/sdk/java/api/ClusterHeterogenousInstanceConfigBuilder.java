package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.InstanceWeight;

import java.util.List;

public interface ClusterHeterogenousInstanceConfigBuilder {

   public ClusterConfigBuilder memory(List<InstanceWeight> weights);
}
