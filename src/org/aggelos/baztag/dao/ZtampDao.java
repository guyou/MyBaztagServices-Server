package org.aggelos.baztag.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.aggelos.baztag.app.ApplicationConfig;
import org.aggelos.baztag.model.Ztamp;
import org.springframework.beans.factory.annotation.Autowired;


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
		query.setFilter("hashcode = rfid");
		query.declareParameters("String rfi");
		
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
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		pm.makePersistent(chip);		
	}
	
	/**
	 * Will return several apps configs for this ztamp
	 * @param chip : the rfid to which we added an application
	 * @return
	 */
	public List<ApplicationConfig> getAppConfigs(Ztamp chip) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		
		Query q = pm.newQuery(ApplicationConfig.class);
		q.setFilter("ztamp = chip");
		q.declareParameters(Ztamp.class.getName()+" chip");
		
		List<ApplicationConfig> confs = (List<ApplicationConfig>) q.execute(chip);
		return confs;
		
	}

}
