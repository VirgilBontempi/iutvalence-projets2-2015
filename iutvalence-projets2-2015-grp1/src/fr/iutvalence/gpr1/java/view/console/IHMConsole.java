package fr.iutvalence.gpr1.java.view.console;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.gpr1.java.model.Administrateur;
import fr.iutvalence.gpr1.java.model.Etudiant;
import fr.iutvalence.gpr1.java.model.ListePersonnes;
import fr.iutvalence.gpr1.java.model.Personne;
import fr.iutvalence.gpr1.java.model.Professeur;
import fr.iutvalence.gpr1.java.view.IHM;

public class IHMConsole implements IHM {

	Scanner scanner = new Scanner(System.in);

	/**
	 * Saisie un login.
	 */
	public String saisieLogin() {
		System.out.println("Saisissez vos identifiants");
		return scanner.nextLine();
	}

	/**
	 * Saisie un mot de passe.
	 */
	public String saisiePassword() {
		return scanner.nextLine();
	}

	@Override
	public int showMenu() {
		System.out.println("Choisissez votre interface:");
		System.out.println("1 -> Je suis un Administrateur");
		System.out.println("2 -> Je suis un Professeur");
		System.out.println("3 -> Quitter l'application");

		String index = "";
		do {
			index = scanner.nextLine();
		} while (!this.isNumeric(index));
		int choice = Integer.parseInt(index);
		if (choice < 4 && choice > 0)
			return choice;
		System.out.println("Votre choix est invalide");
		return this.showMenu();
	}

