package org.aggelos.baztag.model.notif;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Ztamp;

import com.google.appengine.api.users.User;

@PersistenceCapable
public class NewStampNotification extends Notification {

	public NewStampNotification(User owner, PNabaztag associatedTag, Ztamp chip) {
		super(owner,NotificationLevel.Info);
		tag = associatedTag;
		this.chip = chip;
		
	}
	
	@Persistent
	protected PNabaztag tag;
	
	@Persistent 
	protected Ztamp chip;

	@Override
	public String getHtmlOutput() {
		return "<p>Ooooooooooooooh ! "+tag.getName()+" a reniflé un nouveau ztamp : "+chip.getSerialNumber()+"</p>";
	}
	
	
	
}
