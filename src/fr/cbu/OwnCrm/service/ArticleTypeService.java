package fr.cbu.OwnCrm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cbu.OwnCrm.ApplicationLauncher;
import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.jdbc.OwnCrmConnection;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class ArticleTypeService {

	public static ArticleType getInstance() {
		ArticleType type = new ArticleType();
		return type;
	}

	public static ArticleType getInstance(String nom) {

		if (ApplicationLauncher.DEBUG) {
			System.out.println("DEBUG : ajout d'un forfait ");
		}

		ArticleType articleType = new ArticleType();
		articleType.setNom(nom);
		return articleType;
	}

	public static void save(ArticleType articleType) throws ClassNotFoundException, SQLException {
		if (articleType.getId() == null) {
			insert(articleType);
		} else {
			update(articleType);
		}
	}

	private static void insert(ArticleType articleType) throws ClassNotFoundException, SQLException {

		articleType.setId(OwnCrmSingleton.nextSequence());

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();

		String requete = "INSERT INTO ARTICLETYPE (ID,NOM) VALUES (" + articleType.getId() + ",'" + articleType.getNom()
				+ "')";

		stmt.execute(requete);
		stmt.close();

		OwnCrmConnection.closeConnection(c);
	}

	private static void update(ArticleType articleType) throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();

		String requete = "UPDATE ARTICLETYPE SET NOM=?  WHERE ID=" + articleType.getId();
		PreparedStatement pstmt = c.prepareStatement(requete);
//		pstmt.setArray(1, (Array) articleType.getListArticles());
		pstmt.setString(1, articleType.getNom());

		System.out.println("requete update articleType : " + requete);

		pstmt.executeUpdate();
		pstmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	/***
	 * Permet de retourner l'intégralité des articleTypes
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<ArticleType> findAll() throws ClassNotFoundException, SQLException {

		List<ArticleType> result = new ArrayList<ArticleType>();

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ARTICLETYPE");

		while (rs.next()) {
			ArticleType articleType = getInstance();
			articleType.setId(rs.getLong("ID"));
			articleType.setNom(rs.getString("nom"));
			result.add(articleType);
		}

		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return result;
	}

//	public static void loadLazy(ArticleType articleType) {
//		List<GroupeArticle> listGroupes = ArticleService.findByArticleType(articleType);
//		articleType.setListGroupes(listGroupes);
//	}

}
