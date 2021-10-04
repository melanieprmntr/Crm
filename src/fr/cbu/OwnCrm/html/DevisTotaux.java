package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.dto.Devis;

public class DevisTotaux extends Div {

	private static final long serialVersionUID = 1L;

	public DevisTotaux(Devis devis) {

		this.setStyle("width:300px;background-color: #eaeaea;padding:5px;margin:5px");

		this.add(new Totaux("Prix vente total HT", String.valueOf(devis.getPrixVenteHtTotal()), "€ HT"));
		this.add(new Totaux("Montant TVA", String.valueOf(devis.getMontantTvaTotal()), "€"));
		this.add(new Totaux("Prix vente total TTC", String.valueOf(devis.getPrixVenteTtcTotal()), "€ TTC"));

	}

}
