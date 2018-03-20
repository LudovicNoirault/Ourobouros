/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouroboros.ecrans;

import java.awt.BorderLayout;
import java.awt.Color;
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
        JButton commandeBtnUpdate = new JButton("Modifier les infos d'une commande");		
        JButton commandeBtnRead = new JButton("Consulter une commande");
        JButton commandeBtnDelete = new JButton("Supprimer une commande");
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        commandePanel.add(commandeBtnCreate);
        commandePanel.add(commandeBtnUpdate);
        commandePanel.add(commandeBtnRead);
        commandePanel.add(commandeBtnDelete);
        ecran.add(logo, BorderLayout.CENTER); 
        commandePanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(commandePanel);
        ecran.setVisible(true);
    }
}
