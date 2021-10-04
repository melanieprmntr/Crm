package fr.cbu.OwnCrm.view.articleType;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.OwnCrmObject;

public class ArticleTypeTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7716157448045176990L;

	private List<OwnCrmObject> listArticlesType = new ArrayList<OwnCrmObject>();

	private String[] colonnes = { "nom", "listArticleTypes"};

	

	public List<OwnCrmObject> getListArticlesType() {
		return listArticlesType;
	}



	public void setListArticlesType(List<OwnCrmObject> listArticlesType) {
		this.listArticlesType = listArticlesType;
	}



	public String[] getColonnes() {
		return colonnes;
	}



	public void setColonnes(String[] colonnes) {
		this.colonnes = colonnes;
	}



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Article article = (Article) this.listArticlesType.get(rowIndex);
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



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
