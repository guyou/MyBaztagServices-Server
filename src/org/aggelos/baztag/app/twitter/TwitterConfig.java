package org.aggelos.baztag.app.twitter;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.app.ApplicationConfig;
import org.aggelos.baztag.model.PNabaztag;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class TwitterConfig extends ApplicationConfig{

	// TODO : would be better if an application created an new config, but well...
	public String getApplicationIdentifier() {
		return appName;
	}
	
	private String appName;
	
	TwitterConfig(String appName) {
		this.appName = appName;
	}
	
	// twitter : token and token secret necessary by user 
	@Persistent
	private String token;
	
	@Persistent
	private String tokenSecret;
	
	@Persistent
	private boolean readMentions;
	
	@Persistent
	private boolean readDirectMessages;
	
	@Persistent
	private int readCount;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public boolean isReadMentions() {
		return readMentions;
	}

	public void setReadMentions(boolean readMentions) {
		this.readMentions = readMentions;
	}

	public boolean isReadDirectMessages() {
		return readDirectMessages;
	}

	public void setReadDirectMessages(boolean readDirectMessages) {
		this.readDirectMessages = readDirectMessages;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
}
