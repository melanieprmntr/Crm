package fr.cbu.OwnCrm.service;

import fr.cbu.OwnCrm.ApplicationLauncher;
import fr.cbu.OwnCrm.dto.Utilisateur;

public class UtilisateurService {
	
	public static Utilisateur getInstance() {

		if (ApplicationLauncher.DEBUG) {
			System.out.println("DEBUG : ajout d'un utilisateur ");
		}
		return new Utilisateur();
	}

	public static Utilisateur getInstance(String raisonSociale,String prenom, String nom,  String telephone,
			String adresse, String codePostal, String ville,String email) {

		if (ApplicationLauncher.DEBUG) {
			System.out.println("DEBUG : ajout d'un utilisateur " + prenom + nom);
		}

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setRaisonsociale(raisonSociale);
		utilisateur.setPrenom(prenom);
		utilisateur.setNom(nom);
		utilisateur.setTelephone(telephone);
		utilisateur.setAdresse(adresse);
		utilisateur.setCodepostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setEmail(email);
		return utilisateur;
	}

}
