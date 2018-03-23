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

/**
 *
 * @author user
 */
public class EcranClientCreate 
{
    public static void ParametresClientCreate(Ecran ecran)
    {
        JFrame clientCreate = new JFrame();
		JPanel panelGeneralClientCreate = new JPanel();
		panelGeneralClientCreate.setLayout(new BoxLayout(panelGeneralClientCreate, BoxLayout.LINE_AXIS));
		clientCreate.setContentPane(panelGeneralClientCreate);
		clientCreate.setVisible(true);
		JPanel panelInfosClientCreate = new JPanel();
		panelInfosClientCreate.setLayout(new BoxLayout(panelInfosClientCreate, BoxLayout.PAGE_AXIS));
		clientCreate.setTitle("Cr�ation d'un nouveau client");
		clientCreate.setSize(735,250);
		clientCreate.setLocation(200,120);
		JLabel titre = new JLabel("Veuillez saisir les informations relatives au client.");
		JLabel labelnomClient  = new JLabel("Nom de l'entreprise : ");
		JTextField nomClient = new JTextField();
		nomClient.setColumns(10);
		JLabel labelnomDirecteur  = new JLabel("Nom du directeur : ");
		JTextField nomDirecteur = new JTextField();
		nomDirecteur.setColumns(10);
		panelInfosClientCreate.add(titre);
		panelInfosClientCreate.add(labelnomClient);
		panelInfosClientCreate.add(nomClient);
		panelInfosClientCreate.add(labelnomDirecteur);
		panelInfosClientCreate.add(nomDirecteur);
		JPanel panelAdresseLivraisonClientCreate = new JPanel();
		panelAdresseLivraisonClientCreate.setLayout(new BoxLayout(panelAdresseLivraisonClientCreate, BoxLayout.PAGE_AXIS));
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
		panelAdresseLivraisonClientCreate.add(titre2);
		panelAdresseLivraisonClientCreate.add(labelnumRueLivr);
		panelAdresseLivraisonClientCreate.add(numRueLivr);
		panelAdresseLivraisonClientCreate.add(labelrueLivr);
		panelAdresseLivraisonClientCreate.add(rueLivr);
		panelAdresseLivraisonClientCreate.add(labelvilleLivr);
		panelAdresseLivraisonClientCreate.add(villeLivr);
		panelAdresseLivraisonClientCreate.add(labelcodePostalLivr);
		panelAdresseLivraisonClientCreate.add(codePostalLivr);
		panelAdresseLivraisonClientCreate.add(labelpaysLivr);
		panelAdresseLivraisonClientCreate.add(paysLivr);
		JPanel panelAdresseFactureClientCreate = new JPanel();
		panelAdresseFactureClientCreate.setLayout(new BoxLayout(panelAdresseFactureClientCreate, BoxLayout.PAGE_AXIS));
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
		panelAdresseFactureClientCreate.add(titre3);
		panelAdresseFactureClientCreate.add(labelnumRueFact);
		panelAdresseFactureClientCreate.add(numRueFact);
		panelAdresseFactureClientCreate.add(labelrueFact);
		panelAdresseFactureClientCreate.add(rueFact);
		panelAdresseFactureClientCreate.add(labelvilleFact);
		panelAdresseFactureClientCreate.add(villeFact);
		panelAdresseFactureClientCreate.add(labelcodePostalFact);
		panelAdresseFactureClientCreate.add(codePostalFact);
		panelAdresseFactureClientCreate.add(labelpaysFact);
		panelAdresseFactureClientCreate.add(paysFact);      
	        JPanel panelBtnClientCreate = new JPanel();
		panelBtnClientCreate.setLayout(new BoxLayout(panelBtnClientCreate, BoxLayout.PAGE_AXIS));
	        JButton validerClient = new JButton("Valider");
		panelBtnClientCreate.add(validerClient);
		panelGeneralClientCreate.add(panelInfosClientCreate);
		panelGeneralClientCreate.add(panelAdresseLivraisonClientCreate);
		panelGeneralClientCreate.add(panelAdresseFactureClientCreate);
	        panelGeneralClientCreate.add(panelBtnClientCreate);
	        validerClient.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
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
	                CreateClient nouveauClient = new CreateClient();
			nouveauClient.creerNouveauClient(inptNumAdreFact,inptRueAdreFact,inptVilleAdreFact,inptCpAdreFact,inptPaysAdreFact, inptNumAdreLivr,inptRueAdreLivr,inptVilleAdreLivr,inptCpAdreLivr,inptPaysAdreLivr, inptNomClient, inptNomDirecteur);
	        }
	    });
    }
}
