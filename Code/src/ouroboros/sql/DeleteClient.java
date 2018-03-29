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
public class DeleteClient 
{
    public static void supprimerClient(String nomClient)
    {
        int retouridClient =0;
        int retouridAdresseFacture =0;
    	int retouridAdresseLivraison =0;
        
    	Connection connection  = ConnectToBDD.getConnection();
        
        String sqlGetInfosFromClient = "SELECT idClient, idAdresseFacture, idAdresseLivraison FROM client WHERE nomClient LIKE '"+nomClient+"';";
        try 
        {
            PreparedStatement psGetInfosClient = connection.prepareStatement(sqlGetInfosFromClient);
            ResultSet  rs = psGetInfosClient.executeQuery();
            rs.next();
            retouridClient = rs.getInt("idClient");
            retouridAdresseFacture = rs.getInt("idAdresseFacture");
            retouridAdresseLivraison = rs.getInt("idAdresseLivraison");
            //System.out.println("Retour table client : "+retouridClient);
            //System.out.println("Retour table adressefacture : "+retouridAdresseFacture);
            //System.out.println("Retour table adressefacture : "+retouridAdresseLivraison);
            System.out.println("Requete SQL GetInfosFromClient faite.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        String sqlDeleteClient = "DELETE FROM client WHERE idClient = '"+retouridClient+"';";
        try 
        {
            PreparedStatement psDeleteClient = connection.prepareStatement(sqlDeleteClient);
            psDeleteClient.executeUpdate();
            //System.out.println("Requete SQL DeleteClient.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        String sqlDeleteAdresseFacture = "DELETE FROM adressefacture WHERE idAdresseFacture = '"+retouridAdresseFacture+"';";
        try 
        {
            PreparedStatement psDeleteAdresseFacture = connection.prepareStatement(sqlDeleteAdresseFacture);
            psDeleteAdresseFacture.executeUpdate();
            //System.out.println("Requete SQL DeleteAdresseFacture.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        String sqlDeleteAdresseLivraison = "DELETE FROM adresselivraison WHERE idAdresseLivraison = '"+retouridAdresseLivraison+"';";
        try 
        {
            PreparedStatement psDeleteAdresseLivraison = connection.prepareStatement(sqlDeleteAdresseLivraison);
            psDeleteAdresseLivraison.executeUpdate();
            //System.out.println("Requete SQL DeleteAdresseLivraison.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
