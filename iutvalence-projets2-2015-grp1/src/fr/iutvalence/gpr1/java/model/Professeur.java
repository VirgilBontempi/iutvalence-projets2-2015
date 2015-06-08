package fr.iutvalence.gpr1.java.model;

import java.util.Scanner;

/** Classe Professeur. */
public class Professeur extends Personne {

	public Professeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}

	
	public String toString(){
		return this.nom+", "+this.prenom+", "+this.login+", "+this.password+" /";
	}
}
