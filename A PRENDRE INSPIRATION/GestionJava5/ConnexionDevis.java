package GestionJava5;
import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import javax.swing.JOptionPane;
	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.Statement;
	
	public class ConnexionDevis {

		private static final String LOGIN = "root";
		private static final String PASSWORD = "";
		private static final String URL = "jdbc:mysql://localhost:3306/tdgestionjava";
		private final static String QUERY_FIND_DEVIS = "SELECT * FROM devis";
		private  static Statement stmt = null;

			
		public static Boolean insertDevisBdD( int quantite_devis, String libelle_devis, int remises_devis, int retard_devis, int delaisPaiement_devis,
				 double valeur_devis) {

			Connection con = null;
			String QUERY_INSERT_DEVIS = "INSERT INTO devis( quantite_devis, libelle_devis, valeur_devis, remises_devis, retard_devis, delaisPaiement_devis) "
					+ "VALUES ('"+quantite_devis+"','"+libelle_devis+"','"+remises_devis+"','"+retard_devis+"','"+delaisPaiement_devis+"','"+valeur_devis+"')";
			Boolean ok = false;
					
			try {
				con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
				stmt = (Statement)con.createStatement();
				System.out.println("Je suis connectée. Je vais lancer ma requète");
				// Lancer la requète
				
				stmt.executeUpdate(QUERY_INSERT_DEVIS);
				ok = true;
			} catch (final SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();// Le stmt.closeferme automatiquement le rset.
						System.out.println("Je ferme l'accès à la BdD");
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return ok;
		}
		
		public static Boolean updateDevisBD(int id_devis, int quantite_devis, String libelle_devis, int remises_devis, int retard_devis, int delaisPaiement_devis,
				 double valeur_devis) {
			
			Connection con = null;
			Boolean ok = false;
			
			try {
				con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
				stmt = (Statement)con.createStatement();			
				System.out.println("Je suis connecté. Je vais lancer ma requète");			
				updateDB(id_devis,quantite_devis, libelle_devis, remises_devis, retard_devis, delaisPaiement_devis,valeur_devis);
				
				ok = true;		
				
			} catch (final SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();// Le stmt.closeferme automatiquement le rset.
						System.out.println("Je ferme l'accès à la BdD");
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return ok;
		}
			
		
		public static ArrayList<Devis> getDevisBdD() {

			Connection con = null;
			ArrayList<Devis> listeDevis = new ArrayList<>();

			try {
				con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
				stmt = (Statement)con.createStatement();
				System.out.println("Je suis connecté. Je vais lancer ma requète");
				// Lancer la requ�te�
				ResultSet rset = stmt.executeQuery(QUERY_FIND_DEVIS);
				// Travail sur le resultSet
				while (rset.next()) {
					listeDevis.add(rsetToDevis(rset));
				}
			} catch (final SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();// Le stmt.closeferme automatiquement le rset.
						System.out.println("Je ferme l'accès à la BdD");
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return listeDevis;
		}

		private static Devis rsetToDevis(final ResultSet rset) throws SQLException {

			final Devis devis = new Devis(0,0,0,0,0,null,0);

			devis.setId_devis(rset.getInt("id_devis"));
			devis.setQuantite_devis(rset.getInt("quantite_devis"));
			devis.setRemises_devis(rset.getInt("remises_devis"));
			devis.setRetard_devis(rset.getInt("retard_devis"));
			devis.setDelaisPaiement_devis(rset.getInt("delaisPaiement_devis"));
			devis.setLibelle_devis(rset.getString("libelle_devis"));
			devis.setValeur_devis(rset.getDouble("valeur_devis"));		

			return devis;
		}
		
		public static void updateDB(int id_devis, int quantite_devis, String libelle_devis, int remises_devis, int retard_devis, int delaisPaiement_devis,
				 double valeur_devis) throws SQLException {
						
				String query_Update_Devis = "UPDATE devis SET quantite_devis='"+quantite_devis+"', libelle_devis='"+libelle_devis+"', remises_devis='"+remises_devis+"'"
						+ ", retard_devis ='"+retard_devis+"',delaisPaiement_devis ='"+delaisPaiement_devis+"', valeur_devis ='"+valeur_devis+"' WHERE id_devis='"+id_devis+"'";
				
				stmt.executeUpdate(query_Update_Devis);
		}
		

		public static Boolean deleteDevisBdD(int id_devis) {

			Connection con = null;
			
			String query_Delete_Devis = "DELETE FROM devis WHERE id_devis = "+id_devis;
			System.out.println("Voici ma requète "+query_Delete_Devis);
			Boolean ok = false;
			try {
				con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
				stmt = (Statement)con.createStatement();
				System.out.println("Je suis connecté. Je vais lancer ma requète");
				// Lancer la requ�te�
				
				stmt.executeUpdate(query_Delete_Devis);
				
				ok = true;
				
			} catch (final SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();// Le stmt.closeferme automatiquement le rset.
						System.out.println("Je ferme l'accès à la BdD");
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return ok;
		}

	}
