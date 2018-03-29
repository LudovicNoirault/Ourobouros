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
import ouroboros.ecrans.EcranClientUpdate;

/**
 *
 * @author user
 */
public class UpdateClient 
{
	public static void recupererClient(String nomClient)
    {
    	//from client
		int retouridClient=0;
    	String retournomClient ="";
    	String retournomDirigeantClient =""; 
    	int retouridAdresseFacture =0;
    	int retouridAdresseLivraison =0;
    	//from adresseLivraison
    	int retouridLivraison=0;
    	String retournumeroAdresseLivraison ="";
    	String retourrueAdresseLivraison ="";
    	String retourvilleAdresseLivraison="";
    	String retourcodePostalAdresseLivraison="";
    	String retourpaysAdresseLivraison="";
    	//from adresseFacturation
    	int retouridFacture=0;
    	String retournumeroAdresseFacture ="";
    	String retourrueAdresseFacture ="";
    	String retourvilleAdresseFacture ="";
    	String retourcodePostalAdresseFacture ="";
    	String retourpaysAdresseFacture="";
    	
    	Ecran clientFiche = new Ecran();
    	
        Connection connection  = ConnectToBDD.getConnection();
        String sqlGetAllFromClient = "SELECT * FROM client WHERE nomClient LIKE '"+nomClient+"';";
        try 
        {
            PreparedStatement psGetInfoClient = connection.prepareStatement(sqlGetAllFromClient);
            ResultSet  rs = psGetInfoClient.executeQuery();
            rs.next();
            retouridClient=rs.getInt("idClient");
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
            retournumeroAdresseLivraison= rs.getString("numeroAdresseLivraison");
            retourrueAdresseLivraison= rs.getString("rueAdresseLivraison");
            retourvilleAdresseLivraison= rs.getString("villeAdresseLivraison");
            retourcodePostalAdresseLivraison= rs.getString("codepostalAdresseLivraison");
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
            retournumeroAdresseFacture= rs.getString("numeroAdresseFacture");
            retourrueAdresseFacture = rs.getString("rueAdresseFacture");
            retourvilleAdresseFacture = rs.getString("villeAdresseFacture");
            retourcodePostalAdresseFacture = rs.getString("codepostalAdresseFacture");
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
        EcranClientUpdate ecranClientSelected = new EcranClientUpdate();
        ecranClientSelected.ParametresClientRead(clientFiche,retouridClient,retournomClient,retournomDirigeantClient,retouridAdresseLivraison,retournumeroAdresseLivraison,retourrueAdresseLivraison,retourvilleAdresseLivraison,retourcodePostalAdresseLivraison,retourpaysAdresseLivraison,retouridAdresseFacture,retournumeroAdresseFacture,retourrueAdresseFacture,retourvilleAdresseFacture,retourcodePostalAdresseFacture,retourpaysAdresseFacture);
    }
	
    public static void updateSelectedClient(int factid, int fact1, String fact2,String fact3,int fact4,String fact5, int livrid, int livr1, String livr2, String livr3, int livr4, String livr5, int cltid, String clt1, String clt2){
	int retourBDDFacture =0;
	int retourBDDLivraison =0;
	
	Connection connection  = ConnectToBDD.getConnection();
	String sqlAdrFact = "UPDATE adressefacture SET numeroAdresseFacture='"+fact1+"', rueAdresseFacture='"+fact2+"',villeAdresseFacture='"+fact3+"' ,codepostalAdresseFacture='"+fact4+"' ,paysAdresseFacture='"+fact5+"' WHERE idAdresseFacture='"+factid+"';";
	try{
			System.out.println("valeur a envoyer"+factid+","+fact1+","+fact2+","+fact3+","+fact4+","+fact5+","+livrid+","+livr1+","+livr2+","+livr3+","+livr4+","+livr5+","+cltid+","+clt1+","+clt2);

            PreparedStatement psAF = connection.prepareStatement(sqlAdrFact);
            psAF.executeUpdate();
            System.out.println("Requete SQL 1 faite.");
        }catch (SQLException e){
            e.printStackTrace();
        }
	String sqlAdrLivr = "UPDATE adresselivraison SET numeroAdresseLivraison='"+livr1+"', rueAdresseLivraison='"+livr2+"', villeAdresseLivraison='"+livr3+"', codepostalAdresseLivraison='"+livr4+"', paysAdresseLivraison='"+livr5+"' WHERE idAdresseLivraison='"+livrid+"';";
	try{
            PreparedStatement psAL = connection.prepareStatement(sqlAdrLivr);
            psAL.executeUpdate();
            System.out.println("Requete SQL 2 faite.");
	}catch (SQLException e){
            e.printStackTrace();
        }
   
	
	
        String sqlClient = "UPDATE client SET nomClient='"+clt1+"', nomDirigeantClient='"+clt2+"' WHERE idClient='"+cltid+"';";
        try{
            PreparedStatement psC = connection.prepareStatement(sqlClient);
            psC.executeUpdate();
            System.out.println("Requete SQL 3 faite.");
            //connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
