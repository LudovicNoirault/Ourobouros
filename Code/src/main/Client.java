package main;

public class Client {
	private int id_Client;
	private String nom_Client;
	private String nom_DirigeantClient;
	private AdresseFacturation id_adresseFacture;
    private AdresseLivraison id_adresseLivraison;
	public Client(int id_Client, String nom_Client, String nom_DirigeantClient, AdresseFacturation id_adresseFacture,
			AdresseLivraison id_adresseLivraison) {
		super();
		this.id_Client = id_Client;
		this.nom_Client = nom_Client;
		this.nom_DirigeantClient = nom_DirigeantClient;
		this.id_adresseFacture = id_adresseFacture;
		this.id_adresseLivraison = id_adresseLivraison;
	}
	public int getId_Client() {
		return id_Client;
	}
	public void setId_Client(int id_Client) {
		this.id_Client = id_Client;
	}
	public String getNom_Client() {
		return nom_Client;
	}
	public void setNom_Client(String nom_Client) {
		this.nom_Client = nom_Client;
	}
	public String getNom_DirigeantClient() {
		return nom_DirigeantClient;
	}
	public void setNom_DirigeantClient(String nom_DirigeantClient) {
		this.nom_DirigeantClient = nom_DirigeantClient;
	}
	public AdresseFacturation getId_adresseFacture() {
		return id_adresseFacture;
	}
	public void setId_adresseFacture(AdresseFacturation id_adresseFacture) {
		this.id_adresseFacture = id_adresseFacture;
	}
	public AdresseLivraison getId_adresseLivraison() {
		return id_adresseLivraison;
	}
	public void setId_adresseLivraison(AdresseLivraison id_adresseLivraison) {
		this.id_adresseLivraison = id_adresseLivraison;
	}
    
}
