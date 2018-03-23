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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ouroboros.classes.Ecran;
import ouroboros.sql.ConnectToBDD;

/**
 *
 * @author user
 */
public class EcranClientRead
{
    public static void ParametresClientRead(Ecran ecran, List<String> listeClient)
    {
    	JFrame clientSelection = new JFrame();
    	JPanel panelSelectionClientGeneral = new JPanel();
    	panelSelectionClientGeneral.setLayout(new BoxLayout(panelSelectionClientGeneral, BoxLayout.LINE_AXIS));
    	clientSelection.setContentPane(panelSelectionClientGeneral);
    	clientSelection.setVisible(true);
    	
        clientSelection.setTitle("Sélection d'un client");
        clientSelection.setSize(285,100);
    	clientSelection.setLocation(480,180);

    	JPanel panelSelectionClientList = new JPanel();
    	panelSelectionClientList.setLayout(new BoxLayout(panelSelectionClientList, BoxLayout.PAGE_AXIS));	
            JComboBox listeDeroulanteClients = new JComboBox();
            listeDeroulanteClients.setPreferredSize(new Dimension(100, 20));

    	for(int i=0; i<listeClient.size(); i++)
    	{
    		listeDeroulanteClients.addItem(listeClient.get(i));
    	}
        
    	JButton validerSelection = new JButton("Valider");
        panelSelectionClientList.add(listeDeroulanteClients);
        panelSelectionClientList.add(validerSelection);
        panelSelectionClientGeneral.add(panelSelectionClientList);
    }        
}