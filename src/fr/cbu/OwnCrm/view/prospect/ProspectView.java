package fr.cbu.OwnCrm.view.prospect;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.service.ProspectService;

public class ProspectView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Prospect prospectCourant;

	private ProspectTableModel tableModel = new ProspectTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private ProspectForm form = new ProspectForm(this);

	public ProspectView() throws ClassNotFoundException, SQLException {

		this.tableModel.getListProspects().addAll(ProspectService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				Prospect prospect = (Prospect) tableModel.getListProspects().get(row);
				System.out.println("Ligne sélectionnée " + prospect);
				form.setProspectCourant(prospect);
			}

		});

		JPanel content = new JPanel();

		JButton addProspect = new JButton("Ajouter");
		content.add(addProspect);
		addProspect.addActionListener(e -> {
			Prospect prospect = ProspectService.getInstance();
			this.setProspectCourant(prospect);
		});

		content.add(this.scroll);

		content.add(this.form);

		this.add(content);
		this.setSize(1800, 1000);
		this.setVisible(false);
	}

	public Prospect getProspectCourant() {
		return this.prospectCourant;
	}

	public void setProspectCourant(Prospect prospect) {
		this.prospectCourant = prospect;
		if (this.prospectCourant != null) {
			this.form.setProspectCourant(prospect);
			this.setVisible(true);
		} else {
			this.form.setProspectCourant(null);
			this.setVisible(false);
		}
	}

	public ProspectTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(ProspectTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void updateTable(Prospect prospect) {
		if (!this.getTableModel().getListProspects().contains(prospect)) {
			this.getTableModel().getListProspects().add(prospect);
		}
		this.getTableModel().fireTableDataChanged();
	}

}
