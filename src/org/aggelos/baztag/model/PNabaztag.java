package org.aggelos.baztag.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
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
	
	private String roger;
	
	@Persistent
	private String token;
	
	@Persistent
	private String name;
	
	@Persistent
	private Text signature;
	
	@Persistent
	private short version;
	
	/*
	 * Yes, it's true we could use the SN as a key. I'm not even sure I want it to be unique (to share a rabbit through a family)
	 */
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private User owner;
    


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSignature() {
		return signature.getValue();
	}


	public void setSignature(String signature) {
		this.signature = new Text(signature);
	}


	public short getVersion() {
		return version;
	}


	public void setVersion(short version) {
		this.version = version;
	}


	public Key getKey() {
		return key;
	}
	
	public String getKeyAsString() {
		return KeyFactory.keyToString(key);
	}


	public void setKey(Key key) {
		this.key = key;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User author) {
		this.owner = author;
	}


    
	/**
	 * This will generate a Nabaztag that can be used to interact with the API
	 * @return
	 /
	public Nabaztag generateBindedNabaztag() {
		Nabaztag nab = new Nabaztag(serialNumber, token);
		this.bindedNabaztag = nab;
		return nab;
	}*/
	
		
	
}
