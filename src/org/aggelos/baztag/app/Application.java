package org.aggelos.baztag.app;

import org.aggelos.baztag.model.PNabaztag;

/**
 * Defines an application
 * @author aggelos
 *
 */
public interface Application {

	/**
	 * the identifier will be matched to an application controller
	 * ex : Request /applications/identifier
	 * @return
	 */
	String getIdentifier();
	
	/**
	 * In the application list, each application should be responsible for its content
	 * @return
	 */
	String getListContent();
	
	
	/**
	 * When the user will setup the app we will provide a form
	 * @return
	 */
	String getConfigContent();
	
	/**
	 *  When the user adds the app, if we need to display a first page (ex : auth)
	 */
	String getPreConfigContent();	
	
	/**
	 * Main call for a normal application
	 * @param config
	 * @param ptag
	 */
	void doYourStuff(ApplicationConfig config, PNabaztag ptag);
	
	
	
	/**
	 * Each app is responsible for creating
	 * @return
	 */
	ApplicationConfig newConfig();

}
