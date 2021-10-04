package fr.cbu.OwnCrm.view.tva;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.service.TvaService;

public class TvaForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TvaView view;

	private Tva tvaCourant;

	private JLabel labelTaux = new JLabel("taux");
	private JTextField taux = new JTextField("taux", 20);

	private JLabel labelCoef = new JLabel("coef");
	private JTextField coef = new JTextField("coef", 40);
	
	private JLabel titre = new JLabel("Vous éditez ... ");



	public TvaForm(TvaView view) {
		this.view = view;
		

		this.setLayout(new GridLayout(0, 1));
		

		this.add(getHeader());

		this.add(getTitre());

		this.add(getContent());

		this.setVisible(false);

//
//		JPanel content = new JPanel(new GridLayout(0, 2));
//		this.add(content);
//
//		JButton saveBtn = new JButton("enregistrer");
//		saveBtn.addActionListener(e -> save());
//		content.add(saveBtn);
//
//		JButton closeBtn = new JButton("fermer");
//		closeBtn.addActionListener(e -> close());
//		content.add(closeBtn);
//
//		content.add(labelTaux);
//		content.add(taux);
//
//		content.add(labelCoef);
//		content.add(coef);
//
//		this.setVisible(false);
	}
	
	
	public JPanel getHeader() {
		FlowLayout layout = new FlowLayout();
		JPanel header = new JPanel(layout);
		header.setPreferredSize(new Dimension(200, 10));

		JButton saveBtn = new JButton("enregistrer");
		saveBtn.addActionListener(e -> save());
		header.add(saveBtn);

		JButton closeBtn = new JButton("fermer");
		closeBtn.addActionListener(e -> close());
		header.add(closeBtn);

		return header;
	}

	public JPanel getTitre() {
		FlowLayout layout = new FlowLayout();
		JPanel panel = new JPanel(layout);
		panel.setPreferredSize(new Dimension(200, 10));

		titre.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panel.add(titre);

		return panel;
	}

	public JPanel getContent() {
		JPanel content = new JPanel(new GridLayout(0,1));
		content.setPreferredSize(new Dimension(200, 200));

		JPanel informations = new JPanel(new FlowLayout());
		informations.setPreferredSize(new Dimension(200, 100));
		
		informations.add(labelTaux);
		informations.add(taux);

		informations.add(labelCoef);
		informations.add(coef);

		return content;
	}


	private void save() {
		writeBean();
		try {
			TvaService.save(this.tvaCourant);
			this.view.updateTable(this.tvaCourant);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur SQL", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void close() {
		this.setTvaCourant(null);
	}

	public Tva getTvaCourant() {
		return tvaCourant;
	}

	public void setTvaCourant(Tva tvaCourant) {
		this.tvaCourant = tvaCourant;
		if (this.tvaCourant != null) {
			readBean();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}

	public void readBean() {
		this.taux.setText(String.valueOf(this.tvaCourant.getTaux()));
		this.coef.setText(String.valueOf(this.tvaCourant.getCoef()));

	}

	public void writeBean() {
		this.tvaCourant.setTaux(Double.valueOf(this.taux.getText()));
		this.tvaCourant.setCoef(Double.valueOf(this.coef.getText()));

	}
}
