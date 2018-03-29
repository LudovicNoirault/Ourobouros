/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.ecrans;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class EcranProduit {
    public static void ParametresEcranProduit(Ecran ecran){
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel produitPanel = new JPanel();
        JButton produitBtnCreate = new JButton("Ajouter un nouveau produit");	
        JButton produitBtnListe = new JButton("Selection des produits");		
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        produitPanel.add(produitBtnCreate);
        produitPanel.add(produitBtnListe);
        ecran.add(logo, BorderLayout.CENTER); 
        produitPanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(produitPanel);
        ecran.setVisible(true);
        Ecran produitCreate = new Ecran();
        Ecran produitListe = new Ecran();
        
        
        produitBtnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
               
			}
		});
       
        
        produitBtnListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
          
    }
}
