package GestionJava5;
public class Facture {
	
	private int id_facture, quantite_facture, remises_facture, delaiPaiement_facture, retard_facture,acompte_facture, valeur_facture, reglement_facture;
	private String libelle_facture;
	
	public Facture(int id_facture, int quantite_facture, int remises_facture, int delaiPaiement_facture,
			int retard_facture, int acompte_facture, String libelle_facture, int valeur_facture,
			int reglement_facture) {
		//super();
		this.id_facture = id_facture;
		this.quantite_facture = quantite_facture;
		this.remises_facture = remises_facture;
		this.delaiPaiement_facture = delaiPaiement_facture;
		this.retard_facture = retard_facture;
		this.acompte_facture = acompte_facture;
		/*this.id_devis = id_devis;
		this.id_client = id_client;*/
		this.libelle_facture = libelle_facture;
		this.valeur_facture = valeur_facture;
		this.reglement_facture = reglement_facture;
		
	}
	public int getId_facture() {
		return id_facture;
	}
	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}
	public int getQuantite_facture() {
		return quantite_facture;
	}
	public void setQuantite_facture(int quantite_facture) {
		this.quantite_facture = quantite_facture;
	}
	public int getRemises_facture() {
		return remises_facture;
	}
	public void setRemises_facture(int remises_facture) {
		this.remises_facture = remises_facture;
	}
	public int getDelaiPaiement_facture() {
		return delaiPaiement_facture;
	}
	public void setDelaiPaiement_facture(int delaiPaiement_facture) {
		this.delaiPaiement_facture = delaiPaiement_facture;
	}
	
	public int getRetard_facture() {
		return retard_facture;
	}
	public void setRetard_facture(int retard_facture) {
		this.retard_facture = retard_facture;
	}
	public int getAcompte_facture() {
		return acompte_facture;
	}
	public void setAcompte_facture(int acompte_facture) {
		this.acompte_facture = acompte_facture;
	}/*
	public int getId_devis() {
		return id_devis;
	}
	public void setId_devis(int id_devis) {
		this.id_devis = id_devis;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}*/
	public String getLibelle_facture() {
		return libelle_facture;
	}
	public void setLibelle_facture(String libelle_facture) {
		this.libelle_facture = libelle_facture;
	}
	public double getValeur_facture() {
		return valeur_facture;
	}
	public void setValeur_facture(int valeur_facture) {
		this.valeur_facture = valeur_facture;
	}
	public int getReglement_facture() {
		return reglement_facture;
	}
	public void setReglement_facture(int reglement_facture) {
		this.reglement_facture = reglement_facture;
	}
}
