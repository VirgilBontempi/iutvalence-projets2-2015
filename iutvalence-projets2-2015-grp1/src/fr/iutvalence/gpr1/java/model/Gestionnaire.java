package fr.iutvalence.gpr1.java.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.iutvalence.gpr1.java.view.IHM;


/** Classe Gestionnaire. */
public class Gestionnaire {

	private IHM monIHM;

	private ListePersonnes fileManagerAdmin;
	private ListePersonnes fileManagerEtudiant;
	private ListePersonnes fileManagerProf;
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
		this.fileManagerAdmin = new ListePersonnes(fichierAdministrateurs);
		this.fileManagerEtudiant = new ListePersonnes(fichierEtudiants);
		this.fileManagerProf = new ListePersonnes(fichierProfesseurs);
		try {
			this.listAdministrateurs=this.fileManagerAdmin.getListAdministrateurs();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			this.listEtudiants=this.fileManagerEtudiant.getListEtudiants();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.listProfesseurs=this.fileManagerProf.getListProfesseurs();
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
		if (login != null) {
			String password = this.monIHM.saisiePassword();
			if (password !=null){
				return this.rechercheAdministrateur(login, password);
			}
		}
		return null;
		
	}

	/**
	 * Recherche un administrateur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return currentAdministrateur
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

	
	/**
	 * Obtnenir la liste d'étudiants.
	 * 
	 * @return listEtudiants
	 */
	public List<Etudiant> getListEtudiants() {
		return this.listEtudiants;
	}

