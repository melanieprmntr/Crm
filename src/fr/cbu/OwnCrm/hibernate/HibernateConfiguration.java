package fr.cbu.OwnCrm.hibernate;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.dto.Devis;
import fr.cbu.OwnCrm.dto.DevisLigne;
import fr.cbu.OwnCrm.dto.Facture;
import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.dto.Reglement;
import fr.cbu.OwnCrm.dto.Tva;

public class HibernateConfiguration {

	private static final String FILE_NAME_HIBERNATE_CONFIGURATION = "owncrm.cfg.xml";

	private SessionFactory factory;

	
	File file = new File(FILE_NAME_HIBERNATE_CONFIGURATION);

	Configuration configuration;

	public HibernateConfiguration() throws FileNotFoundException {

		if (!file.exists()) {
			throw new FileNotFoundException("Le fichier de configuration nécessaire à hibernate, '"
					+ FILE_NAME_HIBERNATE_CONFIGURATION + "' n'existe pas !");
		}

		buildConfiguration(file);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

		
		ServiceRegistry serviceRegistry = builder.applySettings(configuration.getProperties()).build();

		this.factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public void buildConfiguration(File fileHibernateConfiguration) {
		this.configuration = new Configuration().configure(fileHibernateConfiguration);


		this.configuration.addAnnotatedClass(Prospect.class);
		this.configuration.addAnnotatedClass(Devis.class);
		this.configuration.addAnnotatedClass(Article.class);
		this.configuration.addAnnotatedClass(Facture.class);
		this.configuration.addAnnotatedClass(Reglement.class);
		this.configuration.addAnnotatedClass(ArticleType.class);
		this.configuration.addAnnotatedClass(Tva.class);
		this.configuration.addAnnotatedClass(DevisLigne.class);

	}

	public SessionFactory getFactory() {
		return factory;
	}
}
