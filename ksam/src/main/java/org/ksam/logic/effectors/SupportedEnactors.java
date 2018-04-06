package org.ksam.logic.effectors;

import java.util.HashMap;
import java.util.Map;

import org.ksam.client.IEffectorEnactor;
import org.ksam.client.OpenDlvClient;
import org.ksam.client.ProteusClient;

public class SupportedEnactors {
    public static final Map<String, IEffectorEnactor> enactors = new HashMap<String, IEffectorEnactor>() {
	{
	    put("proteusMonitor", new ProteusClient());
	    put("openDlvMonitor_v0", new OpenDlvClient("0"));
	    put("openDlvMonitor_v1", new OpenDlvClient("1"));
	}
    };
}
