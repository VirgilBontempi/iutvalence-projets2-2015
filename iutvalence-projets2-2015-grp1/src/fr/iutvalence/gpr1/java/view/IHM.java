package fr.iutvalence.gpr1.java.view;

import java.util.LinkedList;

import fr.iutvalence.gpr1.java.model.Administrateur;
import fr.iutvalence.gpr1.java.model.Date;
import fr.iutvalence.gpr1.java.model.Etudiant;
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

	public void elevePresent();

	public String saisieTypeCours();

	public String saisieLibelleCours();

	public String saisieGrpTp();
	
	public String saisieGrpTd();

	public int menuCours();

	public void affichageIdProfesseur2();

	public int adminMenu();

	public void addAdmin();
	
	public void removeAdmin();

	public void choixAdministrateur();

	public void afficherListe();

	public void affichageListeAbsence(LinkedList<Etudiant> listAbs);


}
