package fr.iutvalence.gpr1.java.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;

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

		ListePersonnes fichierAdministrateur = new ListePersonnes(
				fichierAdministrateurs);
		try {
			this.listAdministrateurs = fichierAdministrateur
					.getListAdministrateurs();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Identifie un Admin.
	 * 
	 * @return boolean
	 */
	public boolean identificationAdministrateur() {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		if (this.rechercheProfesseur(login, password))
			return true;
		return false;
	}

	/**
	 * Recherche un administrateur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return boolean
	 */
	public boolean rechercheAdministrateur(String login, String password) {
		Iterator<Administrateur> iterator = this.listAdministrateurs.iterator();
		while (iterator.hasNext()) {
			Administrateur currentAdministrator = iterator.next();
			if (currentAdministrator.getLogin().equals(login)) {
				if (currentAdministrator.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Identfie un Professeur.
	 * 
	 * @return boolean
	 */
	public boolean identificationProfesseur() {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		if (this.rechercheProfesseur(login, password))
			return true;
		return false;
	}

	/**
	 * Recherche un professeur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return boolean
	 */
	private boolean rechercheProfesseur(String login, String password) {

		Iterator<Professeur> iterator = this.listProfesseurs.iterator();
		while (iterator.hasNext()) {
			Professeur currentTeacher = iterator.next();
			if (currentTeacher.getLogin().equals(login)) {
				if (currentTeacher.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Identifie un étudiant.
	 * 
	 * @param fichierEtudiants
	 */
	public void identificationEtudiant(File fichierEtudiants) {
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		Etudiant etudiant = null;
		LinkedList<Etudiant> listeEtudiants;

		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try {

			listeEtudiants = fichierEtudiant.getListEtudiants();

			for (int curseur = 1; curseur < listeEtudiants.size(); curseur++) {
				etudiant = listeEtudiants.get(curseur);

				if (etudiant.getLogin().equals(login)
						&& etudiant.getPassword().equals(password)) {
					int index = this.listEtudiants.indexOf(etudiant);
					etudiant.setAbsence(false);
					this.listEtudiants.set(index, etudiant);
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

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

}