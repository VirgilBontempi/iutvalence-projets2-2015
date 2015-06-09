package fr.iutvalence.gpr1.java.model;

/** Classe Professeur. */
public class Professeur extends Personne {

	/**
	 * Constructeur de Professeur.
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 */
	public Professeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}

	/**
	 * Définition de la méthode toString de Professeur.
	 */
	public String toString(){
		return this.nom+", "+this.prenom+", "+this.login+", "+this.password+" /";
	}
}
