/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.ecrans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ouroboros.classes.Ecran;
import ouroboros.sql.ConnectToBDD;
import ouroboros.sql.CreateClient;
import ouroboros.sql.ReadClient;

/**
 *
 * @author user
 */
public class EcranClientRead
{
    public static void ParametresClientRead(Ecran ecran)
    {
    	JFrame clientRead = new JFrame();
		JPanel panelGeneralClientRead = new JPanel();
		panelGeneralClientRead.setLayout(new BoxLayout(panelGeneralClientRead, BoxLayout.LINE_AXIS));
		clientRead.setContentPane(panelGeneralClientRead);
		clientRead.setVisible(true);
		JPanel panelInfosClientRead = new JPanel();
		panelInfosClientRead.setLayout(new BoxLayout(panelInfosClientRead, BoxLayout.PAGE_AXIS));
		clientRead.setTitle("Affichage client : ");
		clientRead.setSize(735,250);
		clientRead.setLocation(200,120);
		JLabel titre = new JLabel("Voici les informations reltives au client :");
		JLabel labelnomClient  = new JLabel("Nom de l'entreprise : ");
		JTextField nomClient = new JTextField();
		nomClient.setColumns(10);
		JLabel labelnomDirecteur  = new JLabel("Nom du directeur : ");
		JTextField nomDirecteur = new JTextField();
		nomDirecteur.setColumns(10);
		panelInfosClientRead.add(titre);
		panelInfosClientRead.add(labelnomClient);
		panelInfosClientRead.add(nomClient);
		panelInfosClientRead.add(labelnomDirecteur);
		panelInfosClientRead.add(nomDirecteur);
		JPanel panelAdresseLivraisonClientRead= new JPanel();
		panelAdresseLivraisonClientRead.setLayout(new BoxLayout(panelAdresseLivraisonClientRead, BoxLayout.PAGE_AXIS));
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
		panelAdresseLivraisonClientRead.add(titre2);
		panelAdresseLivraisonClientRead.add(labelnumRueLivr);
		panelAdresseLivraisonClientRead.add(numRueLivr);
		panelAdresseLivraisonClientRead.add(labelrueLivr);
		panelAdresseLivraisonClientRead.add(rueLivr);
		panelAdresseLivraisonClientRead.add(labelvilleLivr);
		panelAdresseLivraisonClientRead.add(villeLivr);
		panelAdresseLivraisonClientRead.add(labelcodePostalLivr);
		panelAdresseLivraisonClientRead.add(codePostalLivr);
		panelAdresseLivraisonClientRead.add(labelpaysLivr);
		panelAdresseLivraisonClientRead.add(paysLivr);
		JPanel panelAdresseFactureClientRead= new JPanel();
		panelAdresseFactureClientRead.setLayout(new BoxLayout(panelAdresseFactureClientRead, BoxLayout.PAGE_AXIS));
		JLabel titre3 = new JLabel("adresse de facturation.");
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
		panelAdresseFactureClientRead.add(titre3);
		panelAdresseFactureClientRead.add(labelnumRueFact);
		panelAdresseFactureClientRead.add(numRueFact);
		panelAdresseFactureClientRead.add(labelrueFact);
		panelAdresseFactureClientRead.add(rueFact);
		panelAdresseFactureClientRead.add(labelvilleFact);
		panelAdresseFactureClientRead.add(villeFact);
		panelAdresseFactureClientRead.add(labelcodePostalFact);
		panelAdresseFactureClientRead.add(codePostalFact);
		panelAdresseFactureClientRead.add(labelpaysFact);
		panelAdresseFactureClientRead.add(paysFact);      
	        JPanel panelBtnClientRead = new JPanel();
		panelBtnClientRead.setLayout(new BoxLayout(panelBtnClientRead, BoxLayout.PAGE_AXIS));
	        JButton validerClient = new JButton("Valider");
		panelBtnClientRead.add(validerClient);
		panelGeneralClientRead.add(panelInfosClientRead);
		panelGeneralClientRead.add(panelAdresseLivraisonClientRead);
		panelGeneralClientRead.add(panelAdresseFactureClientRead);
	        panelGeneralClientRead.add(panelBtnClientRead);
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
					ReadClient listeClient = new ReadClient[];
				listeClient.lireListeClient(inptNumAdreFact,inptRueAdreFact,inptVilleAdreFact,inptCpAdreFact,inptPaysAdreFact, inptNumAdreLivr,inptRueAdreLivr,inptVilleAdreLivr,inptCpAdreLivr,inptPaysAdreLivr, inptNomClient, inptNomDirecteur);
		        }
	        }    
    }
}
