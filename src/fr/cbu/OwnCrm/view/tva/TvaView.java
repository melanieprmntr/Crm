package fr.cbu.OwnCrm.view.tva;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.service.TvaService;

public class TvaView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Tva tvaCourant;

	private TvaTableModel tableModel = new TvaTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private TvaForm form = new TvaForm(this);

	public TvaView() throws ClassNotFoundException, SQLException {

		this.tableModel.getListTvas().addAll(TvaService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				Tva tva = (Tva) tableModel.getListTvas().get(row);
				System.out.println("Ligne sélectionnée " + tva);
				form.setTvaCourant(tva);
			}

		});
		
		JPanel content = new JPanel();
		
//		this.setLayout(new BorderLayout());
		
		JButton addTva = new JButton("Ajouter");
		this.add(addTva, BorderLayout.PAGE_START);
		addTva.addActionListener(e -> {
			Tva tva = TvaService.getInstance();
			this.setTvaCourant(tva);
		});
		
//		JPanel content = new JPanel(new BorderLayout());
//		this.add(content, BorderLayout.CENTER);
//		
//		content.add(this.scroll, BorderLayout.LINE_START);
//
//		content.add(this.form, BorderLayout.CENTER);


		content.add(addTva);
		addTva.addActionListener(e -> {
			Tva tva = TvaService.getInstance();
			this.setTvaCourant(tva);
		});

		content.add(this.scroll);

		content.add(this.form);

		this.add(content);
		this.setSize(1800, 1000);
		this.setVisible(false);
	}

	public Tva getTvaCourant() {
		return this.tvaCourant;
	}

	public void setTvaCourant(Tva tva) {
		this.tvaCourant = tva;
		if (this.tvaCourant != null) {
			this.form.setTvaCourant(tva);
			this.setVisible(true);
		} else {
			this.form.setTvaCourant(null);
			this.setVisible(false);
		}
	}

	public TvaTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(TvaTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void updateTable(Tva tva) {
		if (!this.getTableModel().getListTvas().contains(tva)) {
			this.getTableModel().getListTvas().add(tva);
		}
		this.getTableModel().fireTableDataChanged();
	}

}
