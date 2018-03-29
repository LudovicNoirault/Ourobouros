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
public class EcranFacture {
    public static void ParametresEcranFacture(Ecran ecran){
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel facturePanel = new JPanel();
        JButton factureBtnCreate = new JButton("Ajouter une nouvelle facture");	
        JButton factureBtnListe = new JButton("Selection des factures");		
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        facturePanel.add(factureBtnCreate);
        facturePanel.add(factureBtnListe);
        ecran.add(logo, BorderLayout.CENTER); 
        facturePanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(facturePanel);
        ecran.setVisible(true);
        Ecran factureCreate = new Ecran();
        Ecran factureListe = new Ecran();
        
        
        factureBtnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
               
			}
		});
       
        
        factureBtnListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
          
    }
}
