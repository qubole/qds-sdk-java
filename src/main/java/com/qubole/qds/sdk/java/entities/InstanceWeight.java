package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstanceWeight {

    private String instance_type;
    private double weight;

    public InstanceWeight()
    {
    }

    private InstanceWeight(String instance_type, double weight)
    {
        this.instance_type = instance_type;
        this.weight = weight;
    }

    public static InstanceWeight getInstanceWeight(String instance_type, double weight)
    {
        return new InstanceWeight(instance_type, weight);
    }

    public String getInstance_type() {
        return instance_type;
    }

    public double getWeight() {
        return weight;
    }
}
