package ouroboros.classes;

public class Produit {
	private int id_Produit;
	private String nom_Produit;
    private int prix_unitaire_Produit;
	public Produit(int id_Produit, String nom_Produit, int prix_unitaire_Produit) {
		super();
		this.id_Produit = id_Produit;
		this.nom_Produit = nom_Produit;
		this.prix_unitaire_Produit = prix_unitaire_Produit;
	}
	public int getId_Produit() {
		return id_Produit;
	}
	public void setId_Produit(int id_Produit) {
		this.id_Produit = id_Produit;
	}
	public String getNom_Produit() {
		return nom_Produit;
	}
	public void setNom_Produit(String nom_Produit) {
		this.nom_Produit = nom_Produit;
	}
	public int getPrix_unitaire_Produit() {
		return prix_unitaire_Produit;
	}
	public void setPrix_unitaire_Produit(int prix_unitaire_Produit) {
		this.prix_unitaire_Produit = prix_unitaire_Produit;
	}
	
}
