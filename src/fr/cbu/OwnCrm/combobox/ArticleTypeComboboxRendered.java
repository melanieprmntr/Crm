package fr.cbu.OwnCrm.combobox;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import fr.cbu.OwnCrm.dto.ArticleType;

class ArticleTypeComboboxRendered extends DefaultListCellRenderer {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		ArticleType type = (ArticleType) value;
		String infoType = "";
		if (type != null) {
			infoType = type.getId() + " " + type.getListArticles() + " " + type.getNom();
		}

		Component component = super.getListCellRendererComponent(list, infoType, index, isSelected, cellHasFocus);
		component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return component;
	}
}