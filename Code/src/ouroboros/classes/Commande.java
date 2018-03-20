package ouroboros.classes;

public class Commande {
	private int id_Commande;
	private Client id_Client;
	private Produit id_Produit;
	private int quantite_Produit_Commande;
	public Commande(int id_Commande, Client id_Client, Produit id_Produit, int quantite_Produit_Commande) {
		super();
		this.id_Commande = id_Commande;
		this.id_Client = id_Client;
		this.id_Produit = id_Produit;
		this.quantite_Produit_Commande = quantite_Produit_Commande;
	}
	public int getId_Commande() {
		return id_Commande;
	}
	public void setId_Commande(int id_Commande) {
		this.id_Commande = id_Commande;
	}
	public Client getId_Client() {
		return id_Client;
	}
	public void setId_Client(Client id_Client) {
		this.id_Client = id_Client;
	}
	public Produit getId_Produit() {
		return id_Produit;
	}
	public void setId_Produit(Produit id_Produit) {
		this.id_Produit = id_Produit;
	}
	public int getQuantite_Produit_Commande() {
		return quantite_Produit_Commande;
	}
	public void setQuantite_Produit_Commande(int quantite_Produit_Commande) {
		this.quantite_Produit_Commande = quantite_Produit_Commande;
	}
	
}
