package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.balise.Balise;

public class Span extends Balise {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	public Span(String contenu) {
		this.setNom("span");
		this.setContenu(contenu);
	}
}
