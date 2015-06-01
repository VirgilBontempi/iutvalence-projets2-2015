package fr.iutvalence.gpr1.java.model;

public class Personne
{
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	public Personne(String nom, String prenom, String login, String password){
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = login;
	}
	
	public String nom(){
		return this.nom;
	}
	
	public String prenom(){
		return this.prenom;
	}
	
	public String login() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	

}
