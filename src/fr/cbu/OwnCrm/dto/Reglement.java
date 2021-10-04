package fr.cbu.OwnCrm.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "reglement")
@Table(name = "reglement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reglement extends OwnCrmObject {

	@Column
	private String modeReglement;

	@Column
	private LocalDate dateReglement;

	@OneToMany
	private List<Facture> listFactures = new ArrayList<Facture>();


	public List<Facture> getListFactures() {
		return listFactures;
	}

	public void setListFactures(List<Facture> listFactures) {
		this.listFactures = listFactures;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}

	public LocalDate getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(LocalDate dateReglement) {
		this.dateReglement = dateReglement;
	}

	@Override
	public String toString() {
		return "Reglement [modeReglement=" + modeReglement + ", dateReglement=" + dateReglement + ", listFactures="
				+ listFactures + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return "je suis un réglement";
	}

}
