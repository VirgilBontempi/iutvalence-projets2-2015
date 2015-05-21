package fr.iutvalence.gpr1.java;

import java.util.Scanner;

public class Etudiant {
	
	private String nom;
	
	private String prenom;
	
	private String gprTp;
	
	private int numEtudiant;
	
	private boolean absence = true;
	
	private String login;
	
	private String password;
	
	private int nbrAbsence;
	
	
	public Etudiant(String nom, String prenom, String gprTp, int numEtudiant, boolean absence, String login, String password, int nbrAbsence) {
	this.nom = nom;
	this.prenom = prenom;
	this.gprTp = gprTp;
	this.numEtudiant = numEtudiant;
	this.absence = absence;
	this.login = login;
	this.password = password;
	this.nbrAbsence = nbrAbsence;
	}
	
	/**
	 * Identifie un Etudiant et change le statut 'absent' en 'non absent'.
	 * @return login
	 */

	public void identificationEtudiant(){
		
		this.absence = true;
		System.out.println("Saisissez vos identifiants");
		Scanner scanner = new Scanner(System.in);
		String login = scanner.nextLine();
		String password = scanner.nextLine();
		
		Liste_Etudiants etudiants = new Liste_Etudiants();
		
		Etudiant etudiant_retourne = etudiants.getEtudiant(login);
		
		if(etudiant_retourne != null)
		{
		if(etudiant_retourne.password == this.password) absence = false;
		}
		
	}
	
	/**
	 * Compteur du nombre d'absence en foncion du statut 'absent' après dentification.
	 * @return nbrAbsence
	 */
	public int getNbrAbsence(){
		return this.nbrAbsence;
	}

	public String login() {
		
		return this.login;
	}


}
