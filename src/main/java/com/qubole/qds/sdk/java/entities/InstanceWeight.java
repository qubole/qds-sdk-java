package com.qubole.qds.sdk.java.entities;

import java.io.Serializable;

public class InstanceWeight {

    private final String instance_type;
    private final double weight;

    private InstanceWeight(String instance_type, double weight)
    {
        this.instance_type = instance_type;
        this.weight = weight;
    }

    public static InstanceWeight getInstanceWeight(String instance_type, double weight)
    {
        return new InstanceWeight(instance_type, weight);
    }
}
