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
public class EcranClient {
        public static void ParametresEcranClient(Ecran ecran){
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel clientPanel = new JPanel();
        JButton clientBtnCreate = new JButton("Ajouter un nouveau client");	
        JButton clientBtnUpdate = new JButton("Modifier les infos d'un client");		
        JButton clientBtnRead = new JButton("Consulter la fiche d'un client");
        JButton clientBtnDelete = new JButton("Supprimer un client");
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        clientPanel.add(clientBtnCreate);
        clientPanel.add(clientBtnUpdate);
        clientPanel.add(clientBtnRead);
        clientPanel.add(clientBtnDelete);
        ecran.add(logo, BorderLayout.CENTER); 
        clientPanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(clientPanel);
        ecran.setVisible(true);
        Ecran clientCreate = new Ecran();
        Ecran clientUpdate = new Ecran();
        Ecran clientRead = new Ecran();
        Ecran clientDelete = new Ecran();
        clientBtnCreate.addActionListener(new ActionListener()

		{

			public void actionPerformed(ActionEvent e)

			{
                                EcranClientCreate ecranClientCreate = new EcranClientCreate();
				ecranClientCreate.ParametresClientCreate(clientCreate);

			}

		});
        clientBtnUpdate.addActionListener(new ActionListener()

		{

			public void actionPerformed(ActionEvent e)

			{

				EcranClientUpdate ecranClientUpdate = new EcranClientUpdate();
				ecranClientUpdate.ParametresClientUpdate(clientUpdate);

			}

		});
        clientBtnRead.addActionListener(new ActionListener()

		{

			public void actionPerformed(ActionEvent e)

			{

				EcranClientRead ecranClientRead = new EcranClientRead();
				ListeClient listeClient = new ListeClient();
				List<String> liste = listeClient.lireListeClient();
				ecranClientRead.ParametresClientRead(clientRead, liste);

			}

		});
        clientBtnDelete.addActionListener(new ActionListener()

		{

			public void actionPerformed(ActionEvent e)

			{

				EcranClientDelete ecranClientDelete = new EcranClientDelete();
				ecranClientDelete.ParametresClientDelete(clientDelete);

			}

		});
        
    }
}
