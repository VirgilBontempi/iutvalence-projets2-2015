package fr.iutvalence.gpr1.java.view;

import fr.iutvalence.gpr1.java.model.Personne;

public interface IHM {
	
	public String saisieLogin();
	
	public String saisiePassword();

	public int showMenu();

	void affichageIdAdministrateur();

	void affichageIdProfesseur();

	void affichageIdEtudiant();

	public void idValide(Personne personne);

	public void idInvalide();

}