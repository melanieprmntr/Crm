package fr.cbu.OwnCrm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import fr.cbu.OwnCrm.ApplicationLauncher;
import fr.cbu.OwnCrm.dto.Article;
import fr.cbu.OwnCrm.dto.ArticleType;
import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.dto.Utilisateur;
import fr.cbu.OwnCrm.jdbc.OwnCrmConnection;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class ArticleService {

	public static Article getInstance() {

		Article article = new Article();
		return article;

	}

	public static Article getInstance(Utilisateur utilisateur, double prixVenteHt, String description, Tva tva,
			String nom, ArticleType articleType) {

		if (ApplicationLauncher.DEBUG) {
			System.out.println("DEBUG : ajout d'un article " + nom);
		}

		Article article = new Article();
		article.setNom(nom);
		article.setDescription(description);
		article.setArticleType(articleType);
		article.setPrixVenteHt(prixVenteHt);
//		article.setPrixVenteTtc(prixVenteTtc);
		article.setTva(tva);

//		article.getArticleType().getListArticles().add(article);
		return article;
	}

	public static void calculPrixVenteTtc(Article article) {
		double prixVenteHt = article.getPrixVenteHt();
		Tva tva = article.getTva();
		double prixVenteTtc = prixVenteHt * tva.getCoef();
		article.setPrixVenteTtc(prixVenteTtc);
	}

	public static void save(Article article) throws ClassNotFoundException, SQLException {
		if (article.getId() == null) {
			insert(article);
		} else {
			update(article);
		}
	}

	/***
	 * Fonction permettant l'insertion d'un enregistrement dans la table Article
	 * 
	 * @param article
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void insert(Article article) throws ClassNotFoundException, SQLException {

		article.setId(OwnCrmSingleton.nextSequence());

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();

		String requete = "INSERT INTO ARTICLE(ID,NOM,DESCRIPTION,PRIXVENTEHT,ARTICLETYPE_ID) VALUES(" + article.getId()
				+ ",'" + article.getNom() + "','" + article.getDescription() + "'," + article.getPrixVenteHt() + ","
				+ article.getArticleType().getId() + ")";

		stmt.execute(requete);
		stmt.close();

		OwnCrmConnection.closeConnection(c);
	}

	/***
	 * Fonction permettant de mettre à jour un enregistrement article
	 * 
	 * @param article
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void update(Article article) throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();

//		String requete = "UPDATE CONTACT SET GENRE='" + article.getGenre() + "', NOM='" + article.getNom()
//				+ "', PRENOM='" + article.getPrenom() + "', ADRESSE='" + article.getAdresse() + "', TELEPHONE='"
//				+ article.getTelephone() + "', EMAIL='" + article.getEmail() + "' WHERE ID=" + article.getId();

		String requete = "UPDATE ARTICLE SET NOM=?,DESCRIPTION=?,PRIXVENTEHT=?, ARTICLETYPE_ID=?  WHERE ID="
				+ article.getId();
		PreparedStatement pstmt = c.prepareStatement(requete);
		pstmt.setString(1, article.getNom());
		pstmt.setString(2, article.getDescription());
		pstmt.setDouble(3, article.getPrixVenteHt());
		pstmt.setLong(4, article.getArticleType().getId());

		System.out.println("requete update article : " + requete);

		pstmt.executeUpdate();
		pstmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	/***
	 * Permet d'obtenir une instance de Article à l'aide de son ID
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Article findById(Long id) throws ClassNotFoundException, SQLException {
		Article article = null;
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ARTICLE WHERE ID=" + id);
		while (rs.next()) {
			article = getInstance();
			article.setId(rs.getLong("ID"));
			article.setDescription(rs.getString("description"));
			article.setNom(rs.getString("NOM"));
			article.setPrixVenteHt(rs.getDouble("prixventeht"));
			article.setArticleType((ArticleType) rs.getObject("articletype"));
		}
		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return article;
	}

	/***
	 * Permet de retourner l'intégralité des articles
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<Article> findAll() throws ClassNotFoundException, SQLException {

		List<Article> result = new ArrayList<Article>();

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ARTICLE");

		while (rs.next()) {
			Article article = getInstance();
			article.setId(rs.getLong("ID"));
			article.setNom(rs.getString("NOM"));
			article.setDescription(rs.getString("description"));
			article.setPrixVenteHt(rs.getDouble("prixventeht"));
			article.setArticleType((ArticleType) rs.getObject("articletype"));
		}

		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return result;
	}

//	PUBLIC STATIC LIST<GROUPEARTICLE> FINDBYARTICLETYPE(ARTICLETYPE ARTICLETYPE) {
//
//		SESSION SESSION = NULL;
//		TRY {
//			SESSION = OWNCRMSINGLETON.GETINSTANCE().GETHIBERNATECONFIGURATION().GETFACTORY().OPENSESSION();
//
//			FINAL TYPEDQUERY<GROUPEARTICLE> QUERY = SESSION.CREATENATIVEQUERY(
//					"SELECT * FROM GROUPEARTICLE WHERE ID IN ( SELECT ARTICLETYPE_ID FROM GROUPE_CONTACT WHERE LISTCONTACTS_ID=:CONTACTID)",
//					ARTICLETYPE.CLASS);
//			QUERY.SETPARAMETER("CONTACTID", ARTICLETYPE.GETID());
//			FINAL LIST<GROUPEARTICLE> LISTGROUPES = QUERY.GETRESULTLIST();
//			RETURN LISTGROUPES;
//		} CATCH (EXCEPTION E) {
//			E.PRINTSTACKTRACE();
//		} FINALLY {
//			IF (SESSION != NULL) {
//				SESSION.CLOSE();
//			}
//		}
//
//		RETURN NULL;
//	}
}
