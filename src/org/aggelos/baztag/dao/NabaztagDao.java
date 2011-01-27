package org.aggelos.baztag.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.aggelos.baztag.exception.DaoException;
import org.aggelos.baztag.model.PNabaztag;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;

/**
 * provides CRUD operations for a Nabaztag
 * @author Sinmaniphel
 *
 */
public class NabaztagDao {
	
	@Autowired
	PersistenceManagerFactoryPurveyor purveyor;
	
	public void save(PNabaztag tag) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		// hack : serial number queries must be case insensitive
		tag.setSerialNumber(tag.getSerialNumber().toUpperCase());
		tag.setToken(tag.getToken().toUpperCase());
		pm.makePersistent(tag);
		pm.close();
	}
	
	public List<PNabaztag> list(User user) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Query query = pm.newQuery(PNabaztag.class);
		
		query.setFilter("owner == user");
		query.declareParameters("com.google.appengine.api.users.User user");
		
		List<PNabaztag> tags = (List<PNabaztag>) query.execute(user);
		//pm.close();
		
		return tags;
		
	}
	
	public void purge() {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Query query = pm.newQuery(PNabaztag.class);
		query.deletePersistentAll();
		pm.close();
		
		
	}
	
	public PNabaztag getNabaztagById(String key) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Key id = KeyFactory.stringToKey(key);
		return pm.getObjectById(PNabaztag.class,id);
		
	}

	public void deleteNabaztag(User currentUser, String value) throws DaoException{
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		// first we are going to check that the nabaztag is one of the user's
		Key id = KeyFactory.stringToKey(value);
		PNabaztag tag = pm.getObjectById(PNabaztag.class,id);
		if(!tag.getOwner().equals(currentUser)) {
			throw new DaoException("Euh dis, je ne crois pas que tu aies le droit de faire �a, il est pas � toi ce lapin");
		}
		pm.deletePersistent(tag);
		
	}
	
	public PNabaztag getBySerialNumber(String sn) {
		PersistenceManager pm = purveyor.get().getPersistenceManager();
		Query query = pm.newQuery(PNabaztag.class);
		
		query.setFilter("serialNumber == sn");
		query.declareParameters("String sn");
		
		List<PNabaztag> tags = (List<PNabaztag>) query.execute(sn.toUpperCase());
		if(tags.size()==0) return null;
		return tags.get(0);
	}
	
}
