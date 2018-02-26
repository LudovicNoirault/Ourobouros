package main;



import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Main 
{
	public static void main(String[] args) 
	{
		JFrame fenetre = new JFrame();

		fenetre.setTitle("Ouroboros");

		fenetre.setSize(600,400);
		fenetre.setLocation(300,50);

		JPanel panel = new JPanel();

		JButton button1 = new JButton("Enregistrement de Client");	
		JButton button2= new JButton("Modification de client");		
		JButton button3= new JButton("Suppression de Client");		

		JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		fenetre.add(logo, BorderLayout.CENTER); 

		panel.setBackground(Color.DARK_GRAY);

		fenetre.setContentPane(panel);
		fenetre.setVisible(true);

		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lancerCreaClient();
			}
		});

		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lancerModifClient();
			}
		});

		button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lancerSupprClient();
			}
		});
	}

	public void paintComponent(Graphics Text)
	{
		Font font = new Font("Courier", Font.ITALIC,15);
		Text.setFont(font);
		Text.setColor(Color.white);

		Text.drawString("You have a new client, good job ! Register it now ...",10,20);
		Text.drawString("You sold something, let's create an invoice you'll send your customer",10,20);
		Text.drawString("You did all those invoices, isn't that great ? Have you collected the cash from all of it ?",10,20);
	}

	public static void lancerCreaClient()
	{
		JFrame fenetre2 = new JFrame();
		JPanel panel2 = new JPanel();

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));

		fenetre2.setContentPane(panel2);
		fenetre2.setVisible(true);

		JPanel panelClient = new JPanel();
		panelClient.setLayout(new BoxLayout(panelClient, BoxLayout.PAGE_AXIS));

		fenetre2.setTitle("Création d'un nouveau client");
		fenetre2.setSize(700,250);
		fenetre2.setLocation(200,120);

		JLabel titre = new JLabel("Veuillez saisir les informations.");

		JLabel labelnomClient  = new JLabel("Nom de l'entreprise : ");
		JTextField nomClient = new JTextField();
		nomClient.setColumns(10);

		JLabel labelnomDirecteur  = new JLabel("Nom du directeur : ");
		JTextField nomDirecteur = new JTextField();
		nomDirecteur.setColumns(10);

		panelClient.add(titre);
		panelClient.add(labelnomClient);
		panelClient.add(nomClient);
		panelClient.add(labelnomDirecteur);
		panelClient.add(nomDirecteur);

		JPanel panelAddLivr = new JPanel();
		panelAddLivr.setLayout(new BoxLayout(panelAddLivr, BoxLayout.PAGE_AXIS));

		JLabel titre2 = new JLabel("Entrez l'adresse de livraison.");

		JLabel labelnumRueLivr  = new JLabel("Numero : ");
		JTextField numRueLivr = new JTextField();

		numRueLivr.setColumns(10);

		JLabel labelrueLivr  = new JLabel("Nom de la rue : ");
		JTextField rueLivr = new JTextField();

		rueLivr.setColumns(10);

		JLabel labelcodePostalLivr  = new JLabel("Code Postal : ");
		JTextField codePostalLivr = new JTextField();

		codePostalLivr.setColumns(10);

		JLabel labelvilleLivr  = new JLabel("Ville : ");
		JTextField villeLivr = new JTextField();
		villeLivr.setColumns(10);

		JLabel labelpaysLivr  = new JLabel("Pays : ");
		JTextField paysLivr = new JTextField();
		paysLivr.setColumns(10);

		panelAddLivr.add(titre2);
		panelAddLivr.add(labelnumRueLivr);
		panelAddLivr.add(numRueLivr);
		panelAddLivr.add(labelrueLivr);
		panelAddLivr.add(rueLivr);
		panelAddLivr.add(labelvilleLivr);
		panelAddLivr.add(villeLivr);
		panelAddLivr.add(labelcodePostalLivr);
		panelAddLivr.add(codePostalLivr);
		panelAddLivr.add(labelpaysLivr);
		panelAddLivr.add(paysLivr);

		JPanel panelAddFact= new JPanel();
		panelAddFact.setLayout(new BoxLayout(panelAddFact, BoxLayout.PAGE_AXIS));

		JLabel titre3 = new JLabel("Entrez l'adresse de facturation.");
		JLabel labelnumRueFact  = new JLabel("Numero : ");
		JTextField numRueFact = new JTextField();

		numRueFact.setColumns(10);

		JLabel labelrueFact  = new JLabel("Nom de la rue : ");
		JTextField rueFact = new JTextField();
		rueFact.setColumns(10);

		JLabel labelcodePostalFact  = new JLabel("Code Postal : ");
		JTextField codePostalFact = new JTextField();
		codePostalFact.setColumns(10);

		JLabel labelvilleFact  = new JLabel("Ville : ");
		JTextField villeFact = new JTextField();
		villeFact.setColumns(10);

		JLabel labelpaysFact  = new JLabel("Pays : ");
		JTextField paysFact = new JTextField();
		paysFact.setColumns(10);

		panelAddFact.add(titre3);
		panelAddFact.add(labelnumRueFact);
		panelAddFact.add(numRueFact);
		panelAddFact.add(labelrueFact);
		panelAddFact.add(rueFact);
		panelAddFact.add(labelvilleFact);
		panelAddFact.add(villeFact);
		panelAddFact.add(labelcodePostalFact);
		panelAddFact.add(codePostalFact);
		panelAddFact.add(labelpaysFact);
		panelAddFact.add(paysFact);

		JButton validerClient = new JButton("Enregistrer le client");

		panel2.add(panelClient);
		panel2.add(panelAddLivr);
		panel2.add(panelAddFact);
		panel2.add(validerClient);

		validerClient.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int inptNumAdreFact = Integer.parseInt(numRueFact.getText());
				String inptRueAdreFact = rueFact.getText();	
				String inptVilleAdreFact = villeFact.getText();
				int inptCpAdreFact =  Integer.parseInt(codePostalFact.getText());
				String inptPaysAdreFact = paysFact.getText();
				
				int inptNumAdreLivr = Integer.parseInt(numRueLivr.getText());
				String inptRueAdreLivr = rueLivr.getText();
				String inptVilleAdreLivr = villeLivr.getText();
				int inptCpAdreLivr =  Integer.parseInt(codePostalLivr.getText());
				String inptPaysAdreLivr = paysLivr.getText();
				
				String inptNomClient = nomClient.getText();
				String inptNomDirecteur= nomDirecteur.getText();
				
				ConnectToBDD connection = new ConnectToBDD();
				connection.getConnection();
				recuperInfosCreaClient(
						inptNumAdreFact,inptRueAdreFact,inptVilleAdreFact,inptCpAdreFact,inptPaysAdreFact,
						inptNumAdreLivr,inptRueAdreLivr,inptVilleAdreLivr,inptCpAdreLivr,inptPaysAdreLivr,
						inptNomClient, inptNomDirecteur);
			}
		});
	}

	public static void lancerModifClient()
	{
		JFrame fenetreModifClient = new JFrame();
		JPanel panelModifClient = new JPanel();

		fenetreModifClient.setContentPane(panelModifClient);
		fenetreModifClient.setVisible(true);
		fenetreModifClient.setTitle("Modification d'un client existant");
		fenetreModifClient.setSize(400,400);
		fenetreModifClient.setLocation(310,120);

		JLabel labelModifNomClient  = new JLabel("Client a modifier : ");
		List listeNomClient = new List();

		listeNomClient.add("Test");

		panelModifClient.add(labelModifNomClient);
		panelModifClient.add(listeNomClient);

		JButton validerModif = new JButton("Acceder au client a modifier");
		panelModifClient.add(validerModif);

		// Puis la  va falloir rouvrir la fenetre de creation toute pré-remplie des infos du 
		// client mais je sais pas faire...
	}

	public static void lancerSupprClient() 
	{
		JFrame fenetreSupprClient = new JFrame();
		JPanel panelSupprClient = new JPanel();

		fenetreSupprClient.setContentPane(panelSupprClient);
		fenetreSupprClient.setVisible(true);
		fenetreSupprClient.setTitle("Supprimer un client existant");

		fenetreSupprClient.setSize(400,400);

		fenetreSupprClient.setLocation(310,120);

		JLabel labelSupprNomClient  = new JLabel("Client a supprimer : ");

		List listeNomClient = new List();

		listeNomClient.add("Test");

		panelSupprClient.add(labelSupprNomClient);
		panelSupprClient.add(listeNomClient);

		JButton validerSuppr = new JButton("Supprimer le client");
		panelSupprClient.add(validerSuppr);

//		validerSuppr.addActionListener(new ActionListener()
//		{
//		public void actionPerformed(ActionEvent e)
//			{
//			deleteLesValuesDansLaBdd();
//			}
//	});
	}
	public static void recuperInfosCreaClient(
			int fact1, String fact2,String fact3,int fact4,String fact5,
			int livr1, String livr2,String livr3,int livr4,String livr5,
			String clt1, String clt2)
	{
		int retourBDDFacture =0;
		int retourBDDLivraison =0;
		Connection connection  = ConnectToBDD.getConnection();
		String sqlAdrFact = "INSERT INTO adressefacture (idAdresseFacture, numeroAdresseFacture, rueAdresseFacture, villeAdresseFacture, codepostalAdresseFacture, paysAdresseFacture) VALUES (NULL, "+fact1+", '"+fact2+"', '"+fact3+"', "+fact4+",'"+fact5+"')";
		try
		{
			PreparedStatement psAF = connection.prepareStatement(sqlAdrFact);
			psAF.executeUpdate();
			System.out.println("Requete SQL 1 faite.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		String sqlAdrLivr = "INSERT INTO adresselivaison (idAdresseLivraison, numeroAdresseLivraison, rueAdresseLivraison, villeAdresseLivraison, codepostalAdresseLivraison, paysAdresseLivraison)  VALUES (NULL, "+livr1+", '"+livr2+"', '"+livr3+"', "+livr4+",'"+livr5+"')";
		try
		{
			PreparedStatement psAL = connection.prepareStatement(sqlAdrLivr);
			psAL.executeUpdate();
			System.out.println("Requete SQL 2 faite.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		String sqlGetIdFact = "SELECT idAdresseFacture FROM adresseFacture WHERE numeroAdresseFacture LIKE "+fact1+" AND rueAdresseFacture LIKE '"+fact2+"';";
		try 
		{
			PreparedStatement psGetIdFact = connection.prepareStatement(sqlGetIdFact);
			ResultSet  rs = psGetIdFact.executeQuery();
			rs.next();
			retourBDDFacture= rs.getInt("idAdresseFacture");
			System.out.println("Requete SQL 3 faite.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		String sqlGetIdLivr = "SELECT idAdresseLivraison FROM adresseLivaison WHERE numeroAdresseLivraison LIKE "+livr1+" AND rueAdresseLivraison LIKE '"+livr2+"';";
		try 
		{
			PreparedStatement psGetIdLivr = connection.prepareStatement(sqlGetIdLivr);
			ResultSet  rs = psGetIdLivr.executeQuery();
			rs.next();
			retourBDDLivraison= rs.getInt("idAdresseLivraison");
			System.out.println("Requete SQL 4 faite.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		String sqlClient = "INSERT INTO client (idClient, nomClient, nomDirigeantClient, idAdresseFacture, idAdresseLivraison ) VALUES (NULL, '"+clt1+"', '"+clt2+"', "+retourBDDFacture+", "+retourBDDLivraison+")";
		try
		{
			PreparedStatement psC = connection.prepareStatement(sqlClient);
			psC.executeUpdate();
			System.out.println("Requete SQL 5 faite.");
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

