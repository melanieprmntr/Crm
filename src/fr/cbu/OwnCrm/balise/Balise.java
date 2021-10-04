package fr.cbu.OwnCrm.balise;

import java.util.ArrayList;

public class Balise extends ArrayList<Balise> {

	private static final long serialVersionUID = 1L;

	private String nom;

	private String value;

	private String contenu;

	private String style;

	private String clazz;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		String result = "<" + this.nom;

		if (value != null) {
			result += " value=\"" + value + "\"";
		}

		if (style != null) {
			result += " style=\"" + style + "\"";
		}

		if (clazz != null) {
			result += " class=\"" + clazz + "\"";
		}

		result += " biblio=\"" + this.getClass().getSimpleName() + "\"";

		result += ">\n";

		if (contenu != null) {
			result += contenu;
		}

		for (Balise balise : this) {
			result += balise;
		}

		result += "</" + this.nom + ">\n";

		return result;
	}

}
