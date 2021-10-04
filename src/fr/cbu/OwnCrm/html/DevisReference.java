package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.dto.Devis;

public class DevisReference extends Div {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579171447257847230L;

	public DevisReference(Devis devis) {
		this.add(new Span("Crée le <b>" + devis.getDateCreation() + "</b>"));
		this.add(new Span("Devis numéro <b>" + devis.getNumeroDevis() + "</b>"));

	}
}
