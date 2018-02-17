import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class essaiSQL {

	private static final String PASSWORD =	""	;
	private	static final String LOGIN =	"root"	;
	private	static final String  URL="jdbc:mysql://localhost:3306/ourobouros_sql";
	
	Connection 	con	 =	null;
	Statement stmt = null;
	
	{
		try
		 {
			con = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			stmt=con.createStatement();
			System.out.println(	"Je suis connectée. Je vais lancer ma requête");
		 }
		catch
		 (	final SQLException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			{	
				if(stmt	!=	null) 
				{
					try
					{
						stmt.close();
						// Le stmt.closeferme automatiquement le rset.
						System.out.println(	"Je ferme l'accès à la BdD");
					} 
					catch (final SQLException e) 
					{
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try
					{
						con.close();
					} 
					catch (	final SQLException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}