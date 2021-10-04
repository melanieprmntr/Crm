package fr.cbu.OwnCrm.view.prospect;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.cbu.OwnCrm.dto.OwnCrmObject;
import fr.cbu.OwnCrm.dto.Prospect;

public class ProspectTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OwnCrmObject> listProspects = new ArrayList<OwnCrmObject>();

	private String[] colonnes = { "nom", "prénom", "téléphone" };

	public List<OwnCrmObject> getListProspects() {
		return listProspects;
	}

	public void setListProspects(List<OwnCrmObject> listProspects) {
		this.listProspects = listProspects;
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
		return this.listProspects.size();
	}

	@Override
	public int getColumnCount() {
		return this.colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Prospect prospect = (Prospect) this.listProspects.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return prospect.getNom();
		case 1:
			return prospect.getPrenom();
		case 2:
			return prospect.getTelephone();
		}
		throw new NullPointerException("impossible de déterminer la colonne à afficher pour " + columnIndex);
	}

}
