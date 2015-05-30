package fr.iutvalence.gpr1.java.model;

import java.lang.reflect.Array;
import java.util.Arrays;

/** Classe Administrateur. */
public class Administrateur {
	private String nom;
	private String login;
	private String password;
	private Liste_Admin listeAdmin;
	
	/** Constructeur d'un administrateur. */
	public Administrateur(String nom,String login,String password){
		this.nom=nom;
		this.login=login;
		this.password=password;
	}
	
	
	/** Ajoute un administrateur */
	public void ajoutAdministrateur(String nom,String login, String motDePasse){
	int i=0;
	while(listeAdmin.getAdmin()[i]!=null){
		i++;
	}
	listeAdmin.getAdmin()[i]= new Administrateur(nom,login,motDePasse);
	}
	
	/** Supprime un administrateur. */
	public void suppressionAdministrateur(String nom,String login, String motDePasse){
		int i=0;
		while(listeAdmin.getAdmin()[i]!= new Administrateur(nom,login,motDePasse)){
			i++;
		}
		//TODO Supprimer un element de la liste 
		//		listeAdmin.getAdmin()[i] = ;
	}
	
	/** Ajoute un professeur. */
	public void ajoutProfesseur(String login, String motDePasse){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	/** Supprime un professeur.S */
	public void suppressionProfesseur(String login){
		//TODO Faire la méthode (besoin des login de la liste)
	}

}
