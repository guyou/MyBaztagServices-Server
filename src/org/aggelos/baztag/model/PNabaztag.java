package org.aggelos.baztag.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.api.Nabaztag;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

/**
 * A persisted Nabaztag. It is to be noted that it's called PNabaztag to differentiate it from the Nabaztag class 
 * of the JNabaztag API
 * 
 * @author Sinmaniphel
 *
 */
@PersistenceCapable
public class PNabaztag {

	/*
	 * It is to be noted that to be used outside of the violet servers, the nabaztag needs to be identified
	 * by it serial number and a token
	 */
	@Persistent
	private String serialNumber;
	@Persistent
	private String token;
	
	@Persistent
	private String name;
	
	@Persistent
	private String signature;
	
	@Persistent
	private short version;
	
	/*
	 * Yes, it's true we could use the SN as a key. I'm not even sure I want it to be unique (to share a rabbit through a family)
	 */
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private User author;
    
    
    private Nabaztag bindedNabaztag;
	
	
	
}
