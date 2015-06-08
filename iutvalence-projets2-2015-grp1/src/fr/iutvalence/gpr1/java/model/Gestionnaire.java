package fr.iutvalence.gpr1.java.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;
import fr.iutvalence.gpr1.java.view.console.IHMConsole;

/** Classe Gestionnaire */
public class Gestionnaire {

	private IHM monIHM;

	private List<Etudiant> listEtudiants;
	private List<Professeur> listProfesseurs;
	private List<Administrateur> listAdministrateurs;

	/**
	 * Constructeur de Gestionnaire.
	 * 
	 * @param monIHM
	 * @param fichierEtudiants
	 * @param fichierProfesseurs
	 * @param fichierAdministrateurs
	 */
	public Gestionnaire(IHM monIHM, File fichierEtudiants,
			File fichierProfesseurs, File fichierAdministrateurs) {
		this.monIHM = monIHM;

		ListePersonnes fichierAdministrateur = new ListePersonnes(
				fichierAdministrateurs);
		try {
			this.listAdministrateurs = fichierAdministrateur
					.getListAdministrateurs();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try {
			this.listEtudiants = fichierEtudiant.getListEtudiants();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ListePersonnes fichierProfesseur = new ListePersonnes(
				fichierProfesseurs);
		try {
			this.listProfesseurs = fichierProfesseur.getListProfesseurs();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Identifie un Admin.
	 * 
	 * @return boolean
	 */
	public Administrateur identificationAdministrateur() {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		return this.rechercheAdministrateur(login, password);
	}

	/**
	 * Recherche un administrateur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return boolean
	 */
	public Administrateur rechercheAdministrateur(String login, String password) {
		Iterator<Administrateur> iterator = this.listAdministrateurs.iterator();
		while (iterator.hasNext()) {
			Administrateur currentAdministrator = iterator.next();
			if (currentAdministrator.getLogin().equals(login)) {

				if (currentAdministrator.getPassword().equals(password)) {
					return currentAdministrator;
				}
			}
		}
		return null;
	}

	public List<Etudiant> getListEtudiants() {
		return this.listEtudiants;
	}

	public List<Professeur> getListProfesseurs() {
		return this.listProfesseurs;
	}

	public List<Administrateur> getListAdministrateurs() {
		return this.listAdministrateurs;
	}

	/**
	 * Identfie un Professeur.
	 * 
	 * @return boolean
	 */
	public Professeur identificationProfesseur() {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		return this.rechercheProfesseur(login, password);
	}

	/**
	 * Recherche un professeur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return boolean
	 */
	private Professeur rechercheProfesseur(String login, String password) {

		Iterator<Professeur> iterator = this.listProfesseurs.iterator();
		while (iterator.hasNext()) {
			Professeur currentTeacher = iterator.next();
			if (currentTeacher.getLogin().equals(login)) {
				if (currentTeacher.getPassword().equals(password)) {
					return currentTeacher;
				}
			}
		}
		return null;
	}

	/**
	 * Identifie un étudiant.
	 */
	public Etudiant identificationEtudiant() {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		Etudiant etudiant = null;
		for (int curseur = 0; curseur < this.listEtudiants.size(); curseur++) {
			etudiant = this.listEtudiants.get(curseur);

			if (etudiant.getLogin().equals(login)
					&& etudiant.getPassword().equals(password)) {
				int index = this.listEtudiants.indexOf(etudiant);
				etudiant.setAbsence(false);
				this.listEtudiants.set(index, etudiant);
				return this.listEtudiants.get(index);
			}
		}
		return null;
	}

	/**
	 * Ajoute une absence à un étudiant.
	 * 
	 * @param fichierEtudiants
	 */
	public void AjoutAbsences(File fichierEtudiants) {
		Etudiant etudiant = null;
		LinkedList<Etudiant> listeEtudiants;

		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try {
			listeEtudiants = fichierEtudiant.getListEtudiants();

			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
				etudiant = listeEtudiants.get(curseur);

				if (etudiant.getAbsence() == true) {
					etudiant.addAbsence();
					listeEtudiants.set(curseur, etudiant);
				}

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void creationCours() {
		String libelle = this.monIHM.saisieLibelleCours();
		String typeCours = this.monIHM.saisieTypeCours();
		if(typeCours.equalsIgnoreCase("TD")){
			int grpTd = this.monIHM.saisieGrpTd();
		}
		if(typeCours.equalsIgnoreCase("TP")){
			String grpTp = this.monIHM.saisieGrpTp();
		}
		
	}

	public void debutCours() {
		int choiceCours = this.monIHM.menuCours();

		if (choiceCours == 2) {
			boolean idValide = false;
			while (!idValide) {
				this.monIHM.affichageIdEtudiant();
				Etudiant etudiant = this.identificationEtudiant();
				if (etudiant != null) {
					this.monIHM.idValide(etudiant);
					idValide = true;
					this.monIHM.elevePresent();
					this.debutCours();
				} else
					this.monIHM.idInvalide();
				this.debutCours();
			}
		}
		if (choiceCours == 1) {
			this.monIHM.affichageIdProfesseur2();
			Professeur prof = this.identificationProfesseur();
			if (prof != null) {
				this.listeDesAbsents();
				this.starter();
			}

		}

	}

	public LinkedList<Etudiant> listeDesAbsents() {
		LinkedList<Etudiant> listAbs = new LinkedList<Etudiant>();
		for (int i = 0; i < this.listEtudiants.size(); i++) {
			if (this.listEtudiants.get(i).getAbsence() == true
					&& this.listEtudiants.get(i) != null)
//					&& (this.monIHM.saisieGrpTd() == Integer.parseInt(this.listEtudiants.get(i).getGrpTd())
//					|| this.monIHM.saisieGrpTp() == this.listEtudiants.get(i).getgprTP() || this.monIHM.saisieTypeCours()=="CM"))
			{
				listAbs.add(this.listEtudiants.get(i));
				System.out.println("Voici la liste des absents");
				System.out.println(listAbs);
			}
		}
		return listAbs;
	}

	public void choixAdministrateur() {
		int choiceAdmin = this.monIHM.adminMenu();

		if (choiceAdmin == 1) {
			// TODO methode d'ajout admin
		}

		if (choiceAdmin == 2) {
			// TODO methode suppression admin
		}

		if (choiceAdmin == 3) {
			// TODO methode ajout prof
		}

		if (choiceAdmin == 4) {
			// TODO meethode suppression prof
		}
	}

	/**
	 * Le starter de l'application.
	 */
	public void starter() {
		boolean idValide = false;

		while (!idValide) {
			int choice = monIHM.showMenu();

			if (choice == 1) {
				this.monIHM.affichageIdAdministrateur();
				Administrateur admin = this.identificationAdministrateur();
				if (admin != null) {
					this.monIHM.idValide(admin);
					idValide = true;
					this.monIHM.adminMenu();
				} else {
					this.monIHM.idInvalide();
				}
			}

			if (choice == 2) {

				this.monIHM.affichageIdProfesseur();
				Professeur prof = this.identificationProfesseur();
				if (prof != null) {
					this.monIHM.idValide(prof);
					idValide = true;

					this.creationCours();

					this.debutCours();
					
					this.listeDesAbsents();

				} else {
					this.monIHM.idInvalide();
				}
			}

		}

		// if (choice == 3) {
		// this.monIHM.affichageIdEtudiant();
		// Etudiant etudiant = this.identificationEtudiant();
		// if(etudiant != null){
		// this.monIHM.idValide(etudiant);
		// idValide=true;
		// this.monIHM.elevePresent();
		// this.starter();
		// }
		// else
		// this.monIHM.idInvalide();
		// }
	}

}
