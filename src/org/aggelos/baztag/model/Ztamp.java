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
public class Ztamp {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    
	// For now we will associate a Ztamp to only one owner...
	@Persistent
    private User owner;
	
	// the owner will be able to rename his stamp
    @Persistent
    private String name;
    
    // only one application config by stamp for now
    @Persistent
    private ApplicationConfig application;

    
    // and most importantly its hash id
    @Persistent
    private String hashCode;
    
    
    
	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(ApplicationConfig application) {
		this.application = application;
	}
    
    
    
}
