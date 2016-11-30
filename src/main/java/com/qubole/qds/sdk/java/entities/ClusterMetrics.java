package com.qubole.qds.sdk.java.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterMetrics {

    String metric;
    String hostname;
    String interval;
    String[][] datapoints;

    public   String[][] getDatapoints() {
        return datapoints;
    }

    public void setDatapoint(String[][] datapoints) {
        this.datapoints = datapoints;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}
