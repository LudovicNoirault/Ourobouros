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
public class EcranCommande {
    public static void ParametresEcranCommande(Ecran ecran){
                ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel commandePanel = new JPanel();
        JButton commandeBtnCreate = new JButton("Ajouter une nouvelle commande");	
        JButton commandeBtnListe = new JButton("Sélection des commandes");		
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        commandePanel.add(commandeBtnCreate);
        commandePanel.add(commandeBtnListe);
        ecran.add(logo, BorderLayout.CENTER); 
        commandePanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(commandePanel);
        ecran.setVisible(true);
        Ecran commandeCreate = new Ecran();
        Ecran commandeListe = new Ecran();
        
        
        commandeBtnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                
			}
		});
       
        
        commandeBtnListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
          
    }
}
