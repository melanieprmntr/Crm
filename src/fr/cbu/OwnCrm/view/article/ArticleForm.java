package fr.cbu.OwnCrm.view.article;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.cbu.OwnCrm.combobox.ArticleTypeCombobox;
import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.service.ArticleService;

public class ArticleForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleView view;

	private Article articleCourant;

//		private JLabel labelGenre = new JLabel("genre", 10);
//		private GenreCombobox genre = new GenreCombobox();

	private JLabel labelNom = new JLabel("nom", 10);
	private JTextField nom = new JTextField("nom", 40);

	private JLabel labelDescription = new JLabel("description");
	private JTextField description = new JTextField("description", 20);

	private JLabel labelPrixVenteHt = new JLabel("prixVenteHt");
	private JTextField prixVenteHt = new JTextField("prixVenteHt", 10);

	private JLabel labelTva = new JLabel("tva");
	private JTextField tva = new JTextField("tva", 80);

	private JLabel labelArticleType = new JLabel("articleType");
	private ArticleTypeCombobox articleTypeCombobox = new ArticleTypeCombobox();

	public ArticleForm(ArticleView view) {
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		content.add(closeBtn);

		content.add(labelNom);
		content.add(nom);

		content.add(labelPrixVenteHt);
		content.add(prixVenteHt);

		content.add(labelDescription);
		content.add(description);

		content.add(labelTva);
		content.add(tva);

		content.add(labelArticleType);
		content.add(articleTypeCombobox);

		this.setVisible(false);
	}

	private void save() {
		writeBean();
		try {
			ArticleService.save(this.articleCourant);
			this.view.updateTable(this.articleCourant);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur SQL", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void close() throws ClassNotFoundException, SQLException {
		this.setArticleCourant(null);
	}

	public Article getArticleCourant() {
		return articleCourant;
	}

	public void setArticleCourant(Article articleCourant) throws ClassNotFoundException, SQLException {
		this.articleCourant = articleCourant;
		if (this.articleCourant != null) {
			readBean();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}

	public void readBean() throws ClassNotFoundException, SQLException {
		this.nom.setText(this.articleCourant.getNom());
		this.description.setText(this.articleCourant.getDescription());
		this.prixVenteHt.setText(String.valueOf(this.articleCourant.getPrixVenteHt()));
		this.tva.setText(String.valueOf(this.articleCourant.getTva()));
		this.articleTypeCombobox.updateComboBox();
		this.articleTypeCombobox.setSelectedItem(articleCourant.getArticleType());
	}

	public void writeBean() {
		this.articleCourant.setNom(this.nom.getText());
		this.articleCourant.setDescription(this.description.getText());
		this.articleCourant.setPrixVenteHt(Double.valueOf(this.prixVenteHt.getText()));
		this.articleCourant.setArticleType(this.articleTypeCombobox.getSelectedItem());

	}
}
