package org.aggelos.baztag.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.aggelos.baztag.app.ApplicationConfig;
import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Ztamp;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;


public class ZtampDao {

	@Autowired
	PersistenceManagerFactoryPurveyor purveyor;
	
	/**
	 * The rfid of a given ztamp is unique
	 * @param rfid
	 * @return the only ztamp associated with this rfid serial number, or null
	 */
	public Ztamp findByRfId(String rfid) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Query query = pm.newQuery(Ztamp.class);
		query.setFilter("serialNumber == rfid");
		query.declareParameters("String rfid");
		
		List<Ztamp> tamps = (List<Ztamp>) query.execute(rfid);
		if(tamps.size()==0) {
			return null;
		}
		else return tamps.get(0);
		
	}

	/**
	 * Will persist a new ZTamp
	 * @param chip
	 */
	public void save(Ztamp chip) {
		PersistenceManager pm = JDOHelper.getPersistenceManager(chip);
		if(pm==null) {
			pm = purveyor.get().getPersistenceManager();
		}
		pm.makePersistent(chip);
		pm.close();
	}
	
	/**
	 * Will return several apps configs for this ztamp
	 * @param chip : the rfid to which we added an application
	 * @return
	 */
	public List<ApplicationConfig> getAppConfigs(Ztamp chip) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		
		Query q = pm.newQuery(ApplicationConfig.class);
		q.setFilter("ztamp == chip");
		q.declareParameters(Ztamp.class.getName()+" chip");
		
		List<ApplicationConfig> confs = (List<ApplicationConfig>) q.execute(chip);
		return confs;
		
	}

	public List<Ztamp> list(User currentUser) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Query query = pm.newQuery(Ztamp.class);
		
		query.setFilter("owner == user");
		query.declareParameters("com.google.appengine.api.users.User user");
		
		List<Ztamp> tags = (List<Ztamp>) query.execute(currentUser);
		
		return tags;
	}

	public Ztamp getZtampById(String value) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Key id = KeyFactory.stringToKey(value);
		return pm.getObjectById(Ztamp.class,id);
	}

}
