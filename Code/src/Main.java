package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fenetre = new JFrame();
		
		fenetre.setTitle("Ouroboros: you're quick and easy solution to create invoices .... Yeah, kinda like freshbooks....");
		
		fenetre.setSize(800,600);
		fenetre.setLocation(300,50);
		JPanel panel = new JPanel();
		JButton button1 = new JButton("Click here !");	
		JButton button2= new JButton("Or here");		
		JButton button3= new JButton("Or why not here ");		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		panel.setBackground(Color.LIGHT_GRAY);
		
		fenetre.setContentPane(panel);
		fenetre.setVisible(true);
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

}
