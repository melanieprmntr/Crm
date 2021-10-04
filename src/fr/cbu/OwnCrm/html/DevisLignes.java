package fr.cbu.OwnCrm.html;

import java.util.List;

import fr.cbu.OwnCrm.dto.Devis;
import fr.cbu.OwnCrm.dto.DevisLigne;

public class DevisLignes extends Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public DevisLignes(Devis devis) {

			List<DevisLigne> listDevisLignes = devis.getListDevisLignes();

			Tr trEntete = new Tr();
			this.add(trEntete);

			Th thArticleNom = new Th("Article");
			trEntete.add(thArticleNom);

			Th thPrixHt = new Th("Prix HT");
			trEntete.add(thPrixHt);

			Th thQuantite = new Th("Quantité");
			trEntete.add(thQuantite);

			Th thPrixTotalHt = new Th("Prix total HT");
			trEntete.add(thPrixTotalHt);

			for (DevisLigne devisLigne : listDevisLignes) {
				Tr tr = new Tr();
				this.add(tr);

				Td tdArticleNom = new Td(devisLigne.getArticleNom());
				tr.add(tdArticleNom);

				Td tdPrixVenteHtUnitaire = new Td(String.valueOf(devisLigne.getPrixVenteHt()));
				tdPrixVenteHtUnitaire.setStyle("text-align:right");
				tr.add(tdPrixVenteHtUnitaire);

				Td tdQuantite = new Td(String.valueOf(devisLigne.getQuantite()));
				tdQuantite.setStyle("text-align:right");
				tr.add(tdQuantite);

				Td tdPrixVenteHtTotal = new Td(String.valueOf(devisLigne.getPrixTotalHt()));
				tdPrixVenteHtTotal.setStyle("text-align:right");
				tr.add(tdPrixVenteHtTotal);
			}
		}
}
