package fr.cbu.OwnCrm.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStructure {

	public static void createTableProspect() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE PROSPECT(ID BIGINT,RAISONSOCIALE VARCHAR (200),NOM VARCHAR(200),PRENOM VARCHAR(100), ADRESSE VARCHAR(1000), TELEPHONE VARCHAR(30), EMAIL VARCHAR(100))";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableArticle() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLE(ID BIGINT,ARTICLETYPE_ID BIGINT,NOM VARCHAR(200),DESCRIPTION VARCHAR(1000),PRIXVENTEHT DOUBLE)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableDevis() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE DEVIS(ID BIGINT,NUMERODEVIS INT, NOM VARCHAR(200), DATECREATION DATETIME, PRIXVENTEHT DOUBLE, MONTANTTVATOTAL DOUBLE)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableFacture() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE FACTURE(ID BIGINT, NUMEROFACTURE INT, NOM VARCHAR(200), DATECREATION DATETIME, PRIXVENTEHT DOUBLE,MONTANTTVATOTAL DOUBLE,DATEFINPRESTATION DATETIME, REGLEMENT VARCHAR(50))";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableDevisLigne() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE DEVIS_LIGNE(ID BIGINT,DEVIS_ID BIGINT,ARTICLE_NOM VARCHAR(50),PRIX_VENTE_HT DOUBLE)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableReglement() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE REGLEMENT(ID BIGINT, MODEREGLEMENT VARCHAR(200), DATEREGLEMENT DATETIME)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableTva() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE TVA (ID BIGINT,TAUX DOUBLE,COEF DOUBLE)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableRelationTvaArticle() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLE_TVA(TVA_ID BIGINT,ARTICLE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);

	}

	public static void createTableArticleType() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLETYPE(ID BIGINT,NOM VARCHAR(200), ARTICLE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

	public static void createTableRelationReglementFacture() throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE FACTURE_REGLEMENT(REGLEMENT_ID BIGINT,FACTURE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		OwnCrmConnection.closeConnection(c);
	}

}
