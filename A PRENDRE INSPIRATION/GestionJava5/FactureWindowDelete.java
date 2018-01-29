package GestionJava5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;

public class FactureWindowDelete extends JFrame {
	private JPanel contentPane;
	private JTextField id_facture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactureWindowDelete frame = new FactureWindowDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FactureWindowDelete() {
		ConnexionFacture.getFactureBDD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_principal = new JPanel();
		contentPane.add(panel_principal, BorderLayout.CENTER);
		
		JPanel panel_haut = new JPanel();
		panel_principal.add(panel_haut);
		panel_haut.setLayout(new BoxLayout(panel_haut, BoxLayout.X_AXIS));
		
		Label LblListFacture = new Label("Facture à supprimer");
		panel_haut.add(LblListFacture);
		
		JButton btnSupprimerLaFacture = new JButton("Supprimer la facture sélectionnée");
		btnSupprimerLaFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnexionFacture.deleteFactureBDD(Integer.parseInt(id_facture.getText()));
			}
		});
		
		id_facture = new JTextField();
		panel_haut.add(id_facture);
		id_facture.setColumns(10);
		panel_haut.add(btnSupprimerLaFacture);
		JButton btnNewButton = new JButton("Menu principal");
		panel_haut.add(btnNewButton);
	}

}
