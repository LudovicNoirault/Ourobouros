package main;

public class AdresseLivraison extends Adresse{
	private int id_Adresse_Livraison;
	public AdresseLivraison(int numero, String rue, String ville, int code_postal, String pays,
			int id_Adresse_Livraison) {
		super(numero, rue, ville, code_postal, pays);
		this.id_Adresse_Livraison = id_Adresse_Livraison;
	}
	public int getId_Adresse_Livraison() {
		return id_Adresse_Livraison;
	}
	public void setId_Adresse_Livraison(int id_Adresse_Livraison) {
		this.id_Adresse_Livraison = id_Adresse_Livraison;
	}  
}
