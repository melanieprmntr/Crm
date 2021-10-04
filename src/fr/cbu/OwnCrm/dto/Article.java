package fr.cbu.OwnCrm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name = "article")
@Table(name = "article")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Article extends OwnCrmObject{

	@Column
	private String nom;
	
	@Column
	private String description;
	
	@ManyToOne
	private ArticleType articleType;
	
	@Column
	private double prixVenteHt;
	
	@Column
	private double prixVenteTtc;
	
	@ManyToOne
	private DevisLigne devisLigne;
	
	@ManyToOne
	private Tva tva;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArticleType getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
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

	public Tva getTva() {
		return tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	
	public DevisLigne getDevisLigne() {
		return devisLigne;
	}

	public void setDevisLigne(DevisLigne devisLigne) {
		this.devisLigne = devisLigne;
	}

	@Override
	public String toString() {

		String infoArticleType = "pas de type article";
		if (this.articleType != null) {
			infoArticleType = articleType.getNom();
		}

		return "Article [nom=" + nom + ", description=" + description + ", articleType=" + infoArticleType
				+ ", prixVenteHt=" + prixVenteHt + ", prixVenteTtc=" + prixVenteTtc + ", tva=" + tva + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
