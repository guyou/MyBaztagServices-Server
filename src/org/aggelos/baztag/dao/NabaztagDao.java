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
		//Key id = KeyFactory.stringToKey(key);
		
	}
	
}
