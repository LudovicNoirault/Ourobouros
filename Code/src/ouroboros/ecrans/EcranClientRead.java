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
public class EcranClientRead {
        public static void ParametresClientRead(Ecran ecran, String nom1, String nomboss, int numeroRueLivr, String nomRueLivr, String nomVilleLivr, int codePostLivr, String nomPaysLivr,int numeroRueFact, String nomRueFact, String nomVilleFact, int codePostFact, String nomPaysFact)
    {
        JFrame clientCreate = new JFrame();
		JPanel panelGeneralClientCreate = new JPanel();
		panelGeneralClientCreate.setLayout(new BoxLayout(panelGeneralClientCreate, BoxLayout.LINE_AXIS));
		clientCreate.setContentPane(panelGeneralClientCreate);
		clientCreate.setVisible(true);
		JPanel panelInfosClientCreate = new JPanel();
		panelInfosClientCreate.setLayout(new BoxLayout(panelInfosClientCreate, BoxLayout.PAGE_AXIS));
		clientCreate.setTitle("Consultation d'un client");
		clientCreate.setSize(735,250);
		clientCreate.setLocation(200,120);
				
		JLabel labelnomClient  = new JLabel("Nom de l'entreprise : ");
		JTextField nomClient = new JTextField(nom1);
		nomClient.setEditable(false);
		nomClient.setColumns(10);
		JLabel labelnomDirecteur  = new JLabel("Nom du directeur : ");
		JTextField nomDirecteur = new JTextField(nomboss);
		nomDirecteur.setEditable(false);
		nomDirecteur.setColumns(10);
		panelInfosClientCreate.add(labelnomClient);
		panelInfosClientCreate.add(nomClient);
		panelInfosClientCreate.add(labelnomDirecteur);
		panelInfosClientCreate.add(nomDirecteur);
		
		
		JPanel panelAdresseLivraisonClientCreate = new JPanel();
		panelAdresseLivraisonClientCreate.setLayout(new BoxLayout(panelAdresseLivraisonClientCreate, BoxLayout.PAGE_AXIS));
		JLabel labelnumRueLivr  = new JLabel("Numero : ");
		JTextField numRueLivr = new JTextField(numeroRueLivr);
		numRueLivr.setEditable(false);
		numRueLivr.setColumns(10);
		JLabel labelrueLivr  = new JLabel("Nom de la rue : ");
		JTextField rueLivr = new JTextField(nomRueLivr);
		rueLivr.setEditable(false);
		rueLivr.setColumns(10);
		JLabel labelcodePostalLivr  = new JLabel("Code Postal : ");
		JTextField codePostalLivr = new JTextField(nomVilleLivr);
		codePostalLivr.setEditable(false);
		codePostalLivr.setColumns(10);
		JLabel labelvilleLivr  = new JLabel("Ville : ");
		JTextField villeLivr = new JTextField(codePostLivr);
		villeLivr.setEditable(false);
		villeLivr.setColumns(10);
		JLabel labelpaysLivr  = new JLabel("Pays : ");
		JTextField paysLivr = new JTextField(nomPaysLivr);
		paysLivr.setEditable(false);
		paysLivr.setColumns(10);
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
		JLabel labelnumRueFact  = new JLabel("Numero : ");
		JTextField numRueFact = new JTextField(numeroRueFact);
		numRueFact.setEditable(false);
		numRueFact.setColumns(10);
		JLabel labelrueFact  = new JLabel("Nom de la rue : ");
		JTextField rueFact = new JTextField(nomRueFact);
		rueFact.setEditable(false);
		rueFact.setColumns(10);
		JLabel labelcodePostalFact  = new JLabel("Code Postal : ");
		JTextField codePostalFact = new JTextField(nomVilleFact);
		codePostalFact.setEditable(false);
		codePostalFact.setColumns(10);
		JLabel labelvilleFact  = new JLabel("Ville : ");
		JTextField villeFact = new JTextField(codePostFact);
		villeFact.setEditable(false);
		villeFact.setColumns(10);
		JLabel labelpaysFact  = new JLabel("Pays : ");
		JTextField paysFact = new JTextField(nomPaysFact);
		paysFact.setEditable(false);
		paysFact.setColumns(10);
		 
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
		panelGeneralClientCreate.add(panelInfosClientCreate);
		panelGeneralClientCreate.add(panelAdresseLivraisonClientCreate);
		panelGeneralClientCreate.add(panelAdresseFactureClientCreate);
	    panelGeneralClientCreate.add(panelBtnClientCreate);    
	   
    }
}
