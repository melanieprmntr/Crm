package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.balise.Balise;

public class Td extends Balise {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Td(String contenu) {
		this.setNom("td");
		this.setContenu(contenu);
	}
}
