/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.ecrans;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ouroboros.classes.Ecran;


/**
 *
 * @author user
 */
public class PremierEcran 
{
    public static void ParametresPremierEcran(Ecran ecran)
    {
    	ecran.setTitle("Ouroboros");
	    ecran.setSize(750,500);
	    ecran.setLocation(300,50);
	
	    JPanel accueilPanel = new JPanel(new GridLayout(3,1));
	    JLabel slogan = new JLabel ("Ourobouros, Votre solution de gestion qu'elle est bien");
	    
	    slogan.setForeground(Color.WHITE);
	    
	    JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
	    accueilPanel.add(slogan);
	    accueilPanel.add(logo);
	    
	    JButton accueilBtnClient = new JButton("Client");	
	    JButton accueilBtnFacture = new JButton("Facture");		
	    JButton accueilBtnCommande = new JButton("Commande");
	    JButton accueilBtnProduit = new JButton("Produit");
	
	    accueilPanel.add(accueilBtnClient);
	    accueilPanel.add(accueilBtnFacture);
	    accueilPanel.add(accueilBtnCommande);
	    accueilPanel.add(accueilBtnProduit);
	    accueilPanel.setBackground(Color.DARK_GRAY);
	    ecran.setContentPane(accueilPanel);
	    ecran.setVisible(true);
	        
	    Ecran eClient = new Ecran();
	    Ecran eFacture = new Ecran();
	    Ecran eCommande = new Ecran();
	    Ecran eProduit = new Ecran();
	    
	    accueilBtnClient.addActionListener(new ActionListener()
		{
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		new EcranClient();
	            EcranClient.ParametresEcranClient(eClient);
			}
		});
	    accueilBtnFacture.addActionListener(new ActionListener()
		{
	    	public void actionPerformed(ActionEvent e)
			{
				new EcranFacture();
	            EcranFacture.ParametresEcranFacture(eFacture);
			}
		});
	    accueilBtnCommande.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new EcranCommande();
				EcranCommande.ParametresEcranCommande(eCommande);
			}
		});
	    accueilBtnProduit.addActionListener(new ActionListener()
		{
	    	public void actionPerformed(ActionEvent e)
			{
	    		new EcranProduit();
	            EcranProduit.ParametresEcranProduit(eProduit);
			}
		});
    }
}