package fr.cbu.OwnCrm.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "tva")
@Table(name = "tva")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tva extends OwnCrmObject{
	
	@Column
	private double taux;

	@Column
	private double coef;
	
	@OneToMany
	private List<Article> listArticles = new ArrayList<Article>();

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}
	
	

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	@Override
	public String toString() {
		return "Tva [taux=" + taux + ", coef=" + coef + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
