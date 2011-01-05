package org.aggelos.baztag.app;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.model.PNabaztag;

import com.google.appengine.api.datastore.Key;

/**
 * An application config will describe for a given {@link PNabaztag} what to perform
 * @author aggelos
 *
 */

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class ApplicationConfig {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    protected Key key;
	
	// a config is associated to a PNabaztag
	@Persistent 
	protected PNabaztag nabaztag;
	
	
	public abstract String getApplicationIdentifier();
	
}
