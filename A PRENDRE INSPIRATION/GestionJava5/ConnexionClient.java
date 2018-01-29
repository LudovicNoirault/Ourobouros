package GestionJava5;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnexionClient {
	
	private static final String PASSWORD = ""; 
	private static final String LOGIN = "root"; 
	private static final String URL = "jdbc:mysql://localhost:3306/tdgestionjava";
	private static final String QUERY_FINDS_CLIENTS = "SELECT * FROM client";
	private static Statement stmt = null;
	public static ResultSet rset;
	public static ArrayList<Client> listeClients = new ArrayList<Client>();
	public static int id_client, cp_client, numTVA_client, siret_client;
	public static String email_client, commentaires_client, nom_client, prenom_client, societe_client;
	
	public static void displayClient() {
		
		Connection con = null;
		
		try {
			con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD); 
			stmt = (Statement) con.createStatement(); 
			registerAndRead();
		}
		catch(final SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				}
			}
			if (con != null) { 
				try { 
					con.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
		}
	}
	
	public static void displayClientId(int id_client) {
		
		Connection con = null;
		
		try {
			con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD); 
			stmt = (Statement) con.createStatement(); 
			String QUERY_FINDS_CLIENTS_ID = "SELECT * FROM client WHERE id_client='"+id_client+"'";
			JOptionPane op = new JOptionPane();
			String retourListeClient = "";
			String retourListeClient2 = "";
			rset = stmt.executeQuery(QUERY_FINDS_CLIENTS_ID);
			
			while (rset.next()) { 
				listeClients.add(rsetToClient(rset));
			}
			
			for(Client clientChecked : listeClients) {
				id_client += clientChecked.getId_client();
				cp_client = clientChecked.getCp_client();
				numTVA_client = clientChecked.getNumTVA_client();
				siret_client = clientChecked.getSiret_client();
				email_client = clientChecked.getEmail_client();
				commentaires_client = clientChecked.getCommentaires_client();
				nom_client = clientChecked.getNom_client();
				prenom_client = clientChecked.getPrenom_client();
				societe_client = clientChecked.getSociete_client();
			}
		}
		catch(final SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				}
			}
			if (con != null) { 
				try { 
					con.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
		}
	}
	
	public static Boolean insertClientDB(int cp_client, int numTVA_client, int siret_client, String email_client, 	String commentaires_client, String nom_client, String prenom_client, String societe_client) {
		
		Connection con = null;
		boolean ok = false;
		
		try {
			con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD); 
			stmt = (Statement) con.createStatement();
			insertDB(cp_client, numTVA_client, siret_client, email_client, commentaires_client, nom_client, 			prenom_client, societe_client);
			ok = true;
			
		}
		catch(final SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				}
			}
			if (con != null) { 
				try { 
					con.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
		}
		return ok;
	}
	
	public static Boolean deleteClientDB(int id_client) {
		
		Connection con = null;
		boolean ok = false;
		
		try {
			con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD); 
			stmt = (Statement) con.createStatement();
			deleteDB(id_client);
			ok = true;
			
		}
		catch(final SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				}
			}
			if (con != null) { 
				try { 
					con.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
		}
		return ok;
	}
	
	public static Boolean updateClientDB(int id_client, int cp_client, int numTVA_client, int siret_client, String 	email_client, 	String commentaires_client, String nom_client, String prenom_client, String societe_client) {
		
		Connection con = null;
		boolean ok = false;
		
		try {
			con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD); 
			stmt = (Statement) con.createStatement();
			updateDB(id_client, cp_client, numTVA_client, siret_client, email_client, commentaires_client, nom_client, prenom_client, societe_client);
			ok = true;
			
		}
		catch(final SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				}
			}
			if (con != null) { 
				try { 
					con.close(); 
				} 
				catch (final SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
		}
		return ok;
	}
	
	private static void registerAndRead() throws SQLException {
		
		JOptionPane op = new JOptionPane();
		String retourListeClient = "";
		String retourListeClient2 = "";
		rset = stmt.executeQuery(QUERY_FINDS_CLIENTS);
		
		while (rset.next()) { 
			listeClients.add(rsetToClient(rset));
		}
		
		for(Client clientChecked : listeClients) {
			
			retourListeClient += "Client n° "+clientChecked.getId_client()+" : "+clientChecked.getNom_client()+" "+clientChecked.getPrenom_client()+", Societe : "+clientChecked.getSociete_client()+", Email : "+clientChecked.getEmail_client()+"\r\n";
		}
		
		op.showMessageDialog(null, retourListeClient);
	}
	
	public static Client rsetToClient(final ResultSet rset) throws SQLException {
		
		Client client = new Client(0, 0, 0, 0, null, null, null, null, null);
		
		client.setId_client(rset.getInt("id_client")); 
		client.setCp_client(rset.getInt("cp_client"));
		client.setNumTVA_client(rset.getInt("numTVA_client"));
		client.setSiret_client(rset.getInt("siret_client"));
		client.setEmail_client(rset.getString("email_client"));
		client.setCommentaires_client(rset.getString("commentaires_client"));
		client.setNom_client(rset.getString("nom_client")); 		
		client.setPrenom_client(rset.getString("prenom_client"));
		client.setSociete_client(rset.getString("societe_client"));
		
		return client;
	}
	
	private static void insertDB(int cp_client, int numTVA_client, int siret_client, String email_client,
			String commentaires_client, String nom_client, String prenom_client, String societe_client) throws SQLException {
		 
		String QUERY_INSERT_CLIENTS =  "INSERT INTO client(cp_client, numTVA_client, siret_client, email_client, commentaires_client, nom_client, prenom_client, societe_client) VALUES ('"+cp_client+"', 		'"+numTVA_client+"', '"+siret_client+"', '"+email_client+"', '"+commentaires_client+"', '"+nom_client+"', 		'"+prenom_client+"', '"+societe_client+"')";
		
		 stmt.executeUpdate(QUERY_INSERT_CLIENTS);
	}
	
	private static void updateDB(int id_client, int cp_client, int numTVA_client, int siret_client, String 	email_client, String commentaires_client, String nom_client, String prenom_client, String 	societe_client) throws 	SQLException {
		
		String QUERY_UPDATE_CLIENTS = "UPDATE client SET cp_client='"+cp_client+"', numTVA_client='"+numTVA_client+"', siret_client='"+siret_client+"', email_client='"+email_client+"', commentaires_client='"+commentaires_client+"', nom_client='"+nom_client+"', prenom_client='"+prenom_client+"', societe_client='"+societe_client+"' WHERE id_client='"+id_client+"'";
		
		stmt.executeUpdate(QUERY_UPDATE_CLIENTS);
		
	}
	
	private static void deleteDB(int id_client) throws SQLException {
		String QUERY_DELETE_CLIENTS = "DELETE FROM client WHERE id_client='"+id_client+"'";
		stmt.executeUpdate(QUERY_DELETE_CLIENTS);
	}
}
