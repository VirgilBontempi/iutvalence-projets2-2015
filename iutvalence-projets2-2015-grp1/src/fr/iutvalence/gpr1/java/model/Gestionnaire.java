package fr.iutvalence.gpr1.java.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;

/** Classe Gestionnaire */
public class Gestionnaire {
	
	private IHM monIHM;
	
	private List<Etudiant> listEtudiants;
	private List<Professeur> listProfesseurs;
	
	
	public Gestionnaire(IHM monIHM, File fichierEtudiants, File fichierProfesseurs){
		this.monIHM = monIHM;
		ListePersonnes fichierEtudiant = new ListePersonnes(fichierEtudiants);
		try
		{
			this.listEtudiants=fichierEtudiant.getEtudiants();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		ListePersonnes fichierProfesseur = new ListePersonnes(fichierProfesseurs);
		try
		{
			this.listProfesseurs = fichierProfesseur.getProfesseurs();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Identifie un Admin.
	 * @return login
	 */
	public void identificationAdministrateur(){
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		//TODO Faire l'exception "le login n'est pas dans la liste"
	}
	
	/**
	 * Identfie un Professeur.
	 * @return login un identifiqnt
	 */
	public void identificationProfesseur(){
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		//TODO Faire l'esception "le login n'est pas dans la liste"
	}
	
	/**
	 * Identifie un Etudiant et change le statut 'absent' en 'non absent'.
	 * @return login
	 */
	public void identificationEtudiant(){
		String login = this.monIHM.saisieLogin();
		String password = this.monIHM.saisiePassword();
		
		Etudiant etudiant_retourne = listEtudiants.getEtudiant(login);
		
		if(etudiant_retourne != null)
		{
			if(etudiant_retourne.getPassword() == password) etudiant_retourne.setAbsence(false);
		}
		
	}
		
		/** Valide une absence. */
		private void determinerAbsence(){
			//TODO Faire la méthode
		}
	
		/** Valide une identification. */
		private void validationIdentification(){
			//TODO Faire la méthode
			// si login = login et password = password, id valide
		}
	
		private void ajoutPresent(){
			//TODO Faire la méthode
		}
			
	}


