package fr.cbu.OwnCrm.html;

import fr.cbu.OwnCrm.dto.Prospect;

public class PropectAdresse extends Div {

	private static final long serialVersionUID = 1L;

	public PropectAdresse(Prospect prospect) {

		this.setStyle("width:300px");

		Span spanRaisonSociale = new Span(prospect.getRaisonsociale());
		spanRaisonSociale.setStyle("font-weight:bold");

		this.add(spanRaisonSociale);

		this.add(new Span(prospect.getPrenom() + " " + prospect.getNom()));
		this.add(new Span(prospect.getAdresse()));
		this.add(new Span(prospect.getCodepostal() + " " + prospect.getVille()));
	}

}
