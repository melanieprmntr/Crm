package fr.cbu.OwnCrm.generateData;

import java.sql.SQLException;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.service.ArticleService;
import fr.cbu.OwnCrm.service.ProspectService;

public class GenerateData {

	public static void generate() throws ClassNotFoundException, SQLException {
		// Peuple ma base de données
		Article article = ArticleService.getInstance();
		article.setNom("tv");
		article.setDescription("lcd");
		article.setPrixVenteHt(15d);
		ArticleService.save(article);

		article = ArticleService.getInstance();
		article.setNom("téléphone");
		article.setDescription("sans fil");
		article.setPrixVenteHt(15d);
		ArticleService.save(article);

		article = ArticleService.getInstance();
		article.setNom("boite de gateau");
		article.setDescription("sans chocolat");
		article.setPrixVenteHt(15d);
		ArticleService.save(article);
		
		
		Prospect prospect = ProspectService.getInstance();
		prospect.setNom("Bujalance");
		prospect.setPrenom("Carine");
		prospect.setRaisonsociale("15d");
		ProspectService.save(prospect);
		
		prospect = ProspectService.getInstance();
		prospect.setNom("T'Jampens");
		prospect.setPrenom("Rémi");
		prospect.setRaisonsociale("15d");
		ProspectService.save(prospect);
		
//		GroupeDto groupe1 = GroupeService.getInstance();
//		groupe1.setNom("Equipe de foot");
//
//		Article reynierEric = ArticleService.findById(0L);
//	groupe1.getListArticles().add(reynierEric);
//
//		System.out.println("before insert groupe1");
//		GroupeService.save(groupe1);
//
//		System.out.println("before instanciation groupe2");
//
//		GroupeDto groupe2 = GroupeService.getInstance();
//		groupe2.setNom("Cousinade 2022");
//
//		ContactDto jamilJMILI = ContactService.findById(2L);
//		groupe2.getListContacts().add(jamilJMILI);
//		groupe2.getListContacts().add(reynierEric);
//
//		GroupeService.save(groupe2);
//
//		System.out.println("Liste des groupes " + GroupeService.findAll());
	}
}
