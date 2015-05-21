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
	
	/**
	 * Saisie un type de cours.
	 * @return getTypeCours un type de cours (CM, TD ou TP)
	 */
	public String saisieTypeCours(){
		System.out.println("Saisissez un type de cours");
		Scanner scanner = new Scanner(System.in);
		String getTypeCours = scanner.next();
		return getTypeCours;
	}
	
	/**
	 * Saisie un libellé de cours.
	 * @return getLibelle un libellé de cours
	 */
	public String saisieNomCours(){
		//TODO Faire la méthode
		System.out.println("Saisissez le nom du cours");
		Scanner scanner = new Scanner(System.in);
		String getLibelle = scanner.next();
		return getLibelle;
	}

}
