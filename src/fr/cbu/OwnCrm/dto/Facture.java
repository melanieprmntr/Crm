package fr.cbu.OwnCrm.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name = "facture")
@Table(name = "facture")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Facture extends Devis {

	@Column
	private int numeroFacture;
	
	@Column
	private LocalDate dateCreation;
	
	@ManyToOne
	private Reglement reglement;
	
	@Column
	private String dateFinPrestation;

	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Reglement getReglement() {
		return reglement;
	}

	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}

	public String getDateFinPrestation() {
		return dateFinPrestation;
	}

	public void setDateFinPrestation(String dateFinPrestation) {
		this.dateFinPrestation = dateFinPrestation;
	}

	@Override
	public String toString() {
		return "Facture [numeroFacture=" + numeroFacture + ", dateCreation=" + dateCreation + ", reglement=" + reglement
				+ ", dateFinPrestation=" + dateFinPrestation + "]";
	}

}
