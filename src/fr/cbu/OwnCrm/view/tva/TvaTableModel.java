package fr.cbu.OwnCrm.view.tva;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.cbu.OwnCrm.dto.OwnCrmObject;
import fr.cbu.OwnCrm.dto.Tva;

public class TvaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OwnCrmObject> listTvas = new ArrayList<OwnCrmObject>();

	private String[] colonnes = { "taux", "coef"};

	public List<OwnCrmObject> getListTvas() {
		return listTvas;
	}

	public void setListTvas(List<OwnCrmObject> listTvas) {
		this.listTvas = listTvas;
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
		return this.listTvas.size();
	}

	@Override
	public int getColumnCount() {
		return this.colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tva tva = (Tva) this.listTvas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tva.getTaux();
		case 1:
			return tva.getCoef();
	
		}
		throw new NullPointerException("impossible de déterminer la colonne à afficher pour " + columnIndex);
	}

}
