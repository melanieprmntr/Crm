package fr.cbu.OwnCrm.combobox;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.service.ArticleTypeService;

public class ArticleTypeCombobox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArticleTypeComboboxModel comboBoxModel;

	JComboBox<ArticleType> comboBox;

	public ArticleTypeCombobox() {
		comboBoxModel = new ArticleTypeComboboxModel();
		comboBox = new JComboBox<ArticleType>(comboBoxModel);
		comboBox.setRenderer(new ArticleTypeComboboxRendered());

		this.add(comboBox);
	}

	public void updateComboBox() throws ClassNotFoundException, SQLException {
		comboBoxModel.removeAllElements();
		comboBoxModel.addAll(ArticleTypeService.findAll());
	}

	public void setSelectedItem(ArticleType type) {
		this.comboBoxModel.setSelectedItem(type);
	}

	public ArticleType getSelectedItem() {
		return comboBoxModel.getSelectedItem();
	}
}
