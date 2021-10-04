package fr.cbu.OwnCrm.singleton;

import fr.cbu.OwnCrm.hibernate.HibernateConfiguration;

public class OwnCrmSingleton {


	private static OwnCrmSingleton ownCrmSingleton;

	private HibernateConfiguration hibernateConfiguration;

	private static Long sequence = 0L;

	public static OwnCrmSingleton getInstance() {
		if (ownCrmSingleton == null) {
			ownCrmSingleton = new OwnCrmSingleton();
		}
		return ownCrmSingleton;
	}

	public static Long nextSequence() {
		return sequence++;
	}

	public HibernateConfiguration getHibernateConfiguration() {
		return hibernateConfiguration;
	}

	public void setHibernateConfiguration(HibernateConfiguration hibernateConfiguration) {
		this.hibernateConfiguration = hibernateConfiguration;
	}

}
