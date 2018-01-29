package GestionJava5;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnexionFacture {
	private static final String LOGIN = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/tdgestionjava";
	private final static String QUERY_FIND_FACTURE = "SELECT * FROM facture";
	private static Statement stmt;
	public static ArrayList<Facture> listeId = new ArrayList<Facture>();

	public static Boolean insertFactureBDD(int quantite_facture, int remises_facture, int delaiPaiement_facture, int retard_facture,int acompte_facture, String libelle_facture, int valeur_facture, Boolean reglement_facture) {
		
		Connection con = null;
		stmt = null;
		Boolean ok = false;
		
		try {
			con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = (Statement)con.createStatement();
			System.out.println("Je suis connect�. Je vais lancer ma requ�te.");
			// Lancer la requête…
			insertDB(quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, libelle_facture, valeur_facture, reglement_facture);
			ok = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();// Le stmt.closeferme automatiquement le rset.
					System.out.println("Je ferme l'accès à la BDD.");
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
	public static Boolean updateFactureBDD(int id_facture,int quantite_facture, int remises_facture, int delaiPaiement_facture, int retard_facture,int acompte_facture, String libelle_facture, int valeur_facture, Boolean reglement_facture) {
		Connection con = null;
		stmt = null;
		Boolean ok = false;
		try {
			con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = (Statement)con.createStatement();
			System.out.println("Je suis connect�. Je vais lancer ma requ�te.");
			// Lancer la requête…
			updateDB(id_facture, quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, libelle_facture, valeur_facture, reglement_facture);
			ok = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();// Le stmt.closeferme automatiquement le rset.
					System.out.println("Je ferme l'acc�s �la BDD.");
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
	private static void insertDB(int quantite_facture, int remises_facture, int delaiPaiement_facture, int retard_facture,int acompte_facture, String libelle_facture, int valeur_facture, Boolean reglement_facture) throws SQLException {
		String query_Insert_Facture = "INSERT INTO facture(quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, libelle_facture, valeur_facture, reglement_facture) VALUES ('"+quantite_facture+"','"+remises_facture+"','"+delaiPaiement_facture+"','"+retard_facture+"','"+acompte_facture+"','"+libelle_facture+"','"+valeur_facture+"','"+reglement_facture+"')";
		stmt.executeUpdate(query_Insert_Facture);
	}
	private static void updateDB(int id_facture_saisi, int quantite_facture, int remises_facture, int delaiPaiement_facture, int retard_facture,int acompte_facture, String libelle_facture, int valeur_facture, Boolean reglement_facture) throws SQLException {
		String query_Update_Facture = "UPDATE facture SET quantite_facture='"+quantite_facture+"', remises_facture='"+remises_facture+"', delaiPaiement_facture='"+delaiPaiement_facture+"', retard_facture='"+retard_facture+"', acompte_facture='"+acompte_facture+"', libelle_facture='"+libelle_facture+"', valeur_facture='"+valeur_facture+"', reglement_facture='"+reglement_facture+"' WHERE id_facture='"+id_facture_saisi+"'";
		stmt.executeUpdate(query_Update_Facture);
	}
	public static ArrayList<Facture> getUpdateFactureBDD() {

		Connection con = null;
		Statement stmt = null;
		ArrayList<Facture> listeFacture = new ArrayList<>();

		try {
			con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = (Statement)con.createStatement();
			System.out.println("Je suis connecté. Je vais lancer ma requête.");
			// Lancer la requête…
			ResultSet rset = stmt.executeQuery(QUERY_FIND_FACTURE);
			// Travail sur le resultSet
			while (rset.next()) {
				listeFacture.add(rsetToFacture(rset));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();// Le stmt.closeferme automatiquement le rset.
					System.out.println("Je ferme l'accès à la BDD.");
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
		return listeFacture;
	}
	public static ArrayList<Facture> getFactureBDD() {

		Connection con = null;
		Statement stmt = null;
		ArrayList<Facture> listeFacture = new ArrayList<>();

		try {
			con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = (Statement)con.createStatement();
			System.out.println("Je suis connect�. Je vais lancer ma requ�te.");
			// Lancer la requête…
			ResultSet rset = stmt.executeQuery(QUERY_FIND_FACTURE);
			// Travail sur le resultSet
			while (rset.next()) {
				listeFacture.add(rsetToFacture(rset));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();// Le stmt.close ferme automatiquement le rset.
					System.out.println("Je ferme l'acc�s à la BDD.");
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
		return listeFacture;
	}	
	private static Facture rsetToFacture(final ResultSet rset) throws SQLException {

		final Facture facture = new Facture(0, 0, 0, 0, 0, 0, null, 0, 1);
		facture.setId_facture(rset.getInt("id_facture"));
		facture.setQuantite_facture(rset.getInt("quantite_facture"));
		facture.setRemises_facture(rset.getInt("remises_facture"));
		facture.setDelaiPaiement_facture(rset.getInt("delaiPaiement_facture"));
		facture.setRetard_facture(rset.getInt("retard_facture"));
		facture.setAcompte_facture(rset.getInt("acompte_facture"));
		facture.setLibelle_facture(rset.getString("libelle_facture"));
		facture.setValeur_facture(rset.getInt("valeur_facture"));
		facture.setReglement_facture(rset.getInt("reglement_facture"));
		return facture;
	}

	public static Boolean deleteFactureBDD(int id_facture) {

		Connection con = null;
		Statement stmt = null;
		String query_Delete_Facture = "DELETE FROM facture WHERE id_facture = "+id_facture;
		System.out.println("Voici ma requête "+query_Delete_Facture);
		Boolean ok = false;
		try {
			con = (Connection)DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = (Statement)con.createStatement();
			System.out.println("Je suis connecté. Je vais lancer ma requête.");
			// Lancer la requête…
			stmt.executeUpdate(query_Delete_Facture);
			ok = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();// Le stmt.closeferme automatiquement le rset.
					System.out.println("Je ferme l'accès à la BDD.");
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
