package fr.iutvalence.gpr1.java;

import java.util.Scanner;

public class Administrateur {
	private String nom;
	private String login;
	private String password;
	
	/**
	 * Identifie un Admin.
	 * @return login
	 */
	public String identificationAdministrateur(){
		System.out.println("Saisissez vos identifiants");
		Scanner scanner = new Scanner(System.in);
		String login = scanner.next();
		String password = scanner.next();
		//TODO Faire l'esception "le login n'est pas dans la liste"
		return login;
	}
	
	public void ajoutAdministrateur(String login, String motDePasse){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	public void suppressionAdministrateur(String login){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	public void ajoutProfesseur(String login, String motDePasse){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	public void suppressionProfesseur(String login){
		//TODO Faire la méthode (besoin des login de la liste)
	}

}
