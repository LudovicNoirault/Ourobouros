package GestionJava5;
public class Devis {
	
	private int id_devis, quantite_devis, remises_devis, retard_devis, delaisPaiement_devis;
	private String libelle_devis;
	private double valeur_devis;
	
	public Devis(int id_devis, int quantite_devis, int remises_devis, int retard_devis, int delaisPaiement_devis,
			String libelle_devis, double valeur_devis) {
		//super();
		
		this.id_devis = id_devis;
		this.quantite_devis = quantite_devis;
		this.remises_devis = remises_devis;
		this.retard_devis = retard_devis;
		this.delaisPaiement_devis = delaisPaiement_devis;
		this.libelle_devis = libelle_devis;
		this.valeur_devis = valeur_devis;
	}

	public int getId_devis() {
		return id_devis;
	}

	public void setId_devis(int id_devis) {
		this.id_devis = id_devis;
	}

	public int getQuantite_devis() {
		return quantite_devis;
	}

	public void setQuantite_devis(int quantite_devis) {
		this.quantite_devis = quantite_devis;
	}

	public int getRemises_devis() {
		return remises_devis;
	}

	public void setRemises_devis(int remises_devis) {
		this.remises_devis = remises_devis;
	}

	public int getRetard_devis() {
		return retard_devis;
	}

	public void setRetard_devis(int retard_devis) {
		this.retard_devis = retard_devis;
	}

	public int getDelaisPaiement_devis() {
		return delaisPaiement_devis;
	}

	public void setDelaisPaiement_devis(int delaisPaiement_devis) {
		this.delaisPaiement_devis = delaisPaiement_devis;
	}

	public String getLibelle_devis() {
		return libelle_devis;
	}

	public void setLibelle_devis(String libelle_devis) {
		this.libelle_devis = libelle_devis;
	}

	public double getValeur_devis() {
		return valeur_devis;
	}

	public void setValeur_devis(double valeur_devis) {
		this.valeur_devis = valeur_devis;
	}
}