	/**
	 * Verifie que le paramètre est un entier.
	 * 
	 * @param string
	 * @return boolean
	 */
	public boolean isNumeric(String string) {
		try {
			int value = Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public void affichageIdAdministrateur() {
		System.out.println("Bienvenu Administrateur, veuillez vous identifier");
	}

	@Override
	public void affichageIdProfesseur() {
		System.out.println("Bienvenu Professeur, veuillez vous identifier");
	}

	@Override
	public void affichageIdEtudiant() {
		System.out.println("Bienvenu Etudiant, veuillez vous identifier");
	}

	@Override
	public void idValide(Personne personne) {
		System.out.println("Bonjour " + personne.getPrenom() + " "
				+ personne.getNom());

	}

	@Override
	public void idInvalide() {
		System.out.println("Identifiants invalides");

	}

	@Override
	public void elevePresent() {
		System.out.println("Vous avez été noté présent");
	}

	@Override
	public String saisieTypeCours() {
		System.out.println("De quel type est votre cours ? (CM, TD ou TP)");
		String typeCours = scanner.nextLine();
		if (typeCours.equalsIgnoreCase("CM")
				|| typeCours.equalsIgnoreCase("TD")
				|| typeCours.equalsIgnoreCase("TP")) {
			return typeCours;
		}
		System.out.println("Le type de cours est invalide");
		return this.saisieTypeCours();
	}

	@Override
	public String saisieLibelleCours() {
		System.out.println("Choisissez le libellé de votre cours ?");
		return scanner.nextLine();
	}

	@Override
	public String saisieGrpTp() {
		System.out
				.println("Saisissez le groupe de TP avec lequel vous avez cours ? (Exemple: F)");
		String grpTp = scanner.nextLine();

		if (grpTp.equalsIgnoreCase("A")) {
			grpTp = "A";
			return grpTp;
		}

		else if (grpTp.equalsIgnoreCase("B")) {
			grpTp = "B";
			return grpTp;
		}

		else if (grpTp.equalsIgnoreCase("C")) {
			grpTp = "C";
			return grpTp;
		} else if (grpTp.equalsIgnoreCase("D")) {
			grpTp = "D";
			return grpTp;
		}

		else if (grpTp.equalsIgnoreCase("E")) {
			grpTp = "E";
			return grpTp;
		}

		else if (grpTp.equalsIgnoreCase("F")) {
			grpTp = "F";
			return grpTp;
		}

		System.out.println("Le groupe de TP est invalide");

		return this.saisieGrpTp();
	}

	@Override
	public String saisieGrpTd() {
		System.out
				.println("Choisissez le groupe de TD avec lequel vous avez cours ? (Exemple: 3)");
		String index = "";
		do {
			index = scanner.nextLine();
		} while (!this.isNumeric(index));
		int grpTd = Integer.parseInt(index);
		if (grpTd < 4 && grpTd > 0)
			return index;
		System.out.println("Le groupe de TD est invalide");
		return this.saisieGrpTd();
	}

	@Override
	public int menuCours() {
		System.out.println("Voulez vous arrêter le cours:");
		System.out.println("1 -> Oui");
		System.out.println("2 -> Non");
		String index = "";
		do {
			index = scanner.nextLine();
		} while (!this.isNumeric(index));
		int choiceCours = Integer.parseInt(index);
		if (choiceCours < 3 && choiceCours > 0)
			return choiceCours;
		System.out.println("Votre choix est invalide");
		return this.menuCours();
	}

	@Override
	public void affichageIdProfesseur2() {
		System.out
				.println("Re-bonjour Professeur, veuillez vous identifier pour valider votre choix");
	}

	@Override
	public int adminMenu() {
		System.out.println("Que souhaitez vous faire ?");
		System.out.println("1 -> Ajouter un Administrateur");
		System.out.println("2 -> Supprimer un Administrateur");
		System.out.println("3 -> Ajouter un Professeur");
		System.out.println("4 -> Supprimer un Professeur");
		System.out.println("5 -> Voir la liste des administrateur");
		System.out.println("6 -> Voir la liste des professeurs");
		System.out.println("7 -> Retour à l'interface principale");
		String index = "";
		do {
			index = scanner.nextLine();
		} while (!this.isNumeric(index));
		int choiceAdmin = Integer.parseInt(index);
		if (choiceAdmin < 8 && choiceAdmin > 0)
			return choiceAdmin;
		System.out.println("Votre choix est invalide");
		return this.adminMenu();
	}

	/**
	 * Ajoute un administrateur à la liste Administrateur.
	 */
	public Administrateur inputAdmin() {
		System.out.println("Saisissez le nom du nouvel administrateur");
		String indexNom = null;
		indexNom = scanner.nextLine();
		System.out.println("Saisissez le prénom du nouvel administrateur");
		String indexPrenom = null;
		indexPrenom = scanner.nextLine();
		System.out.println("Saisissez le login du nouvel administrateur");
		String indexLogin = null;
		indexLogin = scanner.nextLine();
		System.out
				.println("Saisissez le mot de passe du nouvel administrateur");
		String indexPassword = null;
		indexPassword = scanner.nextLine();

		return new Administrateur(indexNom, indexPrenom,indexLogin, indexPassword);

	}

	@Override
	public void affichageListeAbsence(LinkedList<Etudiant> listAbs) {
		System.out.println("Voici la liste des absents");
		for (Etudiant currentStudent : listAbs) {
			System.out.println(currentStudent.getNom() + " "
					+ currentStudent.getPrenom());
		}
	}

	/**
	 * Supprime un administrateur de la liste Administrateur.
	 */
	public void removeAdmin() {
		File listAdmin = new File("ListeAdministrateur.txt");
		ListePersonnes fichierAdmin = new ListePersonnes(listAdmin);
		Administrateur adminCourant;
		System.out.println("Saisissez le login de l'administrateur à supprimer");
		String login;
		login = scanner.nextLine();

		try {
			for (int curseur = 0; curseur < fichierAdmin
					.getListAdministrateurs().size(); curseur++) {

				adminCourant = fichierAdmin.getListAdministrateurs().get(
						curseur);

				if (adminCourant.getLogin() == login)
					fichierAdmin.getListAdministrateurs().remove(curseur);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			fichierAdmin.writeFileAdministrateurs(fichierAdmin
					.getListAdministrateurs());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Affiche la liste des Administrateur.
	 */
	public void afficherListeAdmin(List<Administrateur> listAdmin) {
		System.out.println("Voici la liste des administrateurs");
		for (Administrateur currentAdmin : listAdmin) {
			System.out.println(currentAdmin.getNom() + " "
					+ currentAdmin.getPrenom());
		}
	}

	@Override
	public Professeur inputProf() {
		System.out.println("Saisissez le nom du nouveau professeur");
		String indexNom = null;
		indexNom = scanner.nextLine();
		System.out.println("Saisissez le prénom du nouveau professeur");
		String indexPrenom = null;
		indexPrenom = scanner.nextLine();
		System.out.println("Saisissez le login du nouveau professeur");
		String indexLogin = null;
		indexLogin = scanner.nextLine();
		System.out
				.println("Saisissez le mot de passe du nouveau professeur");
		String indexPassword = null;
		indexPassword = scanner.nextLine();

		return new Professeur(indexNom, indexPrenom,indexLogin, indexPassword);

	}

	@Override
	public void removeProf() {
		File listProf = new File("ListeProfesseurs.txt");
		ListePersonnes fichierProf = new ListePersonnes(listProf);
		Professeur profCourant;
		System.out.println("Saisissez le login du professeur à supprimer");
		String login;
		login = scanner.nextLine();

		try {
			for (int curseur = 0; curseur < fichierProf.getListProfesseurs()
					.size(); curseur++) {

				profCourant = fichierProf.getListProfesseurs().get(curseur);

				if (profCourant.getLogin() == login)
					fichierProf.getListProfesseurs().remove(curseur);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			fichierProf.writeFileProfesseurs(fichierProf.getListProfesseurs());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void afficherListeProf(List<Professeur> listProf) {
		System.out.println("Voici la liste des professeurs");
		for (Professeur currentProf : listProf) {
			System.out.println(currentProf.getNom() + " "
					+ currentProf.getPrenom());
		}
	}

	@Override
	public void displayNewAdminAdded(Administrateur newAdmin) {
		System.out.println("L'administrateur " + newAdmin
			+ " a bien été créé");
	}

	@Override
	public void displayNewProfAdded(Professeur newProf) {
		System.out.println("Le professeur " + newProf
				+ " a bien été créé");
	}

	@Override
	public String inputAdmin2() {
		System.out.println("Saisissez le login de l'administrateur à supprimer");
		String indexLogin = null;
		indexLogin = scanner.nextLine();
		
		return indexLogin;
	}

	@Override
	public void displayAdminRemoved(Administrateur adminRemoved) {
		System.out.println("L'administrateur " + adminRemoved
				+ " a bien été supprimé");
	}

	@Override
	public String inputProf2() {
		System.out.println("Saisissez le login du professeur à supprimer");
		String indexLogin = null;
		indexLogin = scanner.nextLine();
		
		return indexLogin;
	}

	@Override
	public void displayProfRemoved(Professeur profRemoved) {
		System.out.println("Le professeur " + profRemoved
				+ " a bien été supprimé");
	}

	@Override
	public void inputAdmin2Invalide() {
		System.out.println("L'administrateur saisie n'existe pas");
		
	}

	@Override
	public void inputProf2Invalide() {
		System.out.println("Le professeur saisie n'existe pas");
		
	}

	@Override
	public void newAddedPersonneExists() {
		System.out.println("Ce login est déja pris ou ce mot de passe existe déja");
		
	}
}
