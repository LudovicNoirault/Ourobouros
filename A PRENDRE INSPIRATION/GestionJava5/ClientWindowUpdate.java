package GestionJava5;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class ClientWindowUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField email_client;
	private JTextField cp_client;
	private JTextField numTVA_client;
	private JTextField siret_client;
	private JTextField commentaires_client;
	private JTextField nom_client;
	private JTextField prenom_client;
	private JTextField societe_client;
	private JComboBox id_client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public ClientWindowUpdate() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGestionDesClients = new JLabel("Gestion des clients");
		panel.add(lblGestionDesClients);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("id_client");
		panel_2.add(lblNewLabel);
	
		ConnexionClient.displayClientId(ConnexionClient.id_client);
		id_client = new JComboBox();
		id_client.setModel(new DefaultComboBoxModel(new Integer[]{ConnexionClient.id_client}));
		panel_2.add(id_client);
		
		JLabel lblEmailclient = new JLabel("email_client");
		panel_2.add(lblEmailclient);
		
		email_client = new JTextField();
		panel_2.add(email_client);
		email_client.setColumns(10);
		email_client.setText(Main.email_client);
		
		JLabel lblCpclient = new JLabel("cp_client");
		panel_2.add(lblCpclient);
		
		cp_client = new JTextField();
		panel_2.add(cp_client);
		cp_client.setColumns(10);
		cp_client.setText(Integer.toString(Main.cp_client));
		
		JLabel lblNumtvaclient = new JLabel("numTVA_client");
		panel_2.add(lblNumtvaclient);
		
		numTVA_client = new JTextField();
		panel_2.add(numTVA_client);
		numTVA_client.setColumns(10);
		numTVA_client.setText(Integer.toString(Main.numTVA_client));
		
		JLabel lblSiretclient = new JLabel("siret_client");
		panel_2.add(lblSiretclient);
		
		siret_client = new JTextField();
		panel_2.add(siret_client);
		siret_client.setColumns(10);
		siret_client.setText(Integer.toString(Main.siret_client));
		
		JLabel lblCommentairesclient = new JLabel("commentaires_client");
		panel_2.add(lblCommentairesclient);
		
		commentaires_client = new JTextField();
		panel_2.add(commentaires_client);
		commentaires_client.setColumns(10);
		commentaires_client.setText(Main.commentaires_client);
		
		JLabel lblNomclient = new JLabel("nom_client");
		panel_2.add(lblNomclient);
		
		nom_client = new JTextField();
		panel_2.add(nom_client);
		nom_client.setColumns(10);
		nom_client.setText(Main.nom_client);
		
		JLabel lblPrenomclient = new JLabel("prenom_client");
		panel_2.add(lblPrenomclient);
		
		prenom_client = new JTextField();
		panel_2.add(prenom_client);
		prenom_client.setColumns(10);
		prenom_client.setText(Main.prenom_client);
		
		JLabel lblSocieteclient = new JLabel("societe_client");
		panel_2.add(lblSocieteclient);
		
		societe_client = new JTextField();
		panel_2.add(societe_client);
		societe_client.setColumns(10);
		societe_client.setText(Main.societe_client);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnexionClient.updateClientDB(id_client.getSelectedIndex(), Integer.parseInt(cp_client.getText()), Integer.parseInt(numTVA_client.getText()), Integer.parseInt(siret_client.getText()), email_client.getText(), commentaires_client.getText(), nom_client.getText(), prenom_client.getText(), societe_client.getText());
			}
		});
		panel_5.add(btnValider);
		
		JButton btnRetour = new JButton("Retour");
		panel_5.add(btnRetour);
	}
}
