package fr.cbu.OwnCrm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cbu.OwnCrm.dto.DevisLigne;
import fr.cbu.OwnCrm.dto.Tva;
import fr.cbu.OwnCrm.jdbc.OwnCrmConnection;
import fr.cbu.OwnCrm.singleton.OwnCrmSingleton;

public class TvaService {
	
	public static Tva getInstance() {
		Tva tva = new Tva();
		return tva;
	}
	
	
	public static Tva getInstance(double taux) {
		Tva tva = new Tva();
		tva.setTaux(taux);

		double coef = calculCoefTva(taux);
		tva.setCoef(coef);

		return tva;
	}

	public static double calculCoefTva(double taux) {
		return 1 + (taux / 100);
	}

	public static void calculerTva(DevisLigne devisLigne) {
		Tva tva = (Tva) devisLigne.getListTvas();
//		Tva tva = tva.getTaux();
		double prixTotalHt = devisLigne.getPrixTotalHt();
		double montantTva = prixTotalHt * (tva.getTaux() / 100);
		devisLigne.setMontantTva(montantTva);
		double prixTotalTtc = prixTotalHt + prixTotalHt * (tva.getTaux() / 100);
		devisLigne.setPrixTotalTtc(prixTotalTtc);
	}
	
	
	public static void save(Tva tva) throws ClassNotFoundException, SQLException {
		if (tva.getId() == null) {
			insert(tva);
		} else {
			update(tva);
		}
	}

	
	private static void insert(Tva tva) throws ClassNotFoundException, SQLException {

		tva.setId(OwnCrmSingleton.nextSequence());

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();

		String requete = "INSERT INTO TVA (ID ,TAUX, COEF) VALUES (" + tva.getId()
				+ "," + tva.getTaux() + "," + tva.getCoef() + ",)";

		stmt.execute(requete);
		stmt.close();

		OwnCrmConnection.closeConnection(c);
	}
	
	/***
	 * Permet de retourner l'intégralité des tvas
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<Tva> findAll() throws ClassNotFoundException, SQLException {

		List<Tva> result = new ArrayList<Tva>();

		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TVA");

		while (rs.next()) {
			Tva tva = getInstance();
//			tva.setId(rs.getLong("ID"));
			tva.setTaux(rs.getDouble("taux"));
		}

		rs.close();
		stmt.close();
		OwnCrmConnection.closeConnection(c);

		return result;
	}


	/***
	 * Fonction permettant de mettre à jour un enregistrement tva
	 * 
	 * @param tva
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void update(Tva tva) throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();

		String requete = "UPDATE TVA SET TAUX=?, COEF=?  WHERE ID=" + tva.getId();
		PreparedStatement pstmt = c.prepareStatement(requete);
		pstmt.setDouble(1, tva.getTaux());
		pstmt.setDouble(2, tva.getCoef());


		System.out.println("requete update tva : " + requete);

		pstmt.executeUpdate();
		pstmt.close();
		OwnCrmConnection.closeConnection(c);
	}

}
