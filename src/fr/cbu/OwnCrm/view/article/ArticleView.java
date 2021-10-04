package fr.cbu.OwnCrm.view.article;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.service.ArticleService;

public class ArticleView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Article articleCourant;

	private ArticleTableModel tableModel = new ArticleTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private ArticleForm form = new ArticleForm(this);

	public ArticleView() throws ClassNotFoundException, SQLException {

		this.tableModel.getListArticles().addAll(ArticleService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				Article article = (Article) tableModel.getListArticles().get(row);
				System.out.println("Ligne sélectionnée " + article);
				try {
					form.setArticleCourant(article);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JPanel content = new JPanel();

		JButton addArticle = new JButton("Ajouter");
		content.add(addArticle);
		addArticle.addActionListener(e -> {
			Article article = ArticleService.getInstance();
			try {
				this.setArticleCourant(article);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		content.add(this.scroll);

		content.add(this.form);

		this.add(content);
		this.setSize(800, 800);
		this.setVisible(false);
	}

	public Article getArticleCourant() {
		return this.articleCourant;
	}

	public void setArticleCourant(Article article) throws ClassNotFoundException, SQLException {
		this.articleCourant = article;
		if (this.articleCourant != null) {
			this.form.setArticleCourant(article);
			this.setVisible(true);
		} else {
			this.form.setArticleCourant(null);
			this.setVisible(false);
		}
	}

	public ArticleTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(ArticleTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void updateTable(Article article) {
		if (!this.getTableModel().getListArticles().contains(article)) {
			this.getTableModel().getListArticles().add(article);

		}
		this.getTableModel().fireTableDataChanged();
	}

}
