package GestionJava5;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static Scanner saisie, saisie2;
	public static int id_client, cp_client, numTVA_client, siret_client, id_devis, quantite_devis, valeur_devis, remises_devis, delaisPaiement_devis, retard_devis, id_facture, id_facture_saisi, quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, valeur_facture;
	public static String reponse = "";
	public static JOptionPane op = new JOptionPane();
	public static String email_client, commentaires_client, nom_client, prenom_client, societe_client, libelle_facture, libelle_devis;
	public static Scanner sc = new Scanner(System.in);
	public static Boolean reglement_facture;
	
	public static void main(String[] args) throws SQLException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindowInsert frame = new ClientWindowInsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindowUpdate frame = new ClientWindowUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindowDelete frame = new ClientWindowDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactureWindowInsert frame = new FactureWindowInsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String ajout;
		String newSaisie;
		String choixSwitch;
		String choix;
		
			do {
				choix = op.showInputDialog(null, "Voulez-vous gérer : client (1), devis (2), facture (3)", "TD java Gestion", JOptionPane.QUESTION_MESSAGE);
				switch(choix){
			
				case "1":
				switchClient();
				break;
				
				case "2":
				switchDevis();
				break;
				
				case "3":
				switchFacture();	
				break;	
			}
			choixSwitch = op.showInputDialog(null, "Voulez-vous faire une autre opération ? (y/n)", "Ajout d'une classe", JOptionPane.QUESTION_MESSAGE);
		} while(choixSwitch.equals("y"));
		op.showMessageDialog(null, "Au revoir");
	}
	private static void switchFacture() {

		String choixF="";
		do {
			// Boucle principale
			choixF = op.showInputDialog(null, "1/ Ajout facture 2/ Suppression facture 3/ Modification facture 4/ Affichage liste des factures 5/ Sortie du traitement", "Facture", JOptionPane.QUESTION_MESSAGE);
			
			switch (choixF) {
			case "1":
				saisieFacture();
				break;
			case "2":
				suppressionFacture();
				break;
			case "3":
				modificationFacture();
				break;	
			case "4":
				affichageFacture();
				break;
			}
		} while (!choixF.equals("5"));
	}
	private static void switchDevis() {

		String choixD="";
		
		do {
			// Boucle principale
			choixD = op.showInputDialog(null, "1/ Ajout Devis 2/ Modifier 3/Suppression 4/ Affichage liste 5/ sortie", "Devis", JOptionPane.QUESTION_MESSAGE);

			switch (choixD) {
			case "1":
				saisieDevis();
				break;
			case "2":
				modifDevis();
				break;
			case "3":
				suppressionDevis();
				break;
			case "4":				
			default:
				affichageDevis();
				break;
			}
		} while (!choixD.equals("5"));
	}
	private static void switchClient() throws SQLException {
		String ajout;
		String newSaisie;
		do {
			ajout = op.showInputDialog(null, "Voulez-vous créer un nouveau client (1) ? Supprimer des données (2) ? Modifier un élément (3) ? Afficher la liste des clients (4)", "Ajout d'un client", 			JOptionPane.QUESTION_MESSAGE);
			
			switch(ajout) {
			
				case "1":
				saisieClientInsert();
				break;	
				
				case "2":
				deleteClient();
				break;
				
				case "3":	
				saisieClientUpdate();
				break;
				
				case "4":
				ConnexionClient.displayClient();
				break;
				
				default:
				ConnexionClient.displayClient();
				break;
			}
			newSaisie = op.showInputDialog(null, "Voulez-vous faire une autre opération ? (y/n)", "Ajout d'une classe", JOptionPane.QUESTION_MESSAGE);
			
		}while(newSaisie.equals("y"));
	}
	private static void deleteClient() {

		id_client = Integer.parseInt(op.showInputDialog(null, "Entrer le matricule à supprimer", 					"Supprimer un client", JOptionPane.QUESTION_MESSAGE));
		String messageDelete = (ConnexionClient.deleteClientDB(id_client))?"ça marche":"suppression plantée";
		op.showMessageDialog(null, messageDelete);
	}

	private static void saisieClientInsert() {
		
		nom_client = op.showInputDialog(null, "Entrer le nom du client", "Ajout d'un client", 				JOptionPane.QUESTION_MESSAGE);
		prenom_client = op.showInputDialog(null, "Entrer le prénom du client", "Ajout d'un client", 				JOptionPane.QUESTION_MESSAGE);
		email_client = op.showInputDialog(null, "Entrer l'email du client", "Ajout d'un client", 				JOptionPane.QUESTION_MESSAGE);
		commentaires_client = op.showInputDialog(null, "Entrer le commentaire du client", "Ajout d'un client", 				JOptionPane.QUESTION_MESSAGE);
		societe_client = op.showInputDialog(null, "Entrer la société du client", "Ajout d'un client", 				JOptionPane.QUESTION_MESSAGE);
		cp_client = Integer.parseInt(op.showInputDialog(null, "Entrer le code postal du client", "Ajout d'un client", JOptionPane.QUESTION_MESSAGE));
		numTVA_client = Integer.parseInt(op.showInputDialog(null, "Entrer le numéro de TVA du client", "Ajout d'un client", JOptionPane.QUESTION_MESSAGE));
		siret_client = Integer.parseInt(op.showInputDialog(null, "Entrer le numéro de SIRET du client", "Ajout d'un client", JOptionPane.QUESTION_MESSAGE));
		String messageInsert = (ConnexionClient.insertClientDB(cp_client, numTVA_client, siret_client, email_client, commentaires_client, nom_client, prenom_client, societe_client))?"ça marche":"insertion plantée";
		op.showMessageDialog(null, messageInsert);
	}
	
	private static void saisieClientUpdate() throws SQLException {
		String new_nom_client = "";
		String new_prenom_client = "";
		String new_email_client = "";
		String new_commentaires_client = "";
		String new_societe_client = "";
		int new_cp_client = 0;
		int new_numTVA_client = 0;
		int new_siret_client = 0;
			
		ConnexionClient.displayClient();
		
		id_client = Integer.parseInt(op.showInputDialog(null, "Entrer le matricule du client à modifier", "Modification client", JOptionPane.QUESTION_MESSAGE));
		
		ConnexionClient.displayClientId(id_client);
		nom_client = ConnexionClient.nom_client;
		prenom_client = ConnexionClient.prenom_client;
		email_client = ConnexionClient.email_client;
		commentaires_client = ConnexionClient.commentaires_client;
		societe_client = ConnexionClient.societe_client;
		cp_client = ConnexionClient.cp_client;
		numTVA_client = ConnexionClient.numTVA_client;
		siret_client = ConnexionClient.siret_client;
		
		new_nom_client = op.showInputDialog(null, "Entrer le nom du client", "Modification client", 				JOptionPane.QUESTION_MESSAGE, null, null, ""+nom_client+"").toString();
		new_prenom_client = op.showInputDialog(null, "Entrer le prénom du client", "Modification client", 				JOptionPane.QUESTION_MESSAGE, null, null, ""+prenom_client+"").toString();
		new_email_client = op.showInputDialog(null, "Entrer l'email du client", "Modification client", 				JOptionPane.QUESTION_MESSAGE, null, null, ""+email_client+"").toString();
		new_commentaires_client = op.showInputDialog(null, "Entrer le commentaire du client", "Modification client", 				JOptionPane.QUESTION_MESSAGE, null, null, ""+commentaires_client+"").toString();
		new_societe_client = op.showInputDialog(null, "Entrer la société du client", "Modification client", 				JOptionPane.QUESTION_MESSAGE, null, null, ""+societe_client+"").toString();
		new_cp_client = Integer.parseInt(op.showInputDialog(null, "Entrer le code postal du client", "Modification client", JOptionPane.QUESTION_MESSAGE, null, null, ""+cp_client+"").toString());
		new_numTVA_client = Integer.parseInt(op.showInputDialog(null, "Entrer le numéro de TVA du client", "Modification client", JOptionPane.QUESTION_MESSAGE, null, null, ""+numTVA_client+"").toString());
		new_siret_client = Integer.parseInt(op.showInputDialog(null, "Entrer le numéro de SIRET du client", "Modification client", JOptionPane.QUESTION_MESSAGE, null, null, ""+siret_client+"").toString());
		String messageUpdate = (ConnexionClient.updateClientDB(id_client, new_cp_client, new_numTVA_client, new_siret_client, new_email_client, new_commentaires_client, new_nom_client, new_prenom_client, new_societe_client))?"ça marche":"modification plantée";
		op.showMessageDialog(null, messageUpdate);
	}
	
	/**
	 * Saisie des nouveaux  Devis
	 */
	private static void saisieDevis() {
		String newDevis;
		do {
			// saisie des données à insérer dans la table Devis
			
			libelle_devis = op.showInputDialog(null, "Quel est le libéllé de l'article ?", "Saisie devis", JOptionPane.QUESTION_MESSAGE);
			quantite_devis = Integer.parseInt(op.showInputDialog(null, "Quantité ?", "Saisie devis", JOptionPane.QUESTION_MESSAGE)); 
			valeur_devis = Integer.parseInt(op.showInputDialog(null, "Quel est la valeur de l'article ?", "Saisie devis", JOptionPane.QUESTION_MESSAGE)); 
			remises_devis = Integer.parseInt(op.showInputDialog(null, "Taux de remise ?", "Saisie devis", JOptionPane.QUESTION_MESSAGE));
			delaisPaiement_devis = Integer.parseInt(op.showInputDialog(null, "Délais de paiement ?", "Saisie devis", JOptionPane.QUESTION_MESSAGE));
			retard_devis = Integer.parseInt(op.showInputDialog(null, "Imputation retard de paiement : ", "Saisie devis", JOptionPane.QUESTION_MESSAGE));

			String saisie = (ConnexionDevis.insertDevisBdD(quantite_devis, libelle_devis, valeur_devis, remises_devis, retard_devis, delaisPaiement_devis))?"Ca marche":"insertion plantée";
			op.showMessageDialog(null, "Résultat de l'insertion "+saisie);

			newDevis = op.showInputDialog(null, "Voulez-créer un nouveau Devis ? (réponse o pour oui)?");
			
		} while (newDevis.equals("o"));
	}
	
	
	

	/**
	 * MODIFICATION des nouveaux  Devis
	 */
	private static void modifDevis() {
		
		ArrayList<Devis> listeDevis = ConnexionDevis.getDevisBdD();

		
		for (Devis devis : listeDevis) {
			op.showMessageDialog(null, "Devis =>"+" "+devis.getId_devis()+" "+devis.getLibelle_devis()+" "+devis.getQuantite_devis()
			+" "+devis.getValeur_devis()+" "+devis.getRemises_devis()+" "+devis.getDelaisPaiement_devis()+" "+devis.getRetard_devis());
		}
		
		String updateDevis;
		do {
						
			id_devis = Integer.parseInt(op.showInputDialog(null, "Quel est le N° du Devis à modifier ?"));
			libelle_devis = op.showInputDialog(null, "Quel est le libéllé de l'article ?", "Modif devis", JOptionPane.QUESTION_MESSAGE);
			quantite_devis = Integer.parseInt(op.showInputDialog(null, "Quantité ?", "Modif devis", JOptionPane.QUESTION_MESSAGE));
			valeur_devis = Integer.parseInt(op.showInputDialog(null, "Quel est la valeur de l'article ?", "Modif devis", JOptionPane.QUESTION_MESSAGE));							
			remises_devis = Integer.parseInt(op.showInputDialog(null, "Taux de remise ?", "Modif devis", JOptionPane.QUESTION_MESSAGE));
			delaisPaiement_devis = Integer.parseInt(op.showInputDialog(null, "Délais de paiement ", "Modif devis", JOptionPane.QUESTION_MESSAGE));
			retard_devis = Integer.parseInt(op.showInputDialog(null, "Imputation retard de paiement : ", "Modif devis", JOptionPane.QUESTION_MESSAGE));

			String saisie = (ConnexionDevis.updateDevisBD( id_devis,quantite_devis, libelle_devis, valeur_devis, remises_devis, retard_devis, delaisPaiement_devis))?"Ca marche":"insertion plantée";
			op.showMessageDialog(null, "Résultat de l'insertion "+saisie);

			updateDevis = op.showInputDialog(null, "Voulez-créer un nouveau Devis ? (réponse o pour oui)?", "Modif devis", JOptionPane.QUESTION_MESSAGE);
		} while (updateDevis.equals("o"));
	}
	
	
	private static void suppressionDevis() {
		// saisie des données à insérer dans la table Devis
		
		id_devis = Integer.parseInt(op.showInputDialog(null, "Quel est le n° du devis à supprimer ?", "Supp devis", JOptionPane.QUESTION_MESSAGE));

		String message = (ConnexionDevis.deleteDevisBdD(id_devis))?"Ca marche":"suppression plantée";
		op.showMessageDialog(null, "Résultat de la suppression "+message);
	}
	private static void affichageDevis() {
		ArrayList<Devis> listeDevis = ConnexionDevis.getDevisBdD();

		/**
		 *  Parcours de la liste et affichage des infos
		 */
		for (Devis devis : listeDevis) {
			op.showMessageDialog(null, "Devis =>"+" "+devis.getId_devis()+" "+devis.getLibelle_devis()+" "+devis.getQuantite_devis()
			+" "+devis.getValeur_devis()+" "+devis.getRemises_devis()+" "+devis.getDelaisPaiement_devis()+" "+devis.getRetard_devis());
		}
	}
	
	private static void modificationFacture() {
		// TODO Auto-generated method stub
		/*System.out.println("Quel est le n° de la facture à modifier ?");
		*/
		ArrayList<Facture> listeFacture = ConnexionFacture.getUpdateFactureBDD();
		System.out.println("Sélectionnez la facture que vous souhaitez modifier en tapant son numéro.");
		saisie2= new Scanner(System.in);
		id_facture_saisi = saisie2.nextInt();
		System.out.println("Quels sont les paramètres que vous souhaitez modifier ?");
		saisie = new Scanner(System.in);
		String choix2="";
		String newSaisie = "";
		do {
		System.out.println("1/Nombre d'articles dans la facture 2/Remise(s) sur la facture 3/Délais de paiement 4/Retards 5/Acompte(s) 6/Commentaires 7/Montant total 8/Facture réglée ?");
		choix2 = saisie.nextLine();
		switch (choix2) {
		case "1":
			System.out.println("Combien y-a-t-il d'articles dans cette facture ?");
			saisie2 = new Scanner(System.in);
			quantite_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "2":
			System.out.println("La nouvelle facture bénéficie-t-elle d'une remise ?");
			System.out.println("Si oui, précisez le montant.");
			saisie2 = new Scanner(System.in);
			remises_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "3":
			System.out.println("Quel est le délai de paiement de la facture ?");
			saisie2 = new Scanner(System.in);
			delaiPaiement_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "4":
			System.out.println("La facture a-t-elle des retards de paiement ?");
			saisie2 = new Scanner(System.in);
			retard_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "5":
			System.out.println("La nouvelle facture implique-t-elle un acompte ?");
			System.out.println("Si oui, précisez le montant.");
			saisie2 = new Scanner(System.in);
			acompte_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "6":
			System.out.println("Avez-vous un commentaire à faire concernant cette facture ?");
			saisie = new Scanner(System.in);
			libelle_facture = saisie.nextLine();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "7":
			System.out.println("Quel est le montant total de cette facture ?");
			saisie = new Scanner(System.in);
			valeur_facture = saisie2.nextInt();
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;
		case "8":
			System.out.println("La facture a-t-elle été réglée (y/n) ?");
			saisie2 = new Scanner(System.in);
			newSaisie = saisie.nextLine();
			reglement_facture = newSaisie.equals("y");
			System.out.println("Tapez 9 pour sortir de la boucle ou un autre chiffre pour continuer à modifier.");
			break;	
		default:
			break;
		}
	} while (!choix2.equals("9"));
		String message = (ConnexionFacture.updateFactureBDD(id_facture_saisi,quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, libelle_facture, valeur_facture, reglement_facture))?"Nouvelle facture modifiée.":"Nouvelle facture non modifiée.";
		choix2="9";
		System.out.println("Résultat de l'insertion "+message+".");
	}
	private static void affichageFacture() {
		// TODO Auto-generated method stub
		ArrayList<Facture> listeFacture = ConnexionFacture.getFactureBDD();

		/**
		 *  Parcours de la liste et affichage des infos
		 */
		for (Facture facture : listeFacture) {
			System.out.println("Factures => "+facture.getId_facture()+" "+facture.getQuantite_facture()+" "+facture.getRemises_facture()+" "+facture.getDelaiPaiement_facture()+" "+facture.getAcompte_facture()+" "+facture.getLibelle_facture()+" "+facture.getValeur_facture()+" "+facture.getReglement_facture());
		}
	}

	private static void suppressionFacture() {
		// TODO Auto-generated method stub
		// saisie des données à insérer dans la table élève
					System.out.println("Quel est le n° de la facture à supprimer ?");
					saisie= new Scanner(System.in);
					String id_facture = saisie.nextLine();

					String message = (ConnexionFacture.deleteFactureBDD(id_facture))?"Réussite.":"Echec.";
					System.out.println("Résultat de la suppression "+message);
	}

	private static void saisieFacture() {
		// TODO Auto-generated method stub
		String nouvelFacture;
		String newSaisie = "";
		do {
			// saisie des données à insérer dans la table élève
			System.out.println("Combien y-a-t-il d'articles dans cette facture ?");
			saisie2 = new Scanner(System.in);
			quantite_facture = saisie2.nextInt();
			System.out.println("La nouvelle facture bénéficie-t-elle d'une remise ?");
			System.out.println("Si oui, précisez le montant.");
			saisie2 = new Scanner(System.in);
			remises_facture = saisie2.nextInt();
			System.out.println("Quel est le délai de paiement de la facture ?");
			saisie2 = new Scanner(System.in);
			delaiPaiement_facture = saisie2.nextInt();
			System.out.println("La facture a-t-elle un retard de paiement ?");
			System.out.println("Si oui, précisez le montant.");
			saisie2 = new Scanner(System.in);
			retard_facture = saisie2.nextInt();
			System.out.println("La nouvelle facture implique-t-elle un acompte ?");
			System.out.println("Si oui, précisez le montant.");
			saisie2 = new Scanner(System.in);
			acompte_facture = saisie2.nextInt();
			System.out.println("Avez-vous un commentaire à faire concernant cette facture ?");
			saisie = new Scanner(System.in);
			libelle_facture = saisie.nextLine();
			System.out.println("Quel est le montant total de cette facture ?");
			saisie = new Scanner(System.in);
			valeur_facture = saisie2.nextInt();
			System.out.println("La facture a t-elle été réglée (y/n) ?");
			saisie2 = new Scanner(System.in);
			newSaisie = saisie.nextLine();
			reglement_facture = newSaisie.equals("y");
			String message = (ConnexionFacture.insertFactureBDD(quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, libelle_facture, valeur_facture, reglement_facture))?"Nouvelle facture rentrée.":"Nouvelle facture non rentrée.";
			System.out.println("Résultat de l'insertion "+message+".");
			System.out.println("Voulez-vous créer une nouvelle facture (O pour confirmer)?");
			saisie = new Scanner(System.in);
			nouvelFacture = saisie.nextLine();
		} while (nouvelFacture.equals("O"));
	}


}
