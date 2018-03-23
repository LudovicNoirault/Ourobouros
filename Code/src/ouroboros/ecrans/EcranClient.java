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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ouroboros.classes.Ecran;
import ouroboros.sql.ListeClient;


/**
 *
 * @author user
 */
public class EcranClient
{
	public static void ParametresEcranClient(Ecran ecran)
        {
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel clientPanel = new JPanel();
        JButton clientBtnCreate = new JButton("Ajouter un nouveau client");	
        JButton clientBtnListe = new JButton("Selection des clients");		
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        clientPanel.add(clientBtnCreate);
        clientPanel.add(clientBtnListe);
        ecran.add(logo, BorderLayout.CENTER); 
        clientPanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(clientPanel);
        ecran.setVisible(true);
        Ecran clientCreate = new Ecran();
        Ecran clientListe = new Ecran();
        
        
        clientBtnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                EcranClientCreate ecranClientCreate = new EcranClientCreate();
				ecranClientCreate.ParametresClientCreate(clientCreate);
			}
		});
       
        
        clientBtnListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				EcranClientSelection ecranClientRead = new EcranClientSelection();
				ListeClient listeClient = new ListeClient();
				List<String> liste = listeClient.lireListeClient();
				ecranClientRead.ParametresClientRead(clientListe,liste);
			}
		});
             
    }
}
