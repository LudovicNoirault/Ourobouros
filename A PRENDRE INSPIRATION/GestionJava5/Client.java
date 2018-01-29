package GestionJava5;
public class Client {
	
	private int id_client, cp_client, numTVA_client, siret_client;
	private String email_client, commentaires_client, nom_client, prenom_client, societe_client;
	
	public Client(int id_client, int cp_client, int numTVA_client, int siret_client, String email_client,
			String commentaires_client, String nom_client, String prenom_client, String societe_client) {
		//super();
		this.id_client = id_client;
		this.cp_client = cp_client;
		this.numTVA_client = numTVA_client;
		this.siret_client = siret_client;
		this.email_client = email_client;
		this.commentaires_client = commentaires_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.societe_client = societe_client;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getCp_client() {
		return cp_client;
	}

	public void setCp_client(int cp_client) {
		this.cp_client = cp_client;
	}

	public int getNumTVA_client() {
		return numTVA_client;
	}

	public void setNumTVA_client(int numTVA_client) {
		this.numTVA_client = numTVA_client;
	}

	public int getSiret_client() {
		return siret_client;
	}

	public void setSiret_client(int siret_client) {
		this.siret_client = siret_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public String getCommentaires_client() {
		return commentaires_client;
	}

	public void setCommentaires_client(String commentaires_client) {
		this.commentaires_client = commentaires_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getSociete_client() {
		return societe_client;
	}

	public void setSociete_client(String societe_client) {
		this.societe_client = societe_client;
	}
}
