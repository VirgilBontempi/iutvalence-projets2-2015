package fr.iutvalence.gpr1.java.model;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;

	/**
	 * Constructeur Personne.
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 */
	public Personne(String nom, String prenom, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = login;
	}

	/**
	 * Getter de Nom.
	 * 
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Getter de Prenom.
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Getter de Login
	 * 
	 * @return login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Getter de Password.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	
	public String toString(Personne pers){
		return pers.getNom()+","+pers.getPrenom()+","+pers.getLogin()+","+pers.getPassword()+"/";
	}
}
