package fr.iutvalence.gpr1.java.model;

import java.util.Scanner;

/** Classe Professeur. */
public class Professeur extends Personne {

	public Professeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}

	
	public String toString(Professeur prof){
		return prof.getNom()+", "+prof.getPrenom()+", "+prof.getLogin()+", "+prof.getPassword()+" /";
	}
}
