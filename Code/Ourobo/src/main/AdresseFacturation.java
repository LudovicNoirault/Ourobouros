package main;

public class AdresseFacturation extends Adresse{
	private int id_Adresse_Facturation;
	public AdresseFacturation(int numero, String rue, String ville, int code_postal, String pays,
			int id_Adresse_Facturation) {
		super(numero, rue, ville, code_postal, pays);
		this.id_Adresse_Facturation = id_Adresse_Facturation;
	}

	public int getId_Adresse_Facturation() {
		return id_Adresse_Facturation;
	}

	public void setId_Adresse_Facturation(int id_Adresse_Facturation) {
		this.id_Adresse_Facturation = id_Adresse_Facturation;
	}
}
