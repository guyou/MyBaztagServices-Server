package org.aggelos.baztag.proxy;

import javax.jdo.annotations.PersistenceCapable;

import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Ztamp;
import org.aggelos.baztag.model.notif.Notification;

import com.google.appengine.api.users.User;

@PersistenceCapable
public class NewStampNotification extends Notification {

	public NewStampNotification(User owner, PNabaztag associatedTag, Ztamp chip) {
		// TODO Auto-generated constructor stub
	}

	
	
}
