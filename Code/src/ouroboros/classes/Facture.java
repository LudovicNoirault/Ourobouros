package ouroboros.classes;

public class Facture {
	private int id_Facture;
	private Commande id_Commande;
	private Client id_Client;
	private Double totalFacture;
	public Facture(int id_Facture, Commande id_Commande, Client id_Client, Double totalFacture) {
		super();
		this.id_Facture = id_Facture;
		this.id_Commande = id_Commande;
		this.id_Client = id_Client;
		this.totalFacture = totalFacture;
	}
	public int getId_Facture() {
		return id_Facture;
	}
	public void setId_Facture(int id_Facture) {
		this.id_Facture = id_Facture;
	}
	public Commande getId_Commande() {
		return id_Commande;
	}
	public void setId_Commande(Commande id_Commande) {
		this.id_Commande = id_Commande;
	}
	public Client getId_Client() {
		return id_Client;
	}
	public void setId_Client(Client id_Client) {
		this.id_Client = id_Client;
	}
	public Double getTotalFacture() {
		return totalFacture;
	}
	public void setTotalFacture(Double totalFacture) {
		this.totalFacture = totalFacture;
	}
	
	
}
