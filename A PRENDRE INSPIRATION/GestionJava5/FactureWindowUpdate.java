package GestionJava5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FactureWindowUpdate extends JFrame {
	
	private JPanel contentPane;
	private JTextField id_facture;
	private static JTextField quantite_facture;
	private static JTextField libelle_facture;
	private static JTextField valeur_facture;
	private static JTextField remises_facture;
	private static JTextField delaiPaiement_facture;
	private static JTextField retard_facture;
	private static JTextField acompte_facture;
	private final ButtonGroup reglement_facture = new ButtonGroup();
	private JButton btnModifier;
	private static Boolean retourReglement;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactureWindowUpdate frame = new FactureWindowUpdate();
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
	public FactureWindowUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_haut = new JPanel();
		contentPane.add(panel_haut, BorderLayout.NORTH);
		
		JLabel lblGestionDesFactures = new JLabel("Modification d'une facture");
		panel_haut.add(lblGestionDesFactures);
		
		JPanel panel_bas = new JPanel();
		contentPane.add(panel_bas, BorderLayout.SOUTH);
		
		btnModifier = new JButton("Modifier la facture s\u00E9lectionn\u00E9e");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnexionFacture.updateFactureBDD(Integer.parseInt(id_facture.getText()),Integer.parseInt(quantite_facture.getText()), Integer.parseInt(remises_facture.getText()), Integer.parseInt(delaiPaiement_facture.getText()), Integer.parseInt(retard_facture.getText()), Integer.parseInt(acompte_facture.getText()), libelle_facture.getText(), Integer.parseInt(valeur_facture.getText()), retourReglement);
			}
		});
		panel_bas.add(btnModifier);
		
		JButton btnMenuPrincipal = new JButton("Menu principal");
		panel_bas.add(btnMenuPrincipal);
		
		JPanel panel_centre = new JPanel();
		contentPane.add(panel_centre, BorderLayout.CENTER);
		panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS));
		
		JPanel panel_gauche = new JPanel();
		panel_centre.add(panel_gauche);
		panel_gauche.setLayout(new BoxLayout(panel_gauche, BoxLayout.Y_AXIS));
		
		JPanel panel_ligne1 = new JPanel();
		panel_gauche.add(panel_ligne1);
		
		JLabel lblIdFac = new JLabel("Id de la facture :");
		panel_ligne1.add(lblIdFac);
		
		id_facture = new JTextField();
		panel_ligne1.add(id_facture);
		id_facture.setColumns(10);
		
		JPanel panel_ligne2 = new JPanel();
		panel_gauche.add(panel_ligne2);
		
		JLabel lblQuantFac = new JLabel("Quantité d'articles : ");
		panel_ligne2.add(lblQuantFac);
		
		quantite_facture = new JTextField();
		panel_ligne2.add(quantite_facture);
		quantite_facture.setColumns(10);
		
		JPanel panel_ligne3 = new JPanel();
		panel_gauche.add(panel_ligne3);
		
		JLabel lblComFac = new JLabel("Commentaires :");
		panel_ligne3.add(lblComFac);
		
		libelle_facture = new JTextField();
		panel_ligne3.add(libelle_facture);
		libelle_facture.setColumns(10);
		
		JPanel panel_ligne4 = new JPanel();
		panel_gauche.add(panel_ligne4);
		
		JLabel lblMontFac = new JLabel("Montant de la facture :");
		panel_ligne4.add(lblMontFac);
		
		valeur_facture = new JTextField();
		panel_ligne4.add(valeur_facture);
		valeur_facture.setColumns(10);
		
		JPanel panel_droite = new JPanel();
		panel_centre.add(panel_droite);
		panel_droite.setLayout(new BoxLayout(panel_droite, BoxLayout.Y_AXIS));
		
		JPanel panel_ligne5 = new JPanel();
		panel_droite.add(panel_ligne5);
		
		JLabel lblRemFac = new JLabel("Remises : ");
		panel_ligne5.add(lblRemFac);
		
		remises_facture = new JTextField();
		panel_ligne5.add(remises_facture);
		remises_facture.setColumns(10);
		
		JPanel panel_ligne6 = new JPanel();
		panel_droite.add(panel_ligne6);
		
		JLabel lblDelFac = new JLabel("D\u00E9lais de paiement :");
		panel_ligne6.add(lblDelFac);
		
		delaiPaiement_facture = new JTextField();
		panel_ligne6.add(delaiPaiement_facture);
		delaiPaiement_facture.setColumns(10);
		
		JPanel panel_ligne7 = new JPanel();
		panel_droite.add(panel_ligne7);
		
		JLabel lblRetFac = new JLabel("Retards de paiement :");
		panel_ligne7.add(lblRetFac);
		
		retard_facture = new JTextField();
		panel_ligne7.add(retard_facture);
		retard_facture.setColumns(10);
		
		JPanel panel_ligne8 = new JPanel();
		panel_droite.add(panel_ligne8);
		
		JLabel lblAcoFac = new JLabel("Acomptes :");
		panel_ligne8.add(lblAcoFac);
		
		acompte_facture = new JTextField();
		panel_ligne8.add(acompte_facture);
		acompte_facture.setColumns(10);
		
		JPanel panel_ligne9 = new JPanel();
		panel_droite.add(panel_ligne9);
		
		JLabel lblRglFac = new JLabel("R\u00E9gl\u00E8ment de la facture :");
		panel_ligne9.add(lblRglFac);
		
		JRadioButton reglement_factureT = new JRadioButton("Réglé");
		reglement_facture.add(reglement_factureT);
		panel_ligne9.add(reglement_factureT);
		
		JRadioButton reglement_factureF = new JRadioButton("Non réglé");
		ButtonModel bm = reglement_factureT.getModel();
		ButtonModel bm1 = reglement_factureF.getModel();
		reglement_facture.add(reglement_factureF);
		panel_ligne9.add(reglement_factureF);
		retourReglement = reglement_facture.isSelected(bm);
	}

}
