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


@Entity(name = "articletype")
@Table(name = "articletype")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ArticleType extends OwnCrmObject {
	
	@Column
	private String nom;
	
	@OneToMany
	private List<Article> listArticles = new ArrayList<Article>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	@Override
	public String toString() {
		return "ArticleType [nom=" + nom + ", listArticles=" + listArticles + "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
