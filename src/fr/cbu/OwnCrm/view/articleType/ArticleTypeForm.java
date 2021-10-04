package fr.cbu.OwnCrm.view.articleType;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.service.ArticleTypeService;

public class ArticleTypeForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleTypeView view;

	private ArticleType articleTypeCourant;

	private JLabel labelNom = new JLabel("nom", 10);
	private JTextField nom = new JTextField("nom", 40);

	public ArticleTypeForm(ArticleTypeView view) {
		this.view = view;

		JPanel content = new JPanel(new GridLayout(0, 2));
		this.add(content);

		JButton saveBtn = new JButton("enregistrer");
		saveBtn.addActionListener(e -> save());
		content.add(saveBtn);

		JButton closeBtn = new JButton("fermer");
		closeBtn.addActionListener(e -> {
			try {
				close();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		});
		content.add(closeBtn);

		content.add(labelNom);
		content.add(nom);

		this.setVisible(false);
	}

	private void save() {
		writeBean();
		try {
			ArticleTypeService.save(this.articleTypeCourant);
			this.view.updateTable(this.articleTypeCourant);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur SQL", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void close() throws ClassNotFoundException, SQLException {
		this.setArticleTypeCourant(null);
	}

	public ArticleType getArticleTypeCourant() {
		return articleTypeCourant;
	}

	public void setArticleTypeCourant(ArticleType articleTypeCourant) {
		this.articleTypeCourant = articleTypeCourant;
		if (this.articleTypeCourant != null) {
			readBean();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}

	public void readBean() {
		this.nom.setText(this.articleTypeCourant.getNom());

	}

	public void writeBean() {
		this.articleTypeCourant.setNom(this.nom.getText());

	}
}
