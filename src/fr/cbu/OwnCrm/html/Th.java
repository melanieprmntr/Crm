package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.balise.Balise;

public class Th extends Balise {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Th(String contenu) {
		this.setNom("th");
		this.setContenu(contenu);
		this.setStyle("background-color:#ccc");
	}
}
