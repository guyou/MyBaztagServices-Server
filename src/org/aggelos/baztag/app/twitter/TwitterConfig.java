package org.aggelos.baztag.app.twitter;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.model.PNabaztag;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class TwitterConfig {

	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	// a config is associated to a PNabaztag
	@Persistent 
	private PNabaztag nabaztag;
	
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
	
}
