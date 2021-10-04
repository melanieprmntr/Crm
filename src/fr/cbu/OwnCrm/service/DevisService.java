package fr.cbu.OwnCrm.service;

import java.util.List;

import fr.cbu.OwnCrm.ApplicationLauncher;
import fr.cbu.OwnCrm.dto.Devis;
import fr.cbu.OwnCrm.dto.DevisLigne;

public class DevisService {

	

		public static Devis getInstance(int numeroDevis) {

			if (ApplicationLauncher.DEBUG) {
				System.out.println("DEBUG : ajout d'un panier " + numeroDevis);
			}

			Devis devis = new Devis(numeroDevis);
			return devis;
		}

		public static void addDevisLigne(Devis devis, DevisLigne devisLigne) {
			devis.getListDevisLignes().add(devisLigne);
			devisLigne.setDevis(devis);
		}

		public static void removeDevisLigne(DevisLigne devisLigne) {
			Devis devis = devisLigne.getDevis();
			devis.getListDevisLignes().remove(devisLigne);
			devisLigne.setDevis(null);
		}

		/***
		 * Méthode permettant de calculer le montant total du panier Elle fait la sommes
		 * des totaux HT et TTC, elle fait la somme des montant de tva
		 * 
		 * @param panier
		 */
		public static void calculDevis(Devis devis) {
			List<DevisLigne> listDevisLignes = devis.getListDevisLignes();
			double prixVenteTotalHt = 0d;
			double montantTvaTotal = 0d;
			double prixVenteTotalTtc = 0d;
			for (DevisLigne devisLigne : listDevisLignes) {

				DevisLigneService.calculDevisLigne(devisLigne);

				prixVenteTotalHt = prixVenteTotalHt + devisLigne.getPrixTotalHt();
				montantTvaTotal = montantTvaTotal + devisLigne.getMontantTva();
				prixVenteTotalTtc = prixVenteTotalTtc + devisLigne.getPrixTotalTtc();
			}
			devis.setPrixVenteHtTotal(prixVenteTotalHt);
			devis.setMontantTvaTotal(montantTvaTotal);
			devis.setPrixVenteTtcTotal(prixVenteTotalTtc);
		}

	}


