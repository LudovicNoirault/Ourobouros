package main;

public class Adresse {
	private int numero;
    private String rue;
    private String ville;
    private int code_postal;
    private String pays;
	public Adresse(int numero, String rue, String ville, int code_postal, String pays) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.code_postal = code_postal;
		this.pays = pays;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
    
}
