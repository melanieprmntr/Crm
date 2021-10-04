package fr.cbu.OwnCrm.view.article;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.OwnCrmObject;

public class ArticleTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7716157448045176990L;

	private List<OwnCrmObject> listArticles = new ArrayList<OwnCrmObject>();

	

	private String[] colonnes = { "nom", "description", "article type" };

	public List<OwnCrmObject> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<OwnCrmObject> listArticles) {
		this.listArticles = listArticles;
	}

	public String[] getColonnes() {
		return colonnes;
	}

	public void setColonnes(String[] colonnes) {
		this.colonnes = colonnes;
	}

	public String getColumnName(int column) {
		return this.colonnes[column];
	}

	@Override
	public int getRowCount() {
		return this.listArticles.size();
	}

	@Override
	public int getColumnCount() {
		return this.colonnes.length;
	}



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Article article = (Article) this.listArticles.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return article.getNom();
		case 1:
			return article.getDescription();
		case 2:
			return article.getArticleType();

		}
		throw new NullPointerException("impossible de déterminer la colonne à afficher pour " + columnIndex);
	}

}
