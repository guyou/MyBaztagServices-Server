package org.aggelos.baztag.app;

import java.util.HashMap;

/**
 * A simple class passed through autowire allowing to match applications to their string, 
 * by config (no persistence)
 * @author aggelos
 *
 */
public class ApplicationBinder {

	private HashMap<String, Application> applications;

	/**
	 * @return the applications
	 */
	public HashMap<String, Application> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(HashMap<String, Application> applications) {
		this.applications = applications;
	}
	
	public Application forName(String appId) {
		if(applications !=null) {
			return applications.get(appId);
		}
		else {
			return null;
		}
	}
	
	
	
	
}
