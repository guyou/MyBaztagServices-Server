package org.aggelos.baztag.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.api.Nabaztag;

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
public class PNabaztag extends Thing{

	/*
	 * It is to be noted that to be used outside of the violet servers, the nabaztag needs to be identified
	 * by it serial number and a token
	 */
	
	@Persistent
	private String token;
	
	
	@Persistent
	private Text signature;
	
	@Persistent
	private short version;
	
	/*
	 * Yes, it's true we could use the SN as a key. I'm not even sure I want it to be unique (to share a rabbit through a family)
	 */
	
	
    
    
    
    private Nabaztag bindedNabaztag;


	


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
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


	

	public Nabaztag getBindedNabaztag() {
		return bindedNabaztag;
	}


	public void setBindedNabaztag(Nabaztag bindedNabaztag) {
		this.bindedNabaztag = bindedNabaztag;
	}
    
    
	@Override
	public String toString() {
		return serialNumber+" - "+token;
	}
	/**
	 * This will generate a Nabaztag that can be used to interact with the API
	 * @return
	 */
	public Nabaztag generateBindedNabaztag() {
		Nabaztag nab = new Nabaztag(serialNumber, token);
		this.bindedNabaztag = nab;
		return nab;
	}
	
	
	/**
	 * Merges the Nabaztag values from the API in the current {@link PNabaztag}
	 * @param tag
	 */
	public void merge(Nabaztag tag) {
		this.name = tag.getName();
		setSignature(tag.getSignature());
		switch (tag.getVersion()) {
		case V1:
			this.version = 1;
			break;
		case V2:
			this.version = 2;
			break;
		}
		
	}
	
}
