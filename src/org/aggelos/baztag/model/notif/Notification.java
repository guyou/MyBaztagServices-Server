package org.aggelos.baztag.model.notif;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class Notification {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    protected Key key;
	
	@Persistent
	protected User target;
	
	@Persistent
	protected String level;

	
	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
		this.target = target;
	}

	public NotificationLevel getLevel() {
		return NotificationLevel.valueOf(level);
	}

	public void setLevel(NotificationLevel level) {
		this.level = level.name();
	}

	public Notification(User target, NotificationLevel level) {
		super();
		this.target = target;
		setLevel(level);
	}
	
	public abstract String getHtmlOutput();
	
	
	
}
