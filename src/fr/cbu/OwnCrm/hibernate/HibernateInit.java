package fr.cbu.OwnCrm.hibernate;

import java.io.FileNotFoundException;

import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class HibernateInit {

	
	public static void init() throws FileNotFoundException {
		HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
		OwnCrmSingleton.getInstance().setHibernateConfiguration(hibernateConfiguration);
	}
}
