package fr.cbu.OwnCrm.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "DEVISLIGNE")
@Table(name = "DEVISLIGNE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DevisLigne extends OwnCrmObject{

	@ManyToOne
	private Devis devis;
	
	@OneToMany
	private List<Article> ListArticles = new ArrayList<Article>();
	
	@Column
	private String articleNom;
	
	@Column
	private float quantite;
	
	@Column
	private double prixVenteHt;
	
	@Column
	private double prixVenteTtc;
	
	@OneToMany
	private List<Tva> ListTvas = new ArrayList<Tva>();
	
	@Column
	private double montantTva;
	
	@Column
	private double prixTotalHt;
	
	@Column
	private double prixTotalTtc;

	public double getPrixTotalHt() {
		return prixTotalHt;
	}

	public void setPrixTotalHt(double prixTotalHt) {
		this.prixTotalHt = prixTotalHt;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}


	public List<Article> getListArticles() {
		return ListArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		ListArticles = listArticles;
	}

	public String getArticleNom() {
		return articleNom;
	}

	public void setArticleNom(String articleNom) {
		this.articleNom = articleNom;
	}

	public float getQuantite() {
		return quantite;
	}

	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}

	public double getPrixVenteHt() {
		return prixVenteHt;
	}

	public void setPrixVenteHt(double prixVenteHt) {
		this.prixVenteHt = prixVenteHt;
	}

	public double getPrixVenteTtc() {
		return prixVenteTtc;
	}

	public void setPrixVenteTtc(double prixVenteTtc) {
		this.prixVenteTtc = prixVenteTtc;
	}

	

	public List<Tva> getListTvas() {
		return ListTvas;
	}

	public void setListTvas(List<Tva> listTvas) {
		ListTvas = listTvas;
	}

	public double getMontantTva() {
		return montantTva;
	}

	public void setMontantTva(double montantTva) {
		this.montantTva = montantTva;
	}

	public double getPrixTotalTtc() {
		return prixTotalTtc;
	}

	public void setPrixTotalTtc(double prixTotalTtc) {
		this.prixTotalTtc = prixTotalTtc;
	}

	@Override
	public String toString() {
		return "DevisLigne [devis=" + devis + ", ListArticles=" + ListArticles + ", articleNom=" + articleNom
				+ ", quantite=" + quantite + ", prixVenteHt=" + prixVenteHt + ", prixVenteTtc=" + prixVenteTtc
				+ ", ListTvas=" + ListTvas + ", montantTva=" + montantTva + ", prixTotalHt=" + prixTotalHt
				+ ", prixTotalTtc=" + prixTotalTtc + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
