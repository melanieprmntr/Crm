package fr.cbu.OwnCrm.test;

import java.io.FileWriter;
import java.io.IOException;

import fr.cbu.OwnCrm.balise.Balise;
import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.Devis;
import fr.cbu.OwnCrm.dto.DevisLigne;
import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.html.DevisLignes;
import fr.cbu.OwnCrm.html.DevisReference;
import fr.cbu.OwnCrm.html.DevisTotaux;
import fr.cbu.OwnCrm.html.Div;
import fr.cbu.OwnCrm.html.Html;
import fr.cbu.OwnCrm.html.PropectAdresse;
import fr.cbu.OwnCrm.html.Style;
import fr.cbu.OwnCrm.service.ArticleService;
import fr.cbu.OwnCrm.service.DevisLigneService;
import fr.cbu.OwnCrm.service.DevisService;

public class TestDevisToHtml {

	public static void main(String[] args) throws IOException {

		// Créer un panier simple avec un client associé au panier

		// Produire le HTML correspondant

		// étape 1 : produire la zone 'client' du panier de commande

		Prospect prospect = new Prospect();
		prospect.setRaisonsociale("SOCIETE DURANT");
		prospect.setNom("DURANT");
		prospect.setPrenom("Jean");
		prospect.setAdresse("2, impasse du Près");
		prospect.setCodepostal("42002");
		prospect.setVille("SAINT PORCIN");

		TestTools testTools = new TestTools();

		// Créer une instance d'article
		Article creationSiteVitine = ArticleService.getInstance();
		creationSiteVitine.setPrixVenteHt(100d);
		creationSiteVitine.setArticleType(null);
		ArticleService.calculPrixVenteTtc(creationSiteVitine);

		// Créer une instance de PanierLigne
		DevisLigne devisLigne = DevisLigneService.getInstance(creationSiteVitine);
		DevisLigneService.calculDevisLigne(devisLigne);

		System.out.println(devisLigne);
		// Créer une instance de PanierLigne
		DevisLigne devisLigne2 = DevisLigneService.getInstance(creationSiteVitine);
		DevisLigneService.calculDevisLigne(devisLigne2);

		// Créer une instance de PanierLigne
		DevisLigne devisLigne3 = DevisLigneService.getInstance(creationSiteVitine);
		DevisLigneService.calculDevisLigne(devisLigne3);

		// Créer une instance de Panier
		Devis devis = DevisService.getInstance(001);
		devis.setProspect(prospect);

		// Ajouter la ligne au panier
		DevisService.addDevisLigne(devis, devisLigne);
		DevisService.addDevisLigne(devis, devisLigne2);
		DevisService.addDevisLigne(devis, devisLigne3);

		// Calculer le panier
		DevisService.calculDevis(devis);

		// ------------------------------------------------------------------

		Html page = new Html();

		Balise head = page.getHead();
		Balise body = page.getBody();

		Balise style = new Style();
		head.add(style);
		style.setContenu("*{font-family:arial} .spanEnBlock span{display:block}");

		// Block 1 : adresse client
		Balise entete = new Div();
		entete.setStyle("display:flex;justify-content:flex-end");
		body.add(entete);

		Balise devisPropectAdresse = new PropectAdresse(prospect);
		entete.add(devisPropectAdresse);
		devisPropectAdresse.setClazz("spanEnBlock");

		Balise title = new Balise();
		title.setNom("H1");
		title.setContenu("Devis");
		body.add(title);

		// Block 2 : référence panier
		Balise devisReference = new DevisReference(devis);
		devisReference.setClazz("spanEnBlock");
		body.add(devisReference);

		// Block 3 : lignes du panier
		Balise devisLignes = new DevisLignes(devis);
		body.add(devisLignes);

		// Block 4 : totaux
		Balise pied = new Div();
		pied.setStyle("display:flex;justify-content:flex-end");
		body.add(pied);

		Balise devisTotaux = new DevisTotaux(devis);
		pied.add(devisTotaux);

		// ------------------------------------------------------------------

		long debut = System.currentTimeMillis();
		String theHtml = page.toString();
		long fin = System.currentTimeMillis();
		long duree = fin - debut;
		System.out.println("durée de production HTML : " + duree);

		FileWriter out = new FileWriter("test.html");
		out.write(theHtml);
		out.flush();
		out.close();

		System.out.println("production HTML terminée");

	}
}