	/**
	 * Obtnenir liste d'administrateurs.
	 * 
	 * @return listAdministrateurs
	 */
	public List<Professeur> getListProfesseurs() {
		return this.listProfesseurs;
	}

	
	/**
	 * Obtnenir liste de professeurs.
	 * 
	 * @return listProfesseurs
	 */
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
		if (login != null) {
			String password = this.monIHM.saisiePassword();
			if (password != null){
				return this.rechercheProfesseur(login, password);
			}
		}
		return null;
	}

	/**
	 * Recherche un professeur dans la liste.
	 * 
	 * @param login
	 * @param password
	 * @return currentTacher
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

	
	/**
	 * Créé un cours.
	 * 
	 * @return libelle
	 */
	public String creationCours() {
		String libelle = this.monIHM.saisieLibelleCours();
		if(libelle != null){
			String typeCours = this.monIHM.saisieTypeCours();
			if (typeCours != null) {
				if (typeCours.equalsIgnoreCase("TD")) {
					return this.monIHM.saisieGrpTd();
				}
				if (typeCours.equalsIgnoreCase("TP")) {
					return this.monIHM.saisieGrpTp();
				}
			}
		}
		return "cm";
	}

	
	/**
	 * Débute un cours avec le groupe d'étudiants choisi.
	 * 
	 * @param grp
	 */
	public void debutCours(String grp) {
		if(grp != null){
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
					} else
						this.monIHM.idInvalide();
					this.debutCours(grp);
				}
			}
			if (choiceCours == 1) {
				this.monIHM.affichageIdProfesseur2();
				Professeur prof = this.identificationProfesseur();
				if (prof != null) {
					this.listeDesAbsents(grp);
				} else
					this.monIHM.idInvalide();
			}
		}
	}

	
	/**
	 * Créé la liste des absents suivant le groupe choisi.
	 * 
	 * @param grp
	 */
	public void listeDesAbsents(String grp) {
		LinkedList<Etudiant> listAbs = new LinkedList<Etudiant>();
		for (int i = 0; i < this.listEtudiants.size(); i++) {
			Etudiant currentEtudiant = this.listEtudiants.get(i);
			if (grp.equals("cm")) {
				if (currentEtudiant.getAbsence()) {
					listAbs.add(currentEtudiant);
				}
			} else {
				try {
					int td = Integer.parseInt(grp);
					if (currentEtudiant.getGrpTd() == td
							&& currentEtudiant.getAbsence()) {
						listAbs.add(currentEtudiant);
					}
				} catch (Exception e) {
					if (currentEtudiant.getgprTP().equalsIgnoreCase(grp)
							&& currentEtudiant.getAbsence()) {
						listAbs.add(currentEtudiant);
					}
				}
				
			}
		}
		this.monIHM.affichageListeAbsence(listAbs);
		this.resetAbsence();
	}

	
	/**
	 * Repasse les absence à true entre chaque cours d'une même session.
	 */
	private void resetAbsence() {
		for (Etudiant currentStudent : this.listEtudiants) {
			currentStudent.setAbsence(true);
		}

	}

	
	/**
	 * Choix du menu de l'administrateurs.
	 */
	public void choixAdministrateur() {
		int choiceAdmin = this.monIHM.adminMenu();

		if (choiceAdmin == 1) {
			this.addAdmin();
			this.choixAdministrateur();
		}

		if (choiceAdmin == 2) {
			this.removeAdmin();
			this.choixAdministrateur();
		}

		if (choiceAdmin == 3) {
			this.addProf();
			this.choixAdministrateur();
		}

		if (choiceAdmin == 4) {
			this.removeProf();
			this.choixAdministrateur();
		}

		if (choiceAdmin == 5) {
			this.monIHM.afficherListeAdmin(this.listAdministrateurs);
			this.choixAdministrateur();
		}

		if (choiceAdmin == 6) {
			this.monIHM.afficherListeProf(this.listProfesseurs);
			this.choixAdministrateur();
		}

		if (choiceAdmin == 7) {
		}

	}

	
	/**
	 * Supprime un professeur de la liste.
	 */
	private void removeProf() {
		String loginProf = this.monIHM.inputProf2();
		if (loginProf != null) {
			int index = this.searchLoginProfesseur(this.listProfesseurs,loginProf);
			System.out.println(index);
			if (index >= 0) {
				Professeur prof = this.listProfesseurs.get(index);
				this.listProfesseurs.remove(prof);
				this.monIHM.displayProfRemoved(prof);
			} else
				this.monIHM.inputProf2Invalide();
		} else {
			this.monIHM.inputProf2Invalide();
		}
	}

	
	/**
	 * recherche le login d'un professeur dans la liste.
	 * 
	 * @param liste
	 * @param loginPersonne
	 * @return index (ou -1 si le login n'existe pas)
	 */
	private int searchLoginProfesseur(List<Professeur> liste,
			String loginPersonne) {
		if (!liste.isEmpty()) {
			int index = 0;
			String login = liste.get(index).getLogin();
			while (index + 1 < liste.size() && !login.equals(loginPersonne)) {
				index++;
				login = liste.get(index).getLogin();
			}
			if (login.equals(loginPersonne)) {
				return index;
			}
		}
		return -1;

	}

	
	/**
	 * Supprime un administrateur de la liste
	 */
	private void removeAdmin() {
		String loginAdmin = this.monIHM.inputAdmin2();
		if (loginAdmin != null) {
			int index = this.searchLoginAdministrateur(
					this.listAdministrateurs, loginAdmin);
			if (index >= 0) {
				Administrateur admin = this.listAdministrateurs.get(index);
				this.listAdministrateurs.remove(admin);
				this.monIHM.displayAdminRemoved(admin);
			} else
				this.monIHM.inputAdmin2Invalide();
		} else {
			this.monIHM.inputAdmin2Invalide();
		}
	}

	
	/**
	 * recherche le login d'un administrateur dans la liste.
	 * 
	 * @param liste
	 * @param loginPersonne
	 * @return index (ou -1 si le login n'existe pas)
	 */
	private int searchLoginAdministrateur(List<Administrateur> liste,
			String loginPersonne) {
		if (!liste.isEmpty()) {
			int index = 0;
			String login = liste.get(index).getLogin();
			while (index + 1 < liste.size() && !login.equals(loginPersonne)) {
				index++;
				login = liste.get(index).getLogin();
			}
			if (login.equals(loginPersonne)) {
				return index;
			}
		}
		return -1;

	}

	
	/**
	 * Ajoute un professeur dans la liste.
	 */
	private void addProf() {
		Professeur professeur = this.monIHM.inputProf();
		if (professeur != null) {
			if (rechercheProfesseurListe(professeur.getLogin(), professeur.getPassword()) != null){
				this.monIHM.newAddedPersonneExists();
			} else{
				this.listProfesseurs.add(professeur);
				this.monIHM.displayNewProfAdded(professeur);
			}
		}
	}

	/**
	 * Recherche un professeur en fonction de son login ou de son mot de passe.
	 * 
	 * @param login
	 * @param password
	 * @return current teacher (ou null)
	 */
	private Professeur rechercheProfesseurListe(String login, String password) {
		Iterator<Professeur> iterator = this.listProfesseurs.iterator();
		while (iterator.hasNext()) {
			Professeur currentTeacher = iterator.next();
			if (currentTeacher.getLogin().equals(login)) {
					return currentTeacher;
				}
			}
		return null;
	} 

	/**
	 * Ajoute un administrateur dans la liste.
	 */
	private void addAdmin() {
		Administrateur administrateur = this.monIHM.inputAdmin();
		if (administrateur != null) {
			if (rechercheAdministrateurListe(administrateur.getLogin(), administrateur.getPassword()) != null){
				this.monIHM.newAddedPersonneExists();
			} else {
				this.listAdministrateurs.add(administrateur);
				this.monIHM.displayNewAdminAdded(administrateur);
			}
		}
	}

	/**
	 * Recherche un administrateur en fonction de son login ou de son mot de passe.
	 * 
	 * @param login
	 * @param password
	 * @return currentAdministrator (ou null)
	 */
	private Administrateur rechercheAdministrateurListe(String login, String password) {
		Iterator<Administrateur> iterator = this.listAdministrateurs.iterator();
		while (iterator.hasNext()) {
			Administrateur currentAdministrator = iterator.next();
			if (currentAdministrator.getLogin().equals(login)) {
					return currentAdministrator;
				}
			}
		return null;
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
				this.actionsAdmin();
			}

			if (choice == 2) {

				this.monIHM.affichageIdProfesseur();
				this.actionsProf();
			}

			if (choice == 3) {
				this.quit();
			}

		}

	}

	public void quit() {
		this.fileManagerAdmin.writeFileAdministrateurs((LinkedList<Administrateur>) this.listAdministrateurs);
		this.fileManagerEtudiant.writeFileEtudiants((LinkedList<Etudiant>) this.listEtudiants);
		this.fileManagerProf.writeFileProfesseurs((LinkedList<Professeur>) this.listProfesseurs);
		System.exit(0);
	}

	public String displayListAdmin(List<Administrateur> listAdmin) {
		StringBuilder string = new StringBuilder();
		for (Administrateur admin : listAdmin) {
			string.append(admin.prenom+" "+admin.nom);
			string.append("\n");	
		}
		return string.toString();
	}
	
	public void actionsAdmin() {
		Administrateur admin = this.identificationAdministrateur();
		if (admin != null) {
			this.monIHM.idValide(admin);
			this.choixAdministrateur();
		} else {
			this.monIHM.idInvalide();
		}
	}

	public String displayListProf(List<Professeur> listProf) {
		StringBuilder string = new StringBuilder();
		for (Professeur prof : listProf) {
			string.append(prof.prenom+" "+prof.nom);
			string.append("\n");	
		}
		return string.toString();
	}

	public void actionsProf() {
		Professeur prof = this.identificationProfesseur();
		if (prof != null) {

			this.monIHM.idValide(prof);
			this.debutCours(this.creationCours());

		} else {
			this.monIHM.idInvalide();
		}
	}

	public String displayListEtudiants(LinkedList<Etudiant> list) {
		StringBuilder string = new StringBuilder();
		for (Etudiant etudiant : list) {
			string.append(etudiant.prenom+" "+etudiant.nom);
			string.append("\n");	
		}
		return string.toString();
	}

}
