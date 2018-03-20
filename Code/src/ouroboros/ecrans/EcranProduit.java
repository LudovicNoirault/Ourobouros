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
public class EcranProduit {
    public static void ParametresEcranProduit(Ecran ecran){
        ecran.setTitle("Ouroboros");
        ecran.setSize(300,200);
        ecran.setLocation(450,165);
        JPanel produitPanel = new JPanel();
        JButton produitBtnCreate = new JButton("Ajouter un nouveau produit");	
        JButton produitBtnUpdate = new JButton("Modifier les infos d'un produit");		
        JButton produitBtnRead = new JButton("Consulter un produit");
        JButton produitBtnDelete = new JButton("Supprimer un produit");
        JLabel logo = new JLabel(new ImageIcon("logoOuroboros.png"));
        produitPanel.add(produitBtnCreate);
        produitPanel.add(produitBtnUpdate);
        produitPanel.add(produitBtnRead);
        produitPanel.add(produitBtnDelete);
        ecran.add(logo, BorderLayout.CENTER); 
        produitPanel.setBackground(Color.DARK_GRAY);
        ecran.setContentPane(produitPanel);
        ecran.setVisible(true);
    }
}
