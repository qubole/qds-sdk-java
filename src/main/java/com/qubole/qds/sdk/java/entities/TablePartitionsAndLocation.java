package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TablePartitionsAndLocation {

    private String part_name;
    private String location;

    public TablePartitionsAndLocation()
    {
    }

    @JsonCreator
    public TablePartitionsAndLocation(@JsonProperty("PART_NAME") String part_name, @JsonProperty("LOCATION") String location)
    {
        this.part_name = part_name;
        this.location = location;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
