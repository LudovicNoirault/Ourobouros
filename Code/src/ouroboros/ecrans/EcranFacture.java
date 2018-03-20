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
public class EcranFacture {
    public static void ParametresEcranFacture(Ecran ecran){
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel facturePanel = new JPanel();
        JButton factureBtnCreate = new JButton("Ajouter une nouvelle facture");	
        JButton factureBtnUpdate = new JButton("Modifier les infos d'une facture");		
        JButton factureBtnRead = new JButton("Consulter une facture");
        JButton factureBtnDelete = new JButton("Supprimer une facture");
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        facturePanel.add(factureBtnCreate);
        facturePanel.add(factureBtnUpdate);
        facturePanel.add(factureBtnRead);
        facturePanel.add(factureBtnDelete);
        ecran.add(logo, BorderLayout.CENTER); 
        facturePanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(facturePanel);
        ecran.setVisible(true);
    }
}
