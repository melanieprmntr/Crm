package fr.cbu.OwnCrm.service;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.DevisLigne;

public class DevisLigneService {

		public static DevisLigne getInstance(Article article) {

			DevisLigne devisLigne = new DevisLigne();

			

			devisLigne.setArticleNom(article.getNom());
			devisLigne.setQuantite(1);
			devisLigne.setPrixVenteHt(article.getPrixVenteHt());
			devisLigne.setListTvas(null);
			devisLigne.setPrixVenteTtc(article.getPrixVenteTtc());

			return devisLigne;

		}

		/***
		 * Calcul d'une ligne de panier
		 * @param devisLigne
		 */
		public static void calculDevisLigne(DevisLigne devisLigne) {
			double prixVenteHt = devisLigne.getPrixVenteHt();
			float quantite = devisLigne.getQuantite();
			double prixTotalHt = prixVenteHt *quantite;
			devisLigne.setPrixTotalHt(prixTotalHt);
			TvaService.calculerTva(devisLigne);
		}
	}


