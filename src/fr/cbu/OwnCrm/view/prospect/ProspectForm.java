package fr.cbu.OwnCrm.view.prospect;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.service.ProspectService;

public class ProspectForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProspectView view;

	private Prospect prospectCourant;

	private JLabel labelRaisonSociale = new JLabel("raison sociale");
	private JTextField raisonSociale = new JTextField("raison sociale", 20);

	private JLabel labelNom = new JLabel("nom");
	private JTextField nom = new JTextField("nom", 40);

	private JLabel labelPrenom = new JLabel("prénom");
	private JTextField prenom = new JTextField("prenom", 20);

	private JLabel labelTelephone = new JLabel("téléphone");
	private JTextField telephone = new JTextField("téléphone", 10);

	private JLabel labelAdresse = new JLabel("adresse");
	private JTextField adresse = new JTextField("adresse", 80);

	private JLabel labelCodePostal = new JLabel("CP");
	private JTextField codePostal = new JTextField("CP", 5);

	private JLabel labelVille = new JLabel("ville");
	private JTextField ville = new JTextField("ville", 20);

	private JLabel labelEmail = new JLabel("email");
	private JTextField email = new JTextField("email", 20);

	public ProspectForm(ProspectView view) {
		this.view = view;

		JPanel content = new JPanel(new GridLayout(0, 2));
		this.add(content);

		JButton saveBtn = new JButton("enregistrer");
		saveBtn.addActionListener(e -> save());
		content.add(saveBtn);

		JButton closeBtn = new JButton("fermer");
		closeBtn.addActionListener(e -> close());
		content.add(closeBtn);

		content.add(labelRaisonSociale);
		content.add(raisonSociale);

		content.add(labelNom);
		content.add(nom);

		content.add(labelPrenom);
		content.add(prenom);

		content.add(labelTelephone);
		content.add(telephone);

		content.add(labelAdresse);
		content.add(adresse);

		content.add(labelCodePostal);
		content.add(codePostal);

		content.add(labelVille);
		content.add(ville);

		content.add(labelEmail);
		content.add(email);

		this.setVisible(false);
	}

	private void save() {
		writeBean();
		try {
			ProspectService.save(this.prospectCourant);
			this.view.updateTable(this.prospectCourant);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur SQL", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void close() {
		this.setProspectCourant(null);
	}

	public Prospect getProspectCourant() {
		return prospectCourant;
	}

	public void setProspectCourant(Prospect prospectCourant) {
		this.prospectCourant = prospectCourant;
		if (this.prospectCourant != null) {
			readBean();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}

	public void readBean() {
		this.raisonSociale.setText(this.prospectCourant.getRaisonsociale());
		this.nom.setText(this.prospectCourant.getNom());
		this.prenom.setText(this.prospectCourant.getPrenom());
		this.telephone.setText(this.prospectCourant.getTelephone());
		this.adresse.setText(this.prospectCourant.getAdresse());
		this.codePostal.setText(this.prospectCourant.getCodepostal());
		this.ville.setText(this.prospectCourant.getVille());
		this.email.setText(this.prospectCourant.getEmail());
	}

	public void writeBean() {
		this.prospectCourant.setRaisonsociale(this.raisonSociale.getText());
		this.prospectCourant.setNom(this.nom.getText());
		this.prospectCourant.setPrenom(this.prenom.getText());
		this.prospectCourant.setTelephone(this.telephone.getText());
		this.prospectCourant.setAdresse(this.adresse.getText());
		this.prospectCourant.setCodepostal(this.codePostal.getText());
		this.prospectCourant.setVille(this.ville.getText());
		this.prospectCourant.setEmail(this.email.getText());
	}
}
