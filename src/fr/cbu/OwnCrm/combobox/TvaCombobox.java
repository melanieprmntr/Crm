package fr.cbu.OwnCrm.combobox;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.service.TvaService;

public class TvaCombobox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TvaComboboxModel comboBoxModel;

	JComboBox<Tva> comboBox;

	public TvaCombobox() {
		comboBoxModel = new TvaComboboxModel();
		comboBox = new JComboBox<Tva>(comboBoxModel);
		comboBox.setRenderer(new TvaComboboxRendered());

		this.add(comboBox);
	}

	public void updateComboBox() {
		try {
			comboBoxModel.removeAllElements();
			comboBoxModel.addAll(TvaService.findAll());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void setSelectedItem(Tva tva) {
		this.comboBoxModel.setSelectedItem(tva);
	}

	public Tva getSelectedItem() {
		return comboBoxModel.getSelectedItem();
	}
}
