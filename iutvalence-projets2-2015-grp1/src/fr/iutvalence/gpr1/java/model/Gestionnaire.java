package fr.iutvalence.gpr1.java.model;

import java.util.Scanner;

import fr.iutvalence.gpr1.java.view.IHM;

/** Classe Gestionnaire */
public class Gestionnaire {
	
	private IHM monIHM;
	
	public Gestionnaire(IHM monIHM){
		this.monIHM = monIHM;
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
		
		Liste_Etudiants listEtudiants = new Liste_Etudiants();
		
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


