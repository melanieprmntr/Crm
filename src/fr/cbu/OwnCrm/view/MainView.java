package fr.cbu.OwnCrm.view;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.hibernate.HibernateConfiguration;
import fr.cbu.OwnCrm.service.ArticleService;
import fr.cbu.OwnCrm.service.ArticleTypeService;
import fr.cbu.OwnCrm.service.ProspectService;
import fr.cbu.OwnCrm.service.TvaService;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;
import fr.cbu.OwnCrm.view.article.ArticleView;
import fr.cbu.OwnCrm.view.articleType.ArticleTypeView;
import fr.cbu.OwnCrm.view.prospect.ProspectView;
import fr.cbu.OwnCrm.view.tva.TvaView;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleView articleView;

	private ProspectView prospectView;

	private TvaView tvaView;

	private ArticleTypeView articleTypeView;

	public MainView() throws ClassNotFoundException, SQLException {
		try {
			HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
			OwnCrmSingleton.getInstance().setHibernateConfiguration(hibernateConfiguration);

			ArticleType articleType1 = ArticleTypeService.getInstance();
			articleType1.setNom("site vitrine");
			ArticleTypeService.save(articleType1);

			ArticleType articleType2 = ArticleTypeService.getInstance();
			articleType2.setNom("wordpress");
			ArticleTypeService.save(articleType2);

			ArticleType articleType3 = ArticleTypeService.getInstance();
			articleType3.setNom("site marchand");
			ArticleTypeService.save(articleType3);

			System.out.println(ArticleTypeService.findAll());
			
			articleView = new ArticleView();
			prospectView = new ProspectView();
			tvaView = new TvaView();
			articleTypeView = new ArticleTypeView();


			JPanel content = new JPanel();
			this.add(content);

			content.add(createPanelArticle());
			content.add(createPanelProspect());
			content.add(createPanelTva());
			content.add(createPanelArticleType());

			this.setSize(800, 500);
			this.setVisible(true);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Défaut de configuration", JOptionPane.WARNING_MESSAGE);
			System.exit(ERROR);
		}
	}

	public JPanel createPanelArticle() {
		JPanel panel = new JPanel();

		JButton addArticle = new JButton("Ajouter");
		panel.add(addArticle);
		addArticle.addActionListener(e -> {
			Article article = ArticleService.getInstance();
			try {
				this.articleView.setArticleCourant(article);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		JButton gestionArticle = new JButton("Gestion de articles");
		panel.add(gestionArticle);
		gestionArticle.addActionListener(e -> this.articleView.setVisible(true));

//		JButton sql = new JButton("afficher SQL");
//		panel.add(sql);
//		sql.addActionListener(e -> {
//			try {
//				System.out.println(ArticleService.findAll());
//			} catch (ClassNotFoundException | SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});

		return panel;
	}

	public JPanel createPanelProspect() {
		JPanel panel = new JPanel();

		JButton addProspect = new JButton("Ajouter");
		panel.add(addProspect);
		addProspect.addActionListener(e -> {
			Prospect Prospect = ProspectService.getInstance();
			this.prospectView.setProspectCourant(Prospect);
		});

		JButton gestionProspect = new JButton("Gestion de Prospects");
		panel.add(gestionProspect);
		gestionProspect.addActionListener(e -> this.prospectView.setVisible(true));
//
//		JButton sql = new JButton("afficher SQL");
//		panel.add(sql);
//		sql.addActionListener(e -> {
//			try {
//				System.out.println(ProspectService.findAll());
//			} catch (ClassNotFoundException | SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});

		return panel;
	}

	public JPanel createPanelTva() {
		JPanel panel = new JPanel();

		JButton addTva = new JButton("Ajouter");
		panel.add(addTva);
		addTva.addActionListener(e -> {
			Tva tva = TvaService.getInstance();
			this.tvaView.setTvaCourant(tva);
		});

		JButton gestionTva = new JButton("Gestion de Tva");
		panel.add(gestionTva);
		gestionTva.addActionListener(e -> this.tvaView.setVisible(true));

		JButton sql = new JButton("afficher SQL");
		panel.add(sql);
		sql.addActionListener(e -> {
			try {
				System.out.println(ProspectService.findAll());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		return panel;
	}

	public JPanel createPanelArticleType() {
		JPanel panel = new JPanel();

		JButton addArticleType = new JButton("Ajouter");
		panel.add(addArticleType);
		addArticleType.addActionListener(e -> {
			ArticleType articleType = ArticleTypeService.getInstance();

			this.articleTypeView.setArticleTypeCourant(articleType);

		});

		JButton gestionArticleType = new JButton("Gestion des ArticlesType");
		panel.add(gestionArticleType);
		gestionArticleType.addActionListener(e -> this.articleTypeView.setVisible(true));

		JButton sql = new JButton("afficher SQL");
		panel.add(sql);
		sql.addActionListener(e -> {
			try {
				System.out.println(ArticleTypeService.findAll());
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		});

		return panel;
	}
}
