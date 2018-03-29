/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.ecrans;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ouroboros.classes.Ecran;
import ouroboros.sql.DeleteClient;
import ouroboros.sql.ReadClient;
import ouroboros.sql.UpdateClient;

/**
 *
 * @author user
 */
public class EcranClientSelection
{
    public static void ParametresClientRead(Ecran ecran, List<String> listeClient)
    {
    	JFrame clientSelection = new JFrame();
    	JPanel panelSelectionClientGeneral = new JPanel();
    	panelSelectionClientGeneral.setLayout(new BoxLayout(panelSelectionClientGeneral, BoxLayout.LINE_AXIS));
    	clientSelection.setContentPane(panelSelectionClientGeneral);
    	clientSelection.setVisible(true);
    	
        clientSelection.setTitle("Selection d'un client");
        clientSelection.setSize(485,300);
    	clientSelection.setLocation(480,180);

    	JPanel panelSelectionClientList = new JPanel();
    	panelSelectionClientList.setLayout(new BoxLayout(panelSelectionClientList, BoxLayout.PAGE_AXIS));	
        JComboBox listeDeroulanteClients = new JComboBox();
        listeDeroulanteClients.setPreferredSize(new Dimension(100, 20));

            
    	for(int i=0; i<listeClient.size(); i++)
    	{
            listeDeroulanteClients.addItem(listeClient.get(i));
              
    	}
        JButton clientRead = new JButton("Consulter la fiche client");
        JButton clientUpdate = new JButton("Mettre a  jour la fiche client");
        JButton clientDelete = new JButton("Supprimer la fiche client");
        
        panelSelectionClientList.add(listeDeroulanteClients);

        panelSelectionClientList.add(clientRead);
        panelSelectionClientList.add(clientUpdate);
        panelSelectionClientList.add(clientDelete);
        
        panelSelectionClientGeneral.add(panelSelectionClientList);
        clientRead.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		String select = (String) listeDeroulanteClients.getSelectedItem();
                //System.out.println(select);
                ReadClient readClient = new ReadClient();
                readClient.recupererClient(select);
            }
	    });
        
        clientUpdate.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
	        {
        		String select = (String) listeDeroulanteClients.getSelectedItem();
                //System.out.println(select);
                UpdateClient updateClient = new UpdateClient();
                updateClient.recupererClient(select);
	        }
	    });
        
        clientDelete.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
	        {
        		String select = (String) listeDeroulanteClients.getSelectedItem();
                System.out.println(select);
                DeleteClient deleteClient = new DeleteClient();
                deleteClient.supprimerClient(select);            	
	        }
	    });
    }        
}