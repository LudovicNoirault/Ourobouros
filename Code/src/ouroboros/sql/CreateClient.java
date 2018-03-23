/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class CreateClient {
    public static void creerNouveauClient(int fact1, String fact2,String fact3,int fact4,String fact5, int livr1, String livr2, String livr3, int livr4, String livr5, String clt1, String clt2){
	int retourBDDFacture =0;
	int retourBDDLivraison =0;
	
	Connection connection  = ConnectToBDD.getConnection();
	String sqlAdrFact = "INSERT INTO adressefacture (idAdresseFacture, numeroAdresseFacture, rueAdresseFacture, villeAdresseFacture, codepostalAdresseFacture, paysAdresseFacture) VALUES (NULL, "+fact1+", '"+fact2+"', '"+fact3+"', "+fact4+",'"+fact5+"')";
	try{
            PreparedStatement psAF = connection.prepareStatement(sqlAdrFact);
            psAF.executeUpdate();
            System.out.println("Requete SQL 1 faite.");
        }catch (SQLException e){
            e.printStackTrace();
        }
	String sqlAdrLivr = "INSERT INTO adresselivraison (idAdresseLivraison, numeroAdresseLivraison, rueAdresseLivraison, villeAdresseLivraison, codepostalAdresseLivraison, paysAdresseLivraison)  VALUES (NULL, "+livr1+", '"+livr2+"', '"+livr3+"', "+livr4+",'"+livr5+"')";
	try{
            PreparedStatement psAL = connection.prepareStatement(sqlAdrLivr);
            psAL.executeUpdate();
            System.out.println("Requete SQL 2 faite.");
	}catch (SQLException e){
            e.printStackTrace();
        }
        String sqlGetIdFact = "SELECT idAdresseFacture FROM adresseFacture WHERE numeroAdresseFacture LIKE "+fact1+" AND rueAdresseFacture LIKE '"+fact2+"';";
	try {
            PreparedStatement psGetIdFact = connection.prepareStatement(sqlGetIdFact);
            ResultSet  rs = psGetIdFact.executeQuery();
            rs.next();
            retourBDDFacture= rs.getInt("idAdresseFacture");
            System.out.println("Requete SQL 3 faite.");
	}catch (SQLException e){
            e.printStackTrace();
	}
        String sqlGetIdLivr = "SELECT idAdresseLivraison FROM adresseLivraison WHERE numeroAdresseLivraison LIKE "+livr1+" AND rueAdresseLivraison LIKE '"+livr2+"';";
        try {
            PreparedStatement psGetIdLivr = connection.prepareStatement(sqlGetIdLivr);
            ResultSet  rs = psGetIdLivr.executeQuery();
            rs.next();
            retourBDDLivraison= rs.getInt("idAdresseLivraison");
            System.out.println("Requete SQL 4 faite.");
	}catch (SQLException e){
            e.printStackTrace();
	}
        String sqlClient = "INSERT INTO client (idClient, nomClient, nomDirigeantClient, idAdresseFacture, idAdresseLivraison ) VALUES (NULL, '"+clt1+"', '"+clt2+"', "+retourBDDFacture+", "+retourBDDLivraison+")";
        try{
            PreparedStatement psC = connection.prepareStatement(sqlClient);
            psC.executeUpdate();
            System.out.println("Requete SQL 5 faite.");
            //connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
