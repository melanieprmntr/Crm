package fr.cbu.OwnCrm.test;

import java.util.List;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.jdbc.DatabaseStructure;
import fr.cbu.OwnCrm.service.ArticleService;
import fr.cbu.OwnCrm.service.ProspectService;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class TestJdbcCreateTable {
	public static void main(String[] args) throws Exception {

		// Création de la structure de ma base de données
		DatabaseStructure.createTableArticle();
		DatabaseStructure.createTableProspect();
		

		// Peuple ma base de données
		Prospect prospect = ProspectService.getInstance();
		prospect.setId(OwnCrmSingleton.nextSequence());
		prospect.setNom("Bujalance");
		prospect.setPrenom("Carine");
		ProspectService.save(prospect);

		Prospect prospect1 = ProspectService.getInstance();
		prospect.setId(OwnCrmSingleton.nextSequence());
		prospect.setNom("T'Jampens");
		prospect.setPrenom("Rémi");
		ProspectService.save(prospect1);

		Article article = ArticleService.getInstance();
		article.setId(OwnCrmSingleton.nextSequence());
		article.setNom("repas chez la maman de Remi");
		article.getPrixVenteHt();
		ArticleService.save(article);

		Article article2 = ArticleService.getInstance();
		article2.setId(OwnCrmSingleton.nextSequence());
		article2.setNom("repas chez la maman de Remi");
		article2.setPrixVenteHt(1500d);
		ArticleService.save(article2);
		// J'affiche pour mon utilisateur l'ensemble des contacts
		List<Prospect> listProspect = ProspectService.findAll();
		System.out.println(listProspect);

		// J'affiche l'ensemble des événements
		List<Article> listArticle = ArticleService.findAll();
		System.out.println(listArticle);

		// J'affiche le dernier contact créé
//		System.out.println("Contact avant findByContact " + prospect);
//		ArticleService.findByContact(contact);
		System.out.println("Contact Reynier Martin " + article);
	}

}
