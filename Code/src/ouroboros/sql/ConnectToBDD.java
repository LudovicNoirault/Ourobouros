package ouroboros.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
*
* @author
*/
public class ConnectToBDD 
	{
	private static final ConnectToBDD instance = new ConnectToBDD();
	private static Connection connection;
/*
* m�thode pour se connecter � la base de donn�es
*/
	public ConnectToBDD() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			String url = "jdbc:mysql://localhost/ourobouros_sql";
			String utilisateur = "root";
			String motDePasse = "";
			connection = DriverManager.getConnection(url, utilisateur , motDePasse);
			System.out.println("Connexion ok");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return instance.connection;
	}
}
