package fr.iutvalence.gpr1.java.model;

/** Classe Administrateur. */
public class Administrateur extends Personne {

	/**
	 * Construceur de Administrateur.
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 */
	public Administrateur(String nom, String prenom, String login,
			String password) {
		super(nom, prenom, login, password);
	}

	public String toString(Administrateur admin){
		return admin.getNom()+", "+admin.getPrenom()+", "+admin.getLogin()+", "+admin.getPassword()+" /";
	}
}
