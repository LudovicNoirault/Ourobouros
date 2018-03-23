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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class ListeClient 
{
    public static List<String> lireListeClient()
    { 	
    	Connection connection  = ConnectToBDD.getConnection();
	  	
		String sqlGetClientName= "SELECT nomClient FROM client;";
		
		List<String> listeNomClient = new ArrayList<>();
		
		try
		{
	            PreparedStatement psGetClientName = connection.prepareStatement(sqlGetClientName);
	            ResultSet  rs = psGetClientName.executeQuery();
	            while(rs.next())
	            {
	            	listeNomClient.add(rs.getString("nomClient"));
	            }
	            
	            System.out.println("Requete SQL faite, retour :"+listeNomClient);
		}
		catch (SQLException e)
		{
	            e.printStackTrace();
		}
		return listeNomClient;
    }
}
