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
	
	/**
	 * Identifie un Etudiant et change le statut 'absent' en 'non absent'.
	 * @return login
	 */
	public String identificationEtudiant(){
		//si identifié, absence = false
		System.out.println("Saisissez vos identifiants");
		Scanner scanner = new Scanner(System.in);
		String login = scanner.next();
		String password = scanner.next();
		//TODO Faire l'esception "le login n'est pas dans la liste"
		absence = false;
		return login;
	}
	
	/**
	 * Compteur du nombre d'absence en foncion du statut 'absent' après dentification.
	 * @return nbrAbsence
	 */
	public int getNbrAbsence(){
		int nbrAbsence = 0;
		//apres pointageTerminé, nbrabsence = nbrabsence+1 si absence = true
		// sinon, nbrabsence = nbrabsence
		if(absence == true){
			nbrAbsence = this.nbrAbsence+1;
		}
		nbrAbsence = this.nbrAbsence;
		return nbrAbsence;
	}


}
