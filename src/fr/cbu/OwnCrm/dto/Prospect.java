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


@Entity
@Table(name = "prospect")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prospect extends OwnCrmObject{
	
	public static final String PROSPECT ="PROSPECT";
	public static final String CLIENT = "CLIENT";

	@OneToMany
	private List<Devis> listDevis = new ArrayList<Devis>();
	
	@OneToMany
	private List<Facture> listFactures = new ArrayList<Facture>();

	@Column
	private String raisonsociale;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String telephone;
	
	@Column
	private String adresse;
	
	@Column
	private String codepostal;
	
	@Column
	private String ville;
	
	@Column
	private String email;
	
	@Column
	private String statut = PROSPECT;
	
	@Column
	private String adresseFacturation;
	
	@Column
	private String codepostalFacturation;
	
	@Column
	private String villeFacturation;
	
	@Column
	private String modePaiement;

	public List<Devis> getListDevis() {
		return listDevis;
	}

	public void setListDevis(List<Devis> listDevis) {
		this.listDevis = listDevis;
	}

	public List<Facture> getListFactures() {
		return listFactures;
	}

	public void setListFactures(List<Facture> listFactures) {
		this.listFactures = listFactures;
	}

	public String getRaisonsociale() {
		return raisonsociale;
	}

	public void setRaisonsociale(String raisonsociale) {
		this.raisonsociale = raisonsociale;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public static String getProspect() {
		return PROSPECT;
	}

	public static String getClient() {
		return CLIENT;
	}

	public String getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getCodepostalFacturation() {
		return codepostalFacturation;
	}

	public void setCodepostalFacturation(String codepostalFacturation) {
		this.codepostalFacturation = codepostalFacturation;
	}

	public String getVilleFacturation() {
		return villeFacturation;
	}

	public void setVilleFacturation(String villeFacturation) {
		this.villeFacturation = villeFacturation;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	@Override
	public String toString() {
		return "Prospect [listDevis=" + listDevis + ", listFactures=" + listFactures + ", raisonsociale="
				+ raisonsociale + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", adresse="
				+ adresse + ", codepostal=" + codepostal + ", ville=" + ville + ", email=" + email + ", statut="
				+ statut + ", adresseFacturation=" + adresseFacturation + ", codepostalFacturation="
				+ codepostalFacturation + ", villeFacturation=" + villeFacturation + ", modePaiement=" + modePaiement
				+ "]";
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
