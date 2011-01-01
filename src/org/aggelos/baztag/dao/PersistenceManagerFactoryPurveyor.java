package org.aggelos.baztag.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PersistenceManagerFactoryPurveyor {

	private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PersistenceManagerFactoryPurveyor() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }

	
}
