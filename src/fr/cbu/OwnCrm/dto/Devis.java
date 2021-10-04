package fr.cbu.OwnCrm.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "devis")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Devis extends OwnCrmObject {

	@OneToMany
	private List<DevisLigne> ListDevisLignes = new ArrayList<DevisLigne>();

	@ManyToOne
	private Prospect prospect;

	@Column
	private int numeroDevis;

	@Column
	private LocalDate dateCreation;

	@Column
	private double prixVenteHtTotal;

	@Column
	private double prixVenteTtcTotal;

	@Column
	private double montantTvaTotal;

	public Devis() {

		
	}

	public Devis(int numeroDevis) {
		this.numeroDevis= numeroDevis;
	}

	public int getNumeroDevis() {
		return numeroDevis;
	}

	public void setNumeroDevis(int numeroDevis) {
		this.numeroDevis = numeroDevis;
	}

	public List<DevisLigne> getListDevisLignes() {
		return ListDevisLignes;
	}

	public void setListDevisLignes(List<DevisLigne> listDevisLignes) {
		ListDevisLignes = listDevisLignes;
	}

	public Prospect getProspect() {
		return prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getPrixVenteHtTotal() {
		return prixVenteHtTotal;
	}

	public void setPrixVenteHtTotal(double prixVenteHtTotal) {
		this.prixVenteHtTotal = prixVenteHtTotal;
	}

	public double getPrixVenteTtcTotal() {
		return prixVenteTtcTotal;
	}

	public void setPrixVenteTtcTotal(double prixVenteTtcTotal) {
		this.prixVenteTtcTotal = prixVenteTtcTotal;
	}

	public double getMontantTvaTotal() {
		return montantTvaTotal;
	}

	public void setMontantTvaTotal(double montantTvaTotal) {
		this.montantTvaTotal = montantTvaTotal;
	}

	@Override
	public String toString() {
		return "Devis [ListDevisLignes=" + ListDevisLignes + ", prospect=" + prospect + ", numeroDevis=" + numeroDevis
				+ ", dateCreation=" + dateCreation + ", prixVenteHtTotal=" + prixVenteHtTotal + ", prixVenteTtcTotal="
				+ prixVenteTtcTotal + ", montantTvaTotal=" + montantTvaTotal + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
