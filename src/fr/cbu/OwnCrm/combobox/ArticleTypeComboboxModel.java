package fr.cbu.OwnCrm.combobox;

import javax.swing.DefaultComboBoxModel;

import fr.cbu.OwnCrm.dto.ArticleType;

public class ArticleTypeComboboxModel extends DefaultComboBoxModel<ArticleType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleTypeComboboxModel() {
	}

	@Override
	public ArticleType getSelectedItem() {
		ArticleType selectedArticle = (ArticleType) super.getSelectedItem();
		return selectedArticle;
	}
}