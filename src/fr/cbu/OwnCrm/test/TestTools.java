package fr.cbu.OwnCrm.test;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.dto.Utilisateur;
import fr.cbu.OwnCrm.service.ArticleService;
import fr.cbu.OwnCrm.service.ArticleTypeService;
import fr.cbu.OwnCrm.service.TvaService;
import fr.cbu.OwnCrm.service.UtilisateurService;

public class TestTools {

	Utilisateur utilisateur;

	Article creationSiteVitrine;

	Double prixVenteHt;

	Double prixVenteTtc;

	String description;

	String nom;

	ArticleType forfait;

	Tva taux20;

	public TestTools() {
		utilisateur = UtilisateurService.getInstance("The Fairy Web", "Carine", "BUJALANCE", "06 67 15 16 79",
				"155 rue Marcel Mérieux", "69007", "LYON", "thefairyweb@hotmail.com");

		creationSiteVitrine = ArticleService.getInstance();

		prixVenteHt = 1500d;

		prixVenteTtc = 2000d;

		description = "Création d'un site internet présentant vos produits et services. Intégration de vos photos, logos et textes L'achat du nom de domaine est inclus (hors abonnement). La mise en ligne de votre nouveau site après application de vos retours et validation.";

		nom = "Création d'un site vitrine";

		forfait = ArticleTypeService.getInstance("Forfait");

		taux20 = TvaService.getInstance(20d);

	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getCreationSiteVitrine() {
		return creationSiteVitrine;
	}

	public void setCreationSiteVitrine(Article creationSiteVitrine) {
		this.creationSiteVitrine = creationSiteVitrine;
	}

	public ArticleType getForfait() {
		return forfait;
	}

	public void setForfait(ArticleType forfait) {
		this.forfait = forfait;
	}

	public Tva getTaux20() {
		return taux20;
	}

	public void setTaux20(Tva taux20) {
		this.taux20 = taux20;
	}

	public Double getPrixVenteHt() {
		return prixVenteHt;
	}

	public void setPrixVenteHt(Double prixVenteHt) {
		this.prixVenteHt = prixVenteHt;
	}

	public Double getPrixVenteTtc() {
		return prixVenteTtc;
	}

	public void setPrixVenteTtc(Double prixVenteTtc) {
		this.prixVenteTtc = prixVenteTtc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestTools [utilisateur=" + utilisateur + ", creationSiteVitrine=" + creationSiteVitrine
				+ ", prixVenteHt=" + prixVenteHt + ", prixVenteTtc=" + prixVenteTtc + ", description=" + description
				+ ", nom=" + nom + ", forfait=" + forfait + ", taux20=" + taux20 + "]";
	}

}
