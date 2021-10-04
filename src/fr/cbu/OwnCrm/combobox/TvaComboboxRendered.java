package fr.cbu.OwnCrm.combobox;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import fr.cbu.OwnCrm.dto.Tva;



public class TvaComboboxRendered extends DefaultListCellRenderer {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Tva tva = (Tva) value;
		String infoTva = "";
		if (tva != null) {
			infoTva = String.valueOf(tva.getTaux());
		}

		Component component = super.getListCellRendererComponent(list, infoTva, index, isSelected, cellHasFocus);
		component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return component;
	}
}