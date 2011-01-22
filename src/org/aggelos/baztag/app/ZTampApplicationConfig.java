package org.aggelos.baztag.app;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.model.Ztamp;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class ZTampApplicationConfig {

	public abstract String getApplicationIdentifier();

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    protected Key key;
	
	@Persistent
	protected Ztamp ztamp;
	
	
	
}
