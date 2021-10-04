package fr.cbu.OwnCrm.combobox;

import javax.swing.DefaultComboBoxModel;

import fr.cbu.OwnCrm.dto.Tva;



public class TvaComboboxModel extends DefaultComboBoxModel<Tva> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TvaComboboxModel() {
	}

	@Override
	public Tva getSelectedItem() {
		Tva selectedTva = (Tva) super.getSelectedItem();
		return selectedTva;
	}
}