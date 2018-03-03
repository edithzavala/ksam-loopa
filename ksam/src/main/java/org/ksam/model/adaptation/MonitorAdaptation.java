package org.ksam.model.adaptation;

import java.util.List;

public class MonitorAdaptation {
    private String adaptId;
    private List<String> monitorsToAdd;
    private List<String> monitorsToRemove;

    public String getAdaptId() {
	return adaptId;
    }

    public void setAdaptId(String adaptId) {
	this.adaptId = adaptId;
    }

    public List<String> getMonitorsToAdd() {
	return monitorsToAdd;
    }

    public void setMonitorsToAdd(List<String> monitorsToAdd) {
	this.monitorsToAdd = monitorsToAdd;
    }

    public List<String> getMonitorsToRemove() {
	return monitorsToRemove;
    }

    public void setMonitorsToRemove(List<String> monitorsToRemove) {
	this.monitorsToRemove = monitorsToRemove;
    }

}
