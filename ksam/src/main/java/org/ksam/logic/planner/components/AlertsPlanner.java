package org.ksam.logic.planner.components;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.ksam.model.adaptation.MonitorAdaptation;
import org.ksam.model.configuration.MeConfig;
import org.ksam.model.configuration.SumConfig;
import org.model.planData.PlanAlert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPlanner implements IPlannerOperation {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
    private final MeConfig config;
    private List<IPlanMethod> techAlgorithms;
    private boolean isAdaptationRequired;
    private List<MonitorAdaptation> adaptations;

    public AlertsPlanner(MeConfig config) {
	this.config = config;
	this.techAlgorithms = new ArrayList<>();
	this.config.getKsamConfig().getPlannerConfig().getPlanTechniques()
		.forEach(tech -> tech.getAlgorithms().forEach(algorithm -> {
		    String p0Name = this.getClass().getPackage().getName() + "." + tech.getTechId().toString()
			    + algorithm.getAlgorithmId();
		    try {
			Class<?> clazz = Class.forName(p0Name);
			IPlanMethod p0 = (IPlanMethod) clazz.getConstructor(SumConfig.class, List.class, List.class)
				.newInstance(this.config.getSystemUnderMonitoringConfig(),
					algorithm.getAlgorithmParameters(), algorithm.getEvaluationParameters());
			this.techAlgorithms.add(p0);
		    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			    | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
			    | SecurityException e) {
			e.printStackTrace();
		    }
		}));
    }

    @Override
    public void doPlanOperation(PlanAlert planAlert) {
	this.adaptations = this.techAlgorithms.get(0).doPlan(planAlert);
    }

    @Override
    public boolean isAdaptationRequired() {
	this.isAdaptationRequired = this.adaptations.isEmpty() ? false : true;
	return this.isAdaptationRequired;
    }

    @Override
    public List<MonitorAdaptation> getAdaptationsPlanned() {
	List<MonitorAdaptation> adaptationsIteration = new ArrayList<>();
	this.adaptations.forEach(adaptation -> adaptationsIteration.add(adaptation));
	this.adaptations.clear();
	return adaptationsIteration;
    }

    @Override
    public void updatePlanAlgorithmParameters(List<Entry<String, String>> algorithmParams,
	    List<Entry<String, String>> evalParams) {
	// TODO Auto-generated method stub

    }
}
