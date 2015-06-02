package fr.iutvalence.gpr1.java.model;

import java.lang.reflect.Array;
import java.util.Arrays;

/** Classe Administrateur. */
public class Administrateur extends Personne {
	
	private Liste_Admin listeAdmin;
	
	/** Constructeur d'un administrateur. */
	public Administrateur(String nom,String prenom, String login,String password){
		super(nom, prenom, login, password);
	}
	
	
	/** Ajoute un administrateur */
	public void ajoutAdministrateur(String nom,String login, String motDePasse){
	int i=0;
	while(listeAdmin.getAdmin()[i]!=null){
		i++;
	}
	//listeAdmin.getAdmin()[i]= new Administrateur(nom,login,motDePasse);
	//on est plus sur un tableau mais sue une liste !
	}
	
	/** Supprime un administrateur. */
	public void suppressionAdministrateur(String nom,String login, String motDePasse){
		int i=0;
	//	while(listeAdmin.getAdmin()[i]!= new Administrateur(nom,login,motDePasse)){
			i++;
	//on est plus sur un tableau mais sue une liste !
		}
		//TODO Supprimer un element de la liste 
		//		listeAdmin.getAdmin()[i] = ;
	
	/** Ajoute un professeur. */
	public void ajoutProfesseur(String login, String motDePasse){
		//TODO Faire la méthode (besoin des login de la liste)
	}
	
	/** Supprime un professeur. */
	public void suppressionProfesseur(String login){
		//TODO Faire la méthode (besoin des login de la liste)
	}

}
