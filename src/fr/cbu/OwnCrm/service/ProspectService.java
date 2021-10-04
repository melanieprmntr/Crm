package fr.cbu.OwnCrm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cbu.OwnCrm.dto.Prospect;
import fr.cbu.OwnCrm.jdbc.OwnCrmConnection;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class ProspectService {

	public static Prospect getInstance() {
		Prospect prospect = new Prospect();
		prospect.setNom("Nouveau contact");
		prospect.setPrenom("prénom");
		return prospect;
	}

	public static void save(Prospect prospect) throws ClassNotFoundException, SQLException {
		if (prospect.getId() == null) {
			insert(prospect);
		} else {
			update(prospect);
		}
	}

	/***
	 * Fonction permettant l'insertion d'un enregistrement dans la table Contact
	 * 
	 * @param contact
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void insert(Prospect prospect) throws ClassNotFoundException, SQLException {

		prospect.setId(OwnCrmSingleton.nextSequence());

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();

		String requete = "INSERT INTO PROSPECT (ID,RAISONSOCIALE,NOM,PRENOM,ADRESSE,TELEPHONE,EMAIL) " + "VALUES ("
				+ prospect.getId() + ",'" + prospect.getRaisonsociale() + "','" + prospect.getNom() + "','" + prospect.getPrenom()
				+ "','" + prospect.getAdresse() + "','" + prospect.getTelephone() + "','" + prospect.getEmail() + "')";

		stmt.execute(requete);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	/***
	 * Fonction permettant de mettre à jour un enregistrement contact
	 * 
	 * @param contact
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void update(Prospect prospect) throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();

//		String requete = "UPDATE CONTACT SET GENRE='" + contact.getGenre() + "', NOM='" + contact.getNom()
//				+ "', PRENOM='" + contact.getPrenom() + "', ADRESSE='" + contact.getAdresse() + "', TELEPHONE='"
//				+ contact.getTelephone() + "', EMAIL='" + contact.getEmail() + "' WHERE ID=" + contact.getId();

		String requete = "UPDATE PROSPECT SET RAISONSOCIALE=?, NOM=?, PRENOM=?, ADRESSE=?, TELEPHONE=?, EMAIL=? WHERE ID="
				+ prospect.getId();
		PreparedStatement pstmt = c.prepareStatement(requete);
		pstmt.setString(1, prospect.getRaisonsociale());
		pstmt.setString(2, prospect.getNom());
		pstmt.setString(3, prospect.getPrenom());
		pstmt.setString(4, prospect.getAdresse());
		pstmt.setString(5, prospect.getTelephone());
		pstmt.setString(6, prospect.getEmail());

		System.out.println("requete update contact : " + requete);

		pstmt.executeUpdate();
		pstmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	/***
	 * Permet d'obtenir une instance de Contact à l'aide de son ID
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Prospect findById(Long id) throws ClassNotFoundException, SQLException {
		Prospect prospect = null;
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PROPECT WHERE ID=" + id);
		while (rs.next()) {
			prospect = getInstance();
			prospect.setId(rs.getLong("ID"));
			prospect.setRaisonsociale(rs.getString("GENRE"));
			prospect.setNom(rs.getString("NOM"));
			prospect.setPrenom(rs.getString("PRENOM"));
			prospect.setAdresse(rs.getString("ADRESSE"));
			prospect.setTelephone(rs.getString("TELEPHONE"));
			prospect.setEmail(rs.getString("EMAIL"));
		}
		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return prospect;
	}

	/***
	 * Permet de retourner l'intégralité des contacts
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<Prospect> findAll() throws ClassNotFoundException, SQLException {

		List<Prospect> result = new ArrayList<Prospect>();

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PROSPECT");

		while (rs.next()) {
			Prospect prospect = getInstance();
			prospect.setId(rs.getLong("ID"));
			prospect.setRaisonsociale(rs.getString("RAISONSOCIALE"));
			prospect.setNom(rs.getString("NOM"));
			prospect.setPrenom(rs.getString("PRENOM"));
			prospect.setAdresse(rs.getString("ADRESSE"));
			prospect.setTelephone(rs.getString("TELEPHONE"));
			prospect.setEmail(rs.getString("EMAIL"));
			result.add(prospect);
		}

		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return result;
	}

}
