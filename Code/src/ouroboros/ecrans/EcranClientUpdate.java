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
import ouroboros.sql.UpdateClient;

public class EcranClientUpdate 
{
	public static void ParametresClientRead(Ecran ecran, int clientId, String nom1, String nomboss, int livrId, String numeroRueLivr, String nomRueLivr, String nomVilleLivr, String codePostLivr, String nomPaysLivr, int factId, String numeroRueFact, String nomRueFact, String nomVilleFact, String codePostFact, String nomPaysFact)
    {
        JFrame ClientUpdate = new JFrame();
		JPanel panelGeneralClientUpdate = new JPanel();
		panelGeneralClientUpdate.setLayout(new BoxLayout(panelGeneralClientUpdate, BoxLayout.LINE_AXIS));
		ClientUpdate.setContentPane(panelGeneralClientUpdate);
		ClientUpdate.setVisible(true);
		JPanel panelInfosClientUpdate = new JPanel();
		panelInfosClientUpdate.setLayout(new BoxLayout(panelInfosClientUpdate, BoxLayout.PAGE_AXIS));
		ClientUpdate.setTitle("Modification d'un client");
		ClientUpdate.setSize(735,250);
		ClientUpdate.setLocation(200,120);
				
		JLabel labelnomClient  = new JLabel("Nom de l'entreprise : ");
		JTextField nomClient = new JTextField(nom1);
		nomClient.setColumns(10);
		JLabel labelnomDirecteur  = new JLabel("Nom du directeur : ");
		JTextField nomDirecteur = new JTextField(nomboss);
		nomDirecteur.setColumns(10);
		panelInfosClientUpdate.add(labelnomClient);
		panelInfosClientUpdate.add(nomClient);
		panelInfosClientUpdate.add(labelnomDirecteur);
		panelInfosClientUpdate.add(nomDirecteur);
		
		
		JPanel panelAdresseLivraisonClientUpdate = new JPanel();
		panelAdresseLivraisonClientUpdate.setLayout(new BoxLayout(panelAdresseLivraisonClientUpdate, BoxLayout.PAGE_AXIS));
		JLabel labelnumRueLivr  = new JLabel("Numero : ");
		JTextField numRueLivr = new JTextField(numeroRueLivr);
		numRueLivr.setColumns(10);
		JLabel labelrueLivr  = new JLabel("Nom de la rue : ");
		JTextField rueLivr = new JTextField(nomRueLivr);
		rueLivr.setEditable(true);
		rueLivr.setColumns(10);
		JLabel labelcodePostalLivr  = new JLabel("Code Postal : ");
		JTextField codePostalLivr = new JTextField(codePostLivr);
		codePostalLivr.setColumns(10);
		JLabel labelvilleLivr  = new JLabel("Ville : ");
		JTextField villeLivr = new JTextField(nomVilleLivr);
		villeLivr.setColumns(10);
		JLabel labelpaysLivr  = new JLabel("Pays : ");
		JTextField paysLivr = new JTextField(nomPaysLivr);
		paysLivr.setColumns(10);
		panelAdresseLivraisonClientUpdate.add(labelnumRueLivr);
		panelAdresseLivraisonClientUpdate.add(numRueLivr);
		panelAdresseLivraisonClientUpdate.add(labelrueLivr);
		panelAdresseLivraisonClientUpdate.add(rueLivr);
		panelAdresseLivraisonClientUpdate.add(labelvilleLivr);
		panelAdresseLivraisonClientUpdate.add(villeLivr);
		panelAdresseLivraisonClientUpdate.add(labelcodePostalLivr);
		panelAdresseLivraisonClientUpdate.add(codePostalLivr);
		panelAdresseLivraisonClientUpdate.add(labelpaysLivr);
		panelAdresseLivraisonClientUpdate.add(paysLivr);
				
		JPanel panelAdresseFactureClientUpdate = new JPanel();
		panelAdresseFactureClientUpdate.setLayout(new BoxLayout(panelAdresseFactureClientUpdate, BoxLayout.PAGE_AXIS));
		JLabel labelnumRueFact  = new JLabel("Numero : ");
		JTextField numRueFact = new JTextField(numeroRueFact);
		numRueFact.setColumns(10);
		JLabel labelrueFact  = new JLabel("Nom de la rue : ");
		JTextField rueFact = new JTextField(nomRueFact);
		rueFact.setColumns(10);
		JLabel labelcodePostalFact  = new JLabel("Code Postal : ");
		JTextField codePostalFact = new JTextField(codePostFact);
		codePostalFact.setColumns(10);
		JLabel labelvilleFact  = new JLabel("Ville : ");
		JTextField villeFact = new JTextField(nomVilleFact);
		villeFact.setColumns(10);
		JLabel labelpaysFact  = new JLabel("Pays : ");
		JTextField paysFact = new JTextField(nomPaysFact);
		paysFact.setColumns(10);
		
		JButton validerClient = new JButton("Valider");
		 
		panelAdresseFactureClientUpdate.add(labelnumRueFact);
		panelAdresseFactureClientUpdate.add(numRueFact);
		panelAdresseFactureClientUpdate.add(labelrueFact);
		panelAdresseFactureClientUpdate.add(rueFact);
		panelAdresseFactureClientUpdate.add(labelvilleFact);
		panelAdresseFactureClientUpdate.add(villeFact);
		panelAdresseFactureClientUpdate.add(labelcodePostalFact);
		panelAdresseFactureClientUpdate.add(codePostalFact);
		panelAdresseFactureClientUpdate.add(labelpaysFact);
		panelAdresseFactureClientUpdate.add(paysFact);      
	        
		JPanel panelBtnClientUpdate = new JPanel();
		panelBtnClientUpdate.setLayout(new BoxLayout(panelBtnClientUpdate, BoxLayout.PAGE_AXIS));
		panelGeneralClientUpdate.add(panelInfosClientUpdate);
		panelGeneralClientUpdate.add(panelAdresseLivraisonClientUpdate);
		panelGeneralClientUpdate.add(panelAdresseFactureClientUpdate);
	    panelGeneralClientUpdate.add(panelBtnClientUpdate);    
	    panelGeneralClientUpdate.add(validerClient);
	    
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
		
                System.out.println("Valeur a envoyer : "+inptNumAdreFact+","+inptRueAdreFact+","+inptVilleAdreFact+","+inptCpAdreFact+","+inptPaysAdreFact+","+inptNumAdreLivr+","+inptRueAdreLivr+","+inptVilleAdreLivr+","+inptCpAdreLivr+","+inptPaysAdreLivr+","+inptNomClient+","+inptNomDirecteur);

            	
            	ConnectToBDD connection = new ConnectToBDD();
            	connection.getConnection();
                UpdateClient updateClient = new UpdateClient();                
                updateClient.updateSelectedClient(factId,inptNumAdreFact,inptRueAdreFact,inptVilleAdreFact,inptCpAdreFact,inptPaysAdreFact, livrId, inptNumAdreLivr,inptRueAdreLivr,inptVilleAdreLivr,inptCpAdreLivr,inptPaysAdreLivr, clientId, inptNomClient, inptNomDirecteur);
            }
        }
    );
}
}