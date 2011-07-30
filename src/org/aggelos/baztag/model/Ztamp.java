package org.aggelos.baztag.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.app.ApplicationConfig;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

/**
 * Represents an object containing an RFID chip
 * @author aggelos
 *
 */
@PersistenceCapable
public class Ztamp extends Thing{


        
    // only one application config by stamp for now
    @Persistent
    private ApplicationConfig application;

	public ApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(ApplicationConfig application) {
		this.application = application;
	}
    
    
    
}
