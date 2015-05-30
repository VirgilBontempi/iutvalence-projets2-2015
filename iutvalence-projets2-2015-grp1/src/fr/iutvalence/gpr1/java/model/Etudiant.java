package fr.iutvalence.gpr1.java.model;

import java.util.Scanner;

/** Classe Etudiant. */
public class Etudiant {
	
	public static final int NBR_ABSENCE_BY_DEFAULT = 0;
	
	private String nom;
	
	private String prenom;
	
	private String gprTp;
	
	private int numEtudiant;
	
	private boolean absence;
	
	private String login;
	
	private String password;
	
	private int nbrAbsence;
	
	
	public Etudiant(String nom, String prenom, String gprTp, int numEtudiant,boolean absence, String login, String password,int nbrAbsence) {
	this.nom = nom;
	this.prenom = prenom;
	this.gprTp = gprTp;
	this.numEtudiant = numEtudiant;
	this.absence = true;
	this.login = login;
	this.password = password;
	this.nbrAbsence = NBR_ABSENCE_BY_DEFAULT;
	}
	
	/**
	 * Compteur du nombre d'absence en foncion du statut 'absent' après dentification.
	 * @return nbrAbsence
	 */
	public int getNbrAbsence(){
		return this.nbrAbsence;
	}
	
	/** Getter d'une absence. */
	public boolean getAbsence() {
		return this.absence;
	}

	/** Setter d'une absence. */
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	public String login() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	/** Ajoute une absence. */
	public void addAbsence() {
		this.nbrAbsence = this.nbrAbsence++;
	}


}
