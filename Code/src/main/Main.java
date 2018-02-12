package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		
		fenetre.setTitle("Ouroboros");
		
		fenetre.setSize(800,600);
		fenetre.setLocation(300,50);
		JPanel panel = new JPanel();
		JButton button1 = new JButton("Enregistrement de Client");	
		JButton button2= new JButton("Modification de client");		
		JButton button3= new JButton("Suppression de Client");		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		panel.setBackground(Color.LIGHT_GRAY);
		
		fenetre.setContentPane(panel);
		fenetre.setVisible(true);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lancerCommandeWindowEssai();
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lancerModifClient();
			}
		});
		
	}
	public void paintComponent(Graphics Text)
	{
	
		Font font = new Font("Courier", Font.ITALIC,15);
		Text.setFont(font);
		Text.setColor(Color.white);
		
		Text.drawString("You have a new client, good job ! Register it now ...",10,20);
		Text.drawString("You sold something, let's create an invoice you'll send your customer",10,20);
		Text.drawString("You did all thos invoices, isn't that great ? Have you collected the cash from all of it ?",10,20);
	}
	public static void lancerCommandeWindowEssai(){
		JFrame fenetre2 = new JFrame();
		JPanel panel2 = new JPanel();
		fenetre2.setContentPane(panel2);
		fenetre2.setVisible(true);
		fenetre2.setTitle("Création d'un nouveau client ");
		fenetre2.setSize(400,400);
		fenetre2.setLocation(310,120);
		JLabel titre = new JLabel("Veuillez saisir les informations.");
		JLabel labelnomClient  = new JLabel("Nom du client : ");
		JTextField nomClient = new JTextField();
		nomClient.setColumns(10);
		
		panel2.add(titre);
		panel2.add(labelnomClient);
		panel2.add(nomClient);
		
	}
	public static void lancerModifClient(){
		JFrame fenetreModifClient = new JFrame();
		JPanel panelModifClient = new JPanel();
		fenetreModifClient.setContentPane(panelModifClient);
		fenetreModifClient.setVisible(true);
		fenetreModifClient.setTitle("Modification d'un client existant: ");
		fenetreModifClient.setSize(400,400);
		fenetreModifClient.setLocation(310,120);
		JLabel modifClientTitre = new JLabel("Veuillez saisir les informations.");
		JLabel labelModifNomClient  = new JLabel("Client a modifier : ");
		List listeNomClient = new List();
		listeNomClient.add("Test");
		
		panelModifClient.add(modifClientTitre);
		panelModifClient.add(labelModifNomClient);
		panelModifClient.add(listeNomClient);
		
	}
}
