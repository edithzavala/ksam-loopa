package org.model.monitoringData;

import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonitoringData {
    private long timeStamp;
    private List<Entry<String, Object>> context;
    private List<RuntimeMonitoData> monitors;

    public long getTimeStamp() {
	return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
	this.timeStamp = timeStamp;
    }

    public List<Entry<String, Object>> getContext() {
	return context;
    }

    public void setContext(List<Entry<String, Object>> context) {
	this.context = context;
    }

    public List<RuntimeMonitoData> getMonitors() {
	return monitors;
    }

    public void setMonitors(List<RuntimeMonitoData> monitors) {
	this.monitors = monitors;
    }

}
