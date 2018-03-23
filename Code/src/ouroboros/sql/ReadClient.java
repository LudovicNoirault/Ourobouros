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

import ouroboros.classes.Ecran;
import ouroboros.ecrans.EcranClientRead;

/**
 *
 * @author user
 */
public class ReadClient 
{
    public static void recupererClient(String nomClient)
    {
    	//from client
    	String retournomClient;
    	String retournomDirigeantClient;
    	int retouridAdresseFacture =0;
    	int retouridAdresseLivraison =0;
    	//from adresseLivraison
    	int retournumeroAdresseLivraison =0;
    	String retourrueAdresseLivraison;
    	String retourvilleAdresseLivraison;
    	int retourcodePostalAdresseLivraison =0;
    	String retourpaysAdresseLivraison;
    	//from adresseFacturation
    	int retournumeroAdresseFacture =0;
    	String retourrueAdresseFacture ;
    	String retourvilleAdresseFacture ;
    	int retourcodePostalAdresseFacture =0;
    	String retourpaysAdresseFacture;
    	
    	Ecran clientFiche = new Ecran();
    	
        Connection connection  = ConnectToBDD.getConnection();
        String sqlGetAllFromClient = "SELECT * FROM client WHERE nomClient LIKE '"+nomClient+"';";
        try 
        {
            PreparedStatement psGetInfoClient = connection.prepareStatement(sqlGetAllFromClient);
            ResultSet  rs = psGetInfoClient.executeQuery();
            rs.next();
            retournomClient= rs.getString("nomClient");
            retournomDirigeantClient = rs.getString("nomDirigeantClient");
            retouridAdresseFacture = rs.getInt("idAdresseFacture");
            retouridAdresseLivraison = rs.getInt("idAdresseLivraison");

            System.out.println("Retour table client :");

            System.out.println(retournomClient);
            System.out.println(retournomDirigeantClient);
            System.out.println(retouridAdresseFacture);
            System.out.println(retouridAdresseLivraison);
            System.out.println("Requete SQL ReadClient faite.");
           
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        
        
        String sqlGetAllFromAdrLivr = "SELECT * FROM adresselivraison WHERE idAdresseLivraison LIKE '"+retouridAdresseLivraison+"';";
        try 
        {
            PreparedStatement psGetInfoLivr = connection.prepareStatement(sqlGetAllFromAdrLivr);
            ResultSet  rs = psGetInfoLivr.executeQuery();
            rs.next();
            retournumeroAdresseLivraison= rs.getInt("numeroAdresseLivraison");
            retourrueAdresseLivraison= rs.getString("rueAdresseLivraison");
            retourvilleAdresseLivraison= rs.getString("villeAdresseLivraison");
            retourcodePostalAdresseLivraison= rs.getInt("codepostalAdresseLivraison");
            retourpaysAdresseLivraison= rs.getString("paysAdresseLivraison");
            
            System.out.println("Retour table adresse livr :");

            System.out.println(retournumeroAdresseLivraison);
            System.out.println(retourrueAdresseLivraison);
            System.out.println(retourvilleAdresseLivraison);
            System.out.println(retourcodePostalAdresseLivraison);
            System.out.println(retourpaysAdresseLivraison);
            System.out.println("Requete SQL ReadClient faite.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        String sqlGetAllFromAdrFact = "SELECT * FROM adressefacture WHERE idAdresseFacture LIKE '"+retouridAdresseFacture+"';";
        try 
        {
            PreparedStatement psGetInfoFact = connection.prepareStatement(sqlGetAllFromAdrFact);
            ResultSet  rs = psGetInfoFact.executeQuery();
            rs.next();
            retournumeroAdresseFacture= rs.getInt("numeroAdresseFacture");
            retourrueAdresseFacture = rs.getString("rueAdresseFacture");
            retourvilleAdresseFacture = rs.getString("villeAdresseFacture");
            retourcodePostalAdresseFacture = rs.getInt("codepostalAdresseFacture");
            retourpaysAdresseFacture = rs.getString("paysAdresseFacture");
            
            System.out.println("Retour table adresse fact :");

            System.out.println(retournumeroAdresseFacture);
            System.out.println(retourrueAdresseFacture);
            System.out.println(retourvilleAdresseFacture);
            System.out.println(retourcodePostalAdresseFacture);
            System.out.println(retourpaysAdresseFacture);
            System.out.println("Requete SQL ReadClient faite.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        EcranClientRead ecranClientSelected = new EcranClientRead();
        ecranClientSelected.ParametresClientRead(clientFiche,retournomClient,retournomDirigeantClient,retournumeroAdresseLivraison,retourrueAdresseLivraison,retourvilleAdresseLivraison,retourcodePostalAdresseLivraison,retourpaysAdresseLivraison,retournumeroAdresseFacture,retourrueAdresseFacture,retourvilleAdresseFacture,retourcodePostalAdresseFacture,retourpaysAdresseFacture);
    }
}
