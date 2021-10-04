package fr.cbu.OwnCrm.view.articleType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.service.ArticleTypeService;

public class ArticleTypeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleType articleTypeCourant;

	private ArticleTypeTableModel tableModel = new ArticleTypeTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private ArticleTypeForm form = new ArticleTypeForm(this);

	public ArticleTypeView() throws ClassNotFoundException, SQLException {

		this.tableModel.getListArticlesType().addAll(ArticleTypeService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				ArticleType articleType = (ArticleType) tableModel.getListArticlesType().get(row);
				System.out.println("Ligne sélectionnée " + articleType);

				form.setArticleTypeCourant(articleType);

			}

		});

		JPanel content = new JPanel();

		JButton addArticleType = new JButton("Ajouter");
		content.add(addArticleType);
		addArticleType.addActionListener(e -> {
			ArticleType articleType = ArticleTypeService.getInstance();

			this.setArticleTypeCourant(articleType);

		});

		content.add(this.scroll);

		content.add(this.form);

		this.add(content);
		this.setSize(800, 800);
		this.setVisible(false);
	}

	public ArticleType getArticleTypeCourant() {
		return this.articleTypeCourant;
	}

	public void setArticleTypeCourant(ArticleType articleType) {
		this.articleTypeCourant = articleType;
		if (this.articleTypeCourant != null) {
			this.form.setArticleTypeCourant(articleType);
			this.setVisible(true);
		} else {
			this.form.setArticleTypeCourant(null);
			this.setVisible(false);
		}
	}

	public ArticleTypeTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(ArticleTypeTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void updateTable(ArticleType articleTypeCourant) {
		if (!this.getTableModel().getListArticlesType().contains(articleTypeCourant)) {
			this.getTableModel().getListArticlesType().add(articleTypeCourant);

		}
		this.getTableModel().fireTableDataChanged();
	}

}
