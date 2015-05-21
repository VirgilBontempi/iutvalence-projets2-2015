package fr.iutvalence.gpr1.java;

import java.util.Scanner;

public class Professeur {
	
	private String nom;
	
	private String login;
	
	private String password;
	
	/**
	 * Identfie un Professeur.
	 * @return login un identifiqnt
	 */
	public String identificationProfesseur(){
		System.out.println("Saisissez vos identifiants");
		Scanner scanner = new Scanner(System.in);
		String login = scanner.next();
		String password = scanner.next();
		//TODO Faire l'esception "le login n'est pas dans la liste"
		return login;
	}
	
	/**
	 * Saisie une heure de cours.
	 * @return heure une heure
	 */
	public float saisieHorraire(){
		//entrer l'heure de la façon suivante: "h,m"
		System.out.println("Saisissez l'heure de la façon suivante: 'h,m'");
		Scanner scanner = new Scanner(System.in);
		float heure = scanner.nextFloat();
		return heure;
	}
	
	/**
	 * Saisie un groupe d'étudiants.
	 * @return grpTP un groupe de TP
	 */
	public String choixGroupeEtudiant(){
		System.out.println("Saisissez un groupe d'étudiants");
		Scanner scanner = new Scanner(System.in);
		String grpTp = scanner.next();
		return grpTp;
	}
	
	public void saisieTypeCours(String getTypeCours){
		//TODO Faire la méthode
	}
	
	public void saisieNomCours(String getLibelle){
		//TODO Faire la méthode
	}

}
