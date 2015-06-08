package fr.iutvalence.gpr1.java.view;

import java.util.LinkedList;
import java.util.List;

import fr.iutvalence.gpr1.java.model.Administrateur;
import fr.iutvalence.gpr1.java.model.Etudiant;
import fr.iutvalence.gpr1.java.model.Personne;
import fr.iutvalence.gpr1.java.model.Professeur;

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

	public Administrateur inputAdmin();
	
	public String inputAdmin2();
	
	public void displayNewAdminAdded(Administrateur nouvelAdmin);
	
	public void removeAdmin();
	
	public void displayAdminRemoved(Administrateur administrateur);

	public void afficherListeAdmin(List<Administrateur> listAdmin);

	public void affichageListeAbsence(LinkedList<Etudiant> listAbs);

	public Professeur inputProf();
	
	public String inputProf2();

	public void displayNewProfAdded(Professeur professeur);
	
	public void removeProf();

	public void displayProfRemoved(Professeur professeur);

	public void afficherListeProf(List<Professeur> listProf);

	public void inputAdmin2Invalide();

	public void inputProf2Invalide();

	

	

	



}
