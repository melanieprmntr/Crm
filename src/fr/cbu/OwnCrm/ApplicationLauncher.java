package fr.cbu.OwnCrm;
import java.sql.SQLException;

import fr.cbu.OwnCrm.jdbc.DatabaseStructure;
import fr.cbu.OwnCrm.view.MainView;

public class ApplicationLauncher {

	public static final boolean DEBUG = true;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("BIENVENUE SUR OWNCRM");
		System.out.println("***********************************************************************");
		
		DatabaseStructure.createTableProspect();
		DatabaseStructure.createTableArticle();
		DatabaseStructure.createTableArticleType();
		DatabaseStructure.createTableDevis();
		DatabaseStructure.createTableDevisLigne();
		DatabaseStructure.createTableFacture();
		DatabaseStructure.createTableReglement();
		DatabaseStructure.createTableRelationReglementFacture();
		DatabaseStructure.createTableRelationTvaArticle();
		DatabaseStructure.createTableTva();
		new MainView();
	}

}
