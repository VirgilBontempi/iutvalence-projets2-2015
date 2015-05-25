package fr.iutvalence.gpr1.java.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Administrateur {
	private String nom;
	private String login;
	private String password;
	private Liste_Admin listeAdmin;
	
	public Administrateur(String nom,String login,String password){
		this.nom=nom;
		this.login=login;
		this.password=password;
	}
	
	
	
	public void ajoutAdministrateur(String nom,String login, String motDePasse){
	int i=0;
	while(listeAdmin.getAdmin()[i]!=null){
		i++;
	}
	listeAdmin.getAdmin()[i]= new Administrateur(nom,login,motDePasse);
	}
	
	public void suppressionAdministrateur(String nom,String login, String motDePasse){
		int i=0;
		while(listeAdmin.getAdmin()[i]!= new Administrateur(nom,login,motDePasse)){
			i++;
		}
		//TODO Supprimer un element de la liste 
		//		listeAdmin.getAdmin()[i] = ;
	}

	public void ajoutProfesseur(String login, String motDePasse){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	public void suppressionProfesseur(String login){
		//TODO Faire la méthode (besoin des login de la liste)
	}

}
