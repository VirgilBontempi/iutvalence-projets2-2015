package fr.iutvalence.gpr1.java.view.console;

import java.util.Scanner;

import fr.iutvalence.gpr1.java.model.Gestionnaire;
import fr.iutvalence.gpr1.java.model.Personne;
import fr.iutvalence.gpr1.java.view.IHM;

public class IHMConsole implements IHM {

	Scanner scanner = new Scanner(System.in);

	public String saisieLogin() {
		System.out.println("Saisissez vos identifiants");
		return scanner.nextLine();
	}

	public String saisiePassword() {
		return scanner.nextLine();
	}

	@Override
	public int showMenu() {
		System.out.println("Choisissez votre interface:");
		System.out.println("1 -> Je suis un Administrateur");
		System.out.println("2 -> Je suis un Professeur");
		System.out.println("3 -> Je suis un Etudiant");
		String index = "";
		do {
			index = scanner.nextLine();
		} while (!this.isNumeric(index));
		int choice = Integer.parseInt(index);
		if(choice < 4 && choice > 0)
			return choice;
		System.out.println("Votre choix est invalide");
		return this.showMenu();
	}

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
		System.out.println("Bonjour " + personne.getPrenom() + " " + personne.getNom());
		
	}

	@Override
	public void idInvalide() {
		System.out.println("Identifiants invalides");
		
	}
}